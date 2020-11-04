package com.company;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        System.out.println("lbh_master");
        System.out.println("lbh_dev1");
        System.out.println("conflict_master");
        System.out.println("conflict_dev");
        List<OOMObject> list = new ArrayList<>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
