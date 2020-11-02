package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;


@Component
//@Scope("prototype")
class implA1 implements A {
    public int a = 0;
    implA1(){
        a = 1;
        System.out.println("A1 constructed");
    }

    public int getA() {
        return a;
    }
}

@Component
@Scope("prototype")
class implA2 implements A {
    public int a = 0;
    implA2(){
        a = 2;
        System.out.println("A2 constructed");
    }

    public int getA() {
        return a;
    }
}

@Component
public class MyTest {
    @Autowired
    private A a;
    @Autowired
    private A[] as;
    @Autowired
    private Set<A> set;
    @Autowired
    private Map<String, A> map;

    public void get(){
        System.out.println(a.getA());
        //int m = a.length;
        //int i = set.size();
        //int j = map.size();
        //System.out.print(m);
    }
}
