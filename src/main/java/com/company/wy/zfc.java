package com.company.wy;

import java.util.*;

public class zfc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int len = str.length();
        int[] count = new int[6];
        for (int i=0;i<len;i++){
            if (str.charAt(i)=='a'){
                count[0]++;
            }else if (str.charAt(i)=='b'){
                count[1]++;
            }else if (str.charAt(i)=='c'){
                count[2]++;
            }else if (str.charAt(i)=='x'){
                count[3]++;
            }else if (str.charAt(i)=='y'){
                count[4]++;
            }else if (str.charAt(i)=='z'){
                count[5]++;
            }
        }
        int max = 0;
        int left = 0;
        for (;left<len;left++){
            int right = len-1;
            int[] temp = new int[6];
            for (int i=0;i<6;i++){
                temp[i] = count[i];
            }
            for (;right>=left+max;right--){
                if (str.charAt(right)=='a'){
                    temp[0]--;
                }else if (str.charAt(right)=='b'){
                    temp[1]--;
                }else if (str.charAt(right)=='c'){
                    temp[2]--;
                }else if (str.charAt(right)=='x'){
                    temp[3]--;
                }else if (str.charAt(right)=='y'){
                    temp[4]--;
                }else if (str.charAt(right)=='z') {
                    temp[5]--;
                }
            }
            if (str.charAt(left)=='a'){
                count[0]--;
            }else if (str.charAt(left)=='b'){
                count[1]--;
            }else if (str.charAt(left)=='c'){
                count[2]--;
            }else if (str.charAt(left)=='x'){
                count[3]--;
            }else if (str.charAt(left)=='y'){
                count[4]--;
            }else if (str.charAt(left)=='z'){
                count[5]--;
            }
        }
        System.out.print(max);
    }
}

/*
import java.util.*;

public class Main {
    public static char[] vc = {'a', 'b', 'c', 'x', 'y', 'z'};
    public static void init(Map<Character,Integer> map) {
        for (int i = 0; i < vc.length; i++) {
            map.put(vc[i], 0);
        }
    }
    public static boolean numCheck(Map<Character,Integer> map) {
        if (map.get('a') % 2 == 0 && map.get('b') % 2 == 0 && map.get('c') % 2 == 0 && map.get('x') % 2 == 0 && map.get('y') % 2 == 0 && map.get('z') % 2 == 0)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] sArr = s.toCharArray();
        int n = s.length();
        int res = 0;
        for (int l = 1; l < n; l++) {
            Map<Character,Integer> abcxyz = new HashMap<>();
            init(abcxyz);
            for (int i = 0; i < l; i++) {
                if (abcxyz.containsKey(sArr[i])) {
                    abcxyz.put(sArr[i], abcxyz.get(sArr[i]) + 1);
                }
            }
            if (numCheck(abcxyz)) {
                res = l;
                break;
            }
            for (int i = l; i < n; i++) {
                if (abcxyz.containsKey(sArr[i])) {
                    abcxyz.put(sArr[i], abcxyz.get(sArr[i]) + 1);
                    if (i-l >= 0 && abcxyz.containsKey(sArr[i-l])) {
                        abcxyz.put(sArr[i-l], abcxyz.get(sArr[i-l]) - 1);
                    }
                }
                if (numCheck(abcxyz)) {
                    res = l;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}

package Shousi;

        import java.util.ArrayList;
        import java.util.HashSet;
        import java.util.Scanner;
public class Migu01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numNode = scanner.nextInt();
        int numStep = scanner.nextInt();
        int S[] = new int[numNode - 1];
        for (int i = 0; i < S.length; i++) {
            S[i] = scanner.nextInt();
        }
        ArrayList<Integer>[] arrayLists = new ArrayList[numNode];
        for (int i = 0; i < arrayLists.length; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 0; i < S.length; i++) {
            arrayLists[i + 1].add(S[i]);
            arrayLists[S[i]].add(i + 1);
        }
        boolean[] visite = new boolean[numNode];
        visite[0] = true;
        int []result={numStep};
        DFS(arrayLists,  result, numStep, 0, visite);
        int res=numStep-result[0];
        System.out.println(res+1+result[0]/2 );

    }

    private static void DFS(ArrayList<Integer>[] arrayLists, int[] result, int numStep, int i, boolean[] visite ) {

        boolean flag=false;
        for (int j = 0; j < arrayLists[i].size(); j++) {
            if (!visite[arrayLists[i].get(j)]) {
                flag=true;
                break;
            }
        }
        if(!flag){
            result[0] = Math.min(result[0], numStep);
        }
        else {
            for (int j = 0; j < arrayLists[i].size(); j++) {
                if (!visite[arrayLists[i].get(j)]) {
                    visite[arrayLists[i].get(j)] = true;
                    DFS(arrayLists, result, numStep - 1, arrayLists[i].get(j), visite);
                    visite[arrayLists[i].get(j)]=false;
                }
            }
        }
    }
}


import java.util.*;

public class Main {
    public static boolean check(Map<Character,Integer> map) {
        if (map.get('a') % 2 == 0 && map.get('b') % 2 == 0 && map.get('c') % 2 == 0 && map.get('x') % 2 == 0 && map.get('y') % 2 == 0 && map.get('z') % 2 == 0)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        char[] vc = {'a', 'b', 'c', 'x', 'y', 'z'};
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] sArr = s.toCharArray();
        int n = s.length();
        int res = 0;
        for (int l = 1; l <= n; l++) {
            Map<Character,Integer> abcxyz = new HashMap<>();
            for (int i = 0; i < vc.length; i++) {
                abcxyz.put(vc[i], 0);
            }
            for (int i = 0; i < l; i++) {
                if (abcxyz.containsKey(sArr[i])) {
                    abcxyz.put(sArr[i], abcxyz.get(sArr[i]) + 1);
                }
            }
            if (check(abcxyz)) {
                res = l;
                continue;
            }
            for (int i = l; i < n; i++) {
                if (abcxyz.containsKey(sArr[i])) {
                    abcxyz.put(sArr[i], abcxyz.get(sArr[i]) + 1);
                }
                if (abcxyz.containsKey(sArr[i-l])) {
                    abcxyz.put(sArr[i-l], abcxyz.get(sArr[i-l]) - 1);
                }
                if (check(abcxyz)) {
                    res = l;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}

 */