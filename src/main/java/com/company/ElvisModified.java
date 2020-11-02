package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ElvisModified {
    private static boolean flag = false;

    private ElvisModified(){
        /*
        synchronized(ElvisModified.class)
        {
            if(flag == false)
            {
                flag = !flag;
            }
            else
            {
                throw new RuntimeException("单例模式被侵犯！");
            }
        }
         */
    }
    private void method(int temp){
        System.out.println("method"+temp);
    }
    private static void staticMethod(){
        System.out.println("static method");
    }
    private static class SingletonHolder{
        private static final ElvisModified INSTANCE = new ElvisModified();
    }

    public static ElvisModified getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    public void doSomethingElse()
    {

    }

    public static void main(String[] args)
    {
        try
        {

            //Class<ElvisModified> classType = ElvisModified.class;
            //Constructor<ElvisModified> c = classType.getDeclaredConstructor(null);
            Class clz = Class.forName("com.company.ElvisModified");
            Constructor<ElvisModified> c = clz.getDeclaredConstructor(null);
            c.setAccessible(true);
            Method method = clz.getDeclaredMethod("method",int.class);
            Method staticMethod = clz.getDeclaredMethod("staticMethod");
            ElvisModified e1 = (ElvisModified)c.newInstance();
            ElvisModified e2 = ElvisModified.getInstance();
            method.invoke(e2,4);
            staticMethod.invoke(e1);
            System.out.println(e1==e2);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
