package com.company.dianxin;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Hotel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tar = sc.nextInt();
        int[] hotel  = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<n;i++){
            hotel[i] = sc.nextInt();
            set.add(hotel[i]);
        }
        for (int i=0;i<n;i++){
            if (set.contains(tar-hotel[i]) && hotel[i]!=tar-hotel[i]) {
                System.out.print(hotel[i]);
                System.out.print(" ");
                System.out.print(tar-hotel[i]);
                return;
            }
        }
        System.out.println("Not found");
    }
}
