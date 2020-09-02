package org.firewater.compile_code;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InitClass {
    private static String crlf="\r\n";
    public static String generatorCode(){
        StringBuffer sb=new StringBuffer();
        sb.append("package org.firewater.compile_code;").append(crlf);
        sb.append("public class SimpleClass1 implements  ClassInterface{").append(crlf)
                .append("private int a;").append(crlf)
                .append("private int b;").append(crlf)
                .append("private String c;").append(crlf)
                .append("public SimpleClass1(int a, int b, String c) {").append(crlf)
                .append("this.a = a;").append(crlf)
                .append("this.b = b;").append(crlf)
                .append("this.c = c;").append(crlf)
                .append("}").append(crlf)
                .append("public int add(){").append(crlf)
                .append("int d=this.a+this.b;").append(crlf)
                .append("System.out.println(\"d====:“\"+d+\"”\");").append(crlf)
                .append(" return d;").append(crlf)
                .append("}").append(crlf)
                .append("public void printString(){").append(crlf)
                .append("System.out.println(\"c====:“\"+c+\"”\");").append(crlf)
                .append("}").append(crlf)
                .append("}").append(crlf);
        return sb.toString();
    }
    public static Object newObjectInstance() throws IOException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchMethodException {
        //生成Java 源码
        String code = generatorCode();
        //输出到磁盘
        String filePath = InitClass.class.getResource("").getPath();
        File f = new File(filePath + "SimpleClass1.java");
        FileWriter fw = new FileWriter(f);
        fw.write(code);
        fw.flush();
        fw.close();

        //编译成class
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager manage = compiler.getStandardFileManager(null,null,null);
        Iterable iterable = manage.getJavaFileObjects(f);
        JavaCompiler.CompilationTask task = compiler.getTask(null,manage,null,null,null,iterable);
        task.call();
        manage.close();

        //使用类加载机制加载class
        FireWaterClassLoader classLoader=new  FireWaterClassLoader();

        Class clazz =    classLoader.findClass("SimpleClass1");
        Constructor c = clazz.getConstructor(int.class,int.class,String.class);
        f.delete();
        Object o = c.newInstance(1, 2,"3333");
        return o;
    }

}
