package org.trlove.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * Created by aguda on 16/6/30.
 */
public class Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        /*Test test = new Test();
        Demo demo = test.new Demo();
        System.out.println(demo.getClass().getName());
        Class clazz1 = null;
        try {
            clazz1 = Class.forName("org.trlove.reflect.Test$Demo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(clazz1.getName());
        System.out.println(clazz1 == Demo.class);
//        Demo demo1 = (Demo) clazz1.newInstance();
//        demo1.setAge(10);
//        demo1.setName("xxx");

        Constructor[] cons = clazz1.getConstructors();
        Constructor con = cons[0];
        Constructor con1 = cons[1];
        TypeVariable[] typeVariables = con.getTypeParameters();
        for(TypeVariable element : typeVariables) {
//            element.getBounds()
        }
        Demo demo1 = (Demo) cons[0].newInstance();

        Class[] interfaces = clazz1.getInterfaces();
        System.out.println(cons.length);
        System.out.println(interfaces.length);*/
        InterfaceA a = new ClassA();
        System.out.println(a.getClass().getName());
    }

    class Demo {
        private String name;

        private int age;

        public Demo() {
        }

        public Demo(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
