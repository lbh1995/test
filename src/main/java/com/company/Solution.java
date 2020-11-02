package com.company;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix int整型二维数组 
     * @return int整型一维数组
     */
    public int[] SpiralMatrix (int[][] matrix) {
        int r = matrix.length;
        if (r==0) return new int[]{};
        int c = matrix[0].length;
        int count = r*c;
        int[] res = new int[count];
        int idx = 0;
        int x = 0;
        int y= 0;
        int nx=0;
        int ny=0;
        int d = 0;
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;
        res[idx++] = matrix[0][0];
        while(idx<count){
            if (d==0){
               nx = x + dirs[d][0];
               ny = y + dirs[d][1];
               if (nx<r&&nx>=0&&ny>=0&&ny<c&&!visited[nx][ny]){
                   visited[nx][ny] = true;
                   res[idx++] = matrix[nx][ny];
                   x = nx;
                   y = ny;
               }else{
                   d = 1;

               }
                continue;
            }
            if (d==1){
                nx = x + dirs[d][0];
                ny = y + dirs[d][1];
                if (nx<r&&nx>=0&&ny>=0&&ny<c&&!visited[nx][ny]){
                    visited[nx][ny] = true;
                    res[idx++] = matrix[nx][ny];
                    x = nx;
                    y = ny;
                }else{
                    d = 2;

                }
                continue;
            }
            if (d==2){
                nx = x + dirs[d][0];
                ny = y + dirs[d][1];
                if (nx<r&&nx>=0&&ny>=0&&ny<c&&!visited[nx][ny]){
                    visited[nx][ny] = true;
                    res[idx++] = matrix[nx][ny];
                    x = nx;
                    y = ny;
                }else{
                    d = 3;

                }
                continue;
            }
            if (d==3){
                nx = x + dirs[d][0];
                ny = y + dirs[d][1];
                if (nx<r&&nx>=0&&ny>=0&&ny<c&&!visited[nx][ny]){
                    visited[nx][ny] = true;
                    res[idx++] = matrix[nx][ny];
                    x = nx;
                    y = ny;
                }else{
                    d = 0;

                }
                continue;
            }
            break;
        }
        return res;
    }
    public int GetFragment1 (String str) {
        int[] count = new int[26];
        int[] all = new int[26];
        if (str.length()==0) return 0;
        char last = str.charAt(0);
        int sl = 0;
        int cur = 1;
        for (int i=1;i<str.length();i++){
            if (last==str.charAt(i)){
                cur++;
                continue;
            }else {
                sl++;
                if (cur>count[last-'a']){
                    count[last-'a'] = cur;
                    all[last-'a'] = 1;
                }else if (cur==count[last-'a']){
                    all[last-'a']++;
                }
                last = str.charAt(i);
                cur = 1;
            }
        }
        sl++;
        if (cur>count[last-'a']){
            count[last-'a'] = cur;
            all[last-'a'] = 1;
        }else if (cur==count[last-'a']){
            all[last-'a']++;
        }
        int sum = 0;
        for (int i=0;i<26;i++){
            sum+=count[i]*all[i];
        }
        return sum/sl;
    }
    public int GetFragment (String str) {
        int[] count = new int[26];
        int[] all = new int[26];
        if (str.length()==0) return 0;
        char last = str.charAt(0);
        int sl = 0;
        int cur = 1;
        for (int i=1;i<str.length();i++){
            if (last==str.charAt(i)){
                cur++;
                continue;
            }else {
                sl++;
                if (cur>count[last-'a']){
                    count[last-'a'] = cur;
                    all[last-'a'] = 1;
                }else if (cur==count[last-'a']){
                    all[last-'a']++;
                }
                last = str.charAt(i);
                cur = 1;
            }
        }
        sl++;
        if (cur>count[last-'a']){
            count[last-'a'] = cur;
            all[last-'a'] = 1;
        }else if (cur==count[last-'a']){
            all[last-'a']++;
        }
        int sum = 0;
        for (int i=0;i<26;i++){
            sum+=count[i]*all[i];
        }
        return sum/sl;
    }
    int max = 0;
    int[][] memo;
    public int GetMaxConsecutiveOnes (int[] arr, int k) {
        // write code here
        if (arr.length==0) return 0;
        int idx = 0;
        int cur = 0;
        memo = new int[arr.length+1][k+1];
        dfs(arr,idx,k,cur);
        return max;
    }

    private void dfs(int[] arr, int idx, int k,int cur) {
        if (idx==arr.length) return;
        if (memo[idx][k]!=0 && memo[idx][k]==cur) return;
        max = Math.max(cur,max);
        memo[idx][k] = cur;
        if (arr[idx]==1){
            dfs(arr,idx+1,k,cur+1);
        }else{
            if (k>0){
                dfs(arr,idx+1,k-1,cur+1);
                dfs(arr,idx+1,k,0);
            }else{
                dfs(arr,idx+1,k,0);
            }
        }
    }
}