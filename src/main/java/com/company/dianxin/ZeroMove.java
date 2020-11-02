package com.company.dianxin;

import java.util.Scanner;

public class ZeroMove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(",");
        int[] nums = new int[input.length];
        for (int i=0;i<nums.length;i++){
            nums[i] = Integer.valueOf(input[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0) {
                int idx = i+1;
                while (idx<nums.length && nums[idx]==0){
                    idx++;
                }
                if (idx<nums.length) {
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                }
            }
            sb.append(nums[i]);
            sb.append(",");
        }
        sb.delete(sb.length()-1,sb.length());
        System.out.println(sb.toString());
    }
}
