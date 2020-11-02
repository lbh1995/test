package com.company.wy;

import java.util.*;

public class yt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        Map<Integer,int[]> map = new HashMap<>();
        for (int i=0;i<n;i++){
            String[] strs = sc.nextLine().split(" ");
            int par = Integer.parseInt(strs[0]);
            int child = Integer.parseInt(strs[2]);
            if (map.containsKey(par)){
                if (strs[1].equals("left")){
                    map.get(par)[0] = child;
                }else{
                    map.get(par)[1] = child;
                }
            }else {
                int[] temp = new int[2];
                if (strs[1].equals("left")){
                    temp[0] = child;
                }else{
                    temp[1] = child;
                }
                map.put(par,temp);
            }
        }
        Integer count = 0;
        Set<Integer> set = new HashSet<>();
        dfs(map,1,set);
        for (Map.Entry<Integer,int[]> entry:map.entrySet()){
            int[] temp = entry.getValue();
            if (set.contains(temp[0])&&set.contains(temp[1])) count++;
        }
        System.out.print(count);
    }

    private static void dfs(Map<Integer,int[]> map, int cur,Set<Integer> set) {
        int[] children = map.get(cur);
        if (children==null || (children[0]==0 && children[1]==0)){
            set.add(cur);
            return;
        }
        if (children[0]!=0){
            dfs(map,children[0],set);
        }
        if (children[1]!=0){
            dfs(map,children[1],set);
        }
    }
}
