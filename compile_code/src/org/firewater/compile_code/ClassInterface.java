package org.firewater.compile_code;
/*
* 用于得到了类实例后，来使用方法，否则编译会出错，无法执行自定义类的方法
* */
public interface ClassInterface {
    public int add();
    public void printString();
}
