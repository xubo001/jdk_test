package org.firewater.compile_code;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class TestMain {
    public static void main(String[] args)  {
        try {
            ClassInterface classInterface=(ClassInterface)InitClass.newObjectInstance();
            classInterface.add();
            classInterface.printString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
