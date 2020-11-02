package com.company;

public class Singleton {
    public static final Singleton getINSTANCE(){
        return SingletonInner.INSTANCE;
    }
    private static class SingletonInner {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton(){}
}


























/*
private static volatile Singleton singleton;
    private Singleton(){

    }
    public static final Singleton getSingleton(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
    private static class StaticSingleton{
        private static final Singleton instance = new Singleton();
    }
 */