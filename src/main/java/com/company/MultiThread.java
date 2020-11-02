package com.company;

import sun.awt.windows.ThemeReader;

import java.util.Set;
import java.util.concurrent.*;

public class MultiThread {
    static int[][] dir = new int[][]{{0,1},{-1,0},{0,1},{1,0}};
    public static void dfs(int[][] mat, int idx, int[] dp, int next,int x,int y){
        mat[x][y] = dp[idx--];
        if (next==0){
            int nx = x+dir[next][0];
            int ny = y+dir[next][1];
            if (nx>=0&&nx<mat.length&&ny>=0&&ny<mat.length){
                if (mat[nx][ny]==0)
                    dfs(mat,idx,dp,next,nx,ny);
            }else{
                if (mat[nx][ny]==0)
                    dfs(mat,idx,dp,1,nx,ny);
            }
        }
        if (next==1){
            int nx = x+dir[next][0];
            int ny = y+dir[next][1];
            if (nx>=0&&nx<mat.length&&ny>=0&&ny<mat.length){
                if (mat[nx][ny]==0)
                    dfs(mat,idx,dp,next,nx,ny);
            }else{
                if (mat[nx][ny]==0)
                    dfs(mat,idx,dp,2,nx,ny);
            }
        }
        if (next==2){
            int nx = x+dir[next][0];
            int ny = y+dir[next][1];
            if (nx>=0&&nx<mat.length&&ny>=0&&ny<mat.length){
                if (mat[nx][ny]==0)
                    dfs(mat,idx,dp,next,nx,ny);
            }else{
                if (mat[nx][ny]==0)
                    dfs(mat,idx,dp,3,nx,ny);
            }
        }
        if (next==3){
            int nx = x+dir[next][0];
            int ny = y+dir[next][1];
            if (nx>=0&&nx<mat.length&&ny>=0&&ny<mat.length){
                if (mat[nx][ny]==0)
                    dfs(mat,idx,dp,next,nx,ny);
            }else{
                if (mat[nx][ny]==0)
                    dfs(mat,idx,dp,0,nx,ny);
            }
        }
    }

    private static void replaceAll(int[] nums, int idx, Set<Integer> set) {
        for (Integer s:set){
            nums[s] = idx;
        }
    }

    static int V;

    static int minDistance(int dist[], Boolean sptSet[]) {
        //  初始化最小值
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    static void dijkstra(int graph[][], int src,int tar) {
        int dist[] = new int[V];

        Boolean sptSet[] = new Boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        System.out.println(dist[tar]);
    }

    public static class Generic<T>{
        //key这个成员变量的类型为T,T的类型由外部指定
        private T key;

        public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
            this.key = key;
        }

        public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
            return key;
        }
    }

    public static<T> void showKeyValue(Generic<T> obj){
        System.out.println("泛型测试"+"key value is " + obj.getKey());
    }

    public static void showKeyValue1(Generic<?> obj){
        System.out.println("泛型测试"+"key value is " + obj.getKey());
    }



    public static int buyTicketsTime(int n,int[] a,int[] b){
        if(n==1) return a[0];
        int[][] dp = new int[n][2];
        dp[0][0] = a[0];
        for (int i=1;i<n;i++){
            dp[i][1] = dp[i-1][0];
            dp[i][0] = Math.min(b[i-1]+dp[i-1][1],a[i]+dp[i-1][0]);
        }
        return dp[n-1][0];
    }
    static int allocated = 0;
    public static void divide(int idx,int[] v,int a,int b){
        if (idx==v.length) return;
        if (a==b) {
            int cur = a+b;
            allocated = Math.max(allocated,cur);
        }
        divide(idx+1,v,a+v[idx],b);
        divide(idx+1,v,a,b+v[idx]);
        divide(idx+1,v,a,b);
    }
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        char[] chs = s.toCharArray();
        int n = chs.length;
        if (n<=1) return s;
        int left = 0;
        int right = 1;
        while(right<sb.length()){
            if (chs[left]==chs[right]+32||chs[left]==chs[right-32]){
                sb.delete(left,left+1);
                sb.delete(right,right+1);
                left--;
                if (left<0){
                    left = 0;
                }
                right = left+1;
            }
        }

        return sb.toString();
    }
    public char findKthBit(int n, int k) {
        int pow = (int) Math.pow(2,19);
        int count = 0;
        while (k!=1){
            if (k==pow){
                return '1';
            }else if (k>pow) {
                k = pow - (k - pow);
                count++;
            }else{
                k = k;
            }
            pow = pow/2;
        }
        if (count%2==0) return '0';
        else return '1';
    }
    public int maxNonOverlapping(int[] nums, int target) {
        //int[][] dp = new int[100000][100000];
        for(int i=0;i<100000;i++){
            for(int j=0;i<100000;j++){

            }
        }
        return 0;
    }
    public static class MyCallable implements Callable{
        public String call() throws Exception {
            //System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
            return Thread.currentThread().getName()+":Callable";
        }
    }
    public static class MyRunnable implements Runnable{
        public void run() {
            System.out.println("Runnable");
        }
    }
    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Thread");
        }
    }
    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,3,50,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));
        Future future = executor.submit(new MyCallable());
        executor.submit(new MyRunnable());
        executor.execute(new MyThread());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
