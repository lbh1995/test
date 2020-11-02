package com.company;

public class GenericTest <T>{
    T val = null;
    public void setVal(T t){
        val = t;
    }
    public <M> M getVal(M m){
        return m;
    }
}

