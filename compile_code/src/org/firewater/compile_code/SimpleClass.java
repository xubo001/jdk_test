package org.firewater.compile_code;
/*
一个简单的类，后面会将这个类的代码通过字符串进行编译，并加载执行
这里只是测试这个类没有编译错误
* */
public class SimpleClass implements  ClassInterface{
    private int a;
    private int b;
    private String c;


    public SimpleClass(int a, int b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int add(){
        int d=this.a+this.b;
        System.out.println("d====:“"+d+"”");
        return d;
    }
    public void printString(){
        System.out.println("c====:“"+c+"”");
    }
}
