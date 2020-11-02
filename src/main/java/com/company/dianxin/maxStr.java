package com.company.dianxin;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class maxStr {
    public static void main(String[] args) {
        verifyPostorder(new int[]{5, 4, 3, 2, 1});
        /*
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.length()==0) return;
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<str.length();i++){
            set.add((str.charAt(i)-'0'));
        }
        int[] nums = new int[set.size()];
        int idx = 0;
        for (int i=1;i<=9;i++){
            if(set.contains(i)){
                nums[idx++] = i;
            }
        }
        int max = 0;
        String res = "";
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        for (int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1]+1) {
                sb.append(nums[i]);
                if (max<sb.length()) {
                    max = sb.length();
                    res = sb.toString();
                }
            }else{
                sb = new StringBuilder();
                sb.append(nums[i]);
            }
        }
        System.out.println(res);
         */
    }
    public static boolean verifyPostorder(int[] postorder) {
        return dfs(postorder,0,postorder.length-1);
    }
    public static boolean dfs(int[] postorder,int l,int r){
        if(r<=l) return true;
        int left = r;
        int right = r;
        int tar = postorder[r];
        for(int i=r-1;i>=l;i--){
            if(left==r && postorder[i]<tar){
                left = i;
            }
            if(postorder[i]>tar){
                right = i;
            }
        }
        left = left==r?l:left;
        if(right<left) return false;
        boolean lf = dfs(postorder,l,left);
        boolean lr = dfs(postorder,right,r-1);
        return lf&lr;
    }
}
