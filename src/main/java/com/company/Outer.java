package com.company;

public class Outer {
    private static  int radius = 1;
    private int count =2;

    class Inner {
        public void visit() {
            System.out.println("visit outer static  variable:" + radius);
            System.out.println("visit outer   variable:" + count);
        }
    }
}
