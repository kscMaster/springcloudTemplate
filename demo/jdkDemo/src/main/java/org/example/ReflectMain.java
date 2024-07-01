package org.example;


import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMain {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //使用反射机制调用方法
        Class stud = Class.forName("com.example.demo.Student");
        // 创建对象
        Object obj = stud.newInstance();
        // 获取Method
        Method sayHello = stud.getDeclaredMethod("sayHello", int.class);
//
        Object resValues = sayHello.invoke(obj, 2);
        System.out.println(resValues);
    }
}
@Data
class Student implements Cloneable{
    private int no;
    public int sayHello(int no) {
        System.out.println("hello" + no);
        return no;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}



class Person {
    public String name;
}