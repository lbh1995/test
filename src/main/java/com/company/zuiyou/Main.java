package com.company.zuiyou;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        System.out.println(Integer.toBinaryString(n));
        System.out.println((~n)+1);
    }
    private static boolean compare(String str, String s) {
        if(str.length()>s.length()){
            return true;
        }else if (str.length()<s.length()){
            return false;
        }
        for (int i=0;i<s.length();i++){
            if (str.charAt(i)>s.charAt(i)){
                return true;
            }
        }
        return false;
    }
}
