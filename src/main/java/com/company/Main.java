package com.company;

import java.sql.SQLException;
import java.util.concurrent.*;

import java.util.*;



class ExceptionA extends Exception{

}
class ExceptionB extends ExceptionA{

}
class ExceptionC extends Exception{

}
public class Main {
    public int maxArea (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int max = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]!=0 && !visited[i][j]){
                    int sum = 0;
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                    while (!q.isEmpty()){
                        int[] cur = q.poll();
                        sum += matrix[cur[0]][cur[1]];
                        for(int[] dir:dirs){
                            int nx = cur[0]+dir[0];
                            int ny = cur[1]+dir[1];
                            if (nx>=0 && nx<rows && ny>=0 && ny<cols && !visited[nx][ny] && matrix[nx][ny]!=0){
                                q.offer(new int[]{nx,ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    max = sum>max?sum:max;
                }
            }
        }
        return max;
    }
    public static String nextValue (String[] chars, String currentValue) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i=0;i<chars.length;i++){
            map.put(chars[i],i);
        }
        int last = 1;
        StringBuilder sb = new StringBuilder();
        for (int i=currentValue.length()-1;i>=0;i--){
            String cur = String.valueOf(currentValue.charAt(i));
            int idx = map.get(cur);
            if (last == 1) {
                idx = idx+1;
            }
            if (idx>=map.size()){
                idx-=map.size();
                last = 1;
            }else{
                last = 0;
            }
            sb.insert(0,chars[idx]);
        }
        if (last==1) sb.insert(0,chars[0]);
        return sb.toString();
    }
    public static void main(String[] args) throws SQLException {
        nextValue(new String[]{"零","一","二","三","四","五","六","七","八","九"},"九九");
    }
    public static int countDigitOne(int N) {
        long n = N;
        long count = 0;
        long temp = n;
        int l = 0;
        while(temp>0){
            temp = temp/10;
            l = l+1;
        }
        long[] dp = new long[l];
        dp[0] = 1;
        long m = 10;
        for(int i=1;i<l;i++){
            dp[i] = (i+1)*m;
            m = m*10;
        }
        m = m/10;
        l = l-1;
        long cur;
        int idx;
        while (n>10){
            cur = n/m;
            if(cur>1) count += m;
            else count+=(n%m)+1;
            idx = getI(m/10);
            count += cur*dp[idx];
            n = n%m;
            m = (int) Math.pow(10,getI(n));
        }
        if(n>=1) count++;
        return (int) count;
    }

    private static int getI(long n) {
        int l = -1;
        while(n>0){
            n = n/10;
            l++;
        }
        return l;
    }

    public static String[] permutation(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        boolean[] visited = new boolean[chs.length];

        List<String> res = new ArrayList();
        dfs(chs,visited,new StringBuilder(),res);
        String[] ss = new String[res.size()];
        for(int i=0;i<res.size();i++){
            ss[i] = res.get(i);
        }
        return ss;
    }
    public static void dfs(char[] chs,boolean[] visited,StringBuilder sb,List<String> res){
        if(sb.length()==chs.length) {
            res.add(sb.toString());
            return ;
        }
        Set<Character> set = new HashSet();
        for(int i=0;i<chs.length;i++){
            if(!visited[i] && !set.contains(chs[i])){
                visited[i] = true;
                sb.append(chs[i]);
                set.add(chs[i]);
                dfs(chs,visited,sb,res);
                sb.delete(sb.length()-1,sb.length());
                visited[i] = false;
            }
        }
    }
    public static List rand100(int[] a,int[] b){
        List<Integer> res = new ArrayList<>();
        for (int i=1;i<b.length;i++){
            b[i] += b[i-1];
        }
        Random random = new Random(b[b.length-1]);
        for (int i=0;i<b.length&&i<100;i++){
            int idx = random.nextInt();
            res.add(a[bs(b,idx,0,b.length-1)]);
        }
        return res;
    }
    public static int bs(int[] nums,int target,int left,int right){
        int mid = (left+right)/2;
        if (left==right-- && nums[left]<=target && nums[right]>=target) return right;
        if(nums[mid]<target){
            return bs(nums,target,left,mid-1);
        }else
            return bs(nums,target,mid+1,right);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(int i=0;i<tokens.length;i++){
            if(!tokens[i].equals("/")&&!tokens[i].equals("+")&&!tokens[i].equals("-")&&!tokens[i].equals("*")){
                stack.push(Integer.valueOf(tokens[i]));
            }else if(tokens[i].equals("/")){
                int s = stack.pop();
                int f = stack.pop();
                stack.push(f/s);
            }else if(tokens[i].equals("*")){
                int s = stack.pop();
                int f = stack.pop();
                stack.push(f*s);
            }else if(tokens[i].equals("+")){
                int s = stack.pop();
                int f = stack.pop();
                int temp = f+s;
                stack.push(temp);
            }else if(tokens[i].equals("-")){
                int s = stack.pop();
                int f = stack.pop();
                stack.push(f-s);
            }
        }
        return stack.pop();
    }
    public static String[] z2h(String str){
        List<String> exp = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<str.length();i++){
            StringBuilder sb = new StringBuilder();
            while(i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
                sb.append(str.charAt(i));
                i++;
            }
            if (sb.length()!=0)
                exp.add(sb.toString());
            if (i>=str.length()) continue;
            if (str.charAt(i)!='/'&&str.charAt(i)!='*'&&str.charAt(i)!='+'&&str.charAt(i)!='-'
            &&str.charAt(i)!='('&&str.charAt(i)!=')'){
                exp.add(String.valueOf(str.charAt(i)));
            }else if (str.charAt(i)=='('){
                stack.push('(');
            }else if (str.charAt(i)==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    exp.add(String.valueOf(stack.pop()));
                }
                stack.pop();
            }else if (str.charAt(i)=='/'||str.charAt(i)=='*'){
                while(!stack.isEmpty() && (stack.peek()=='/' || stack.peek()=='*')){
                    exp.add(String.valueOf(stack.pop()));
                }
                stack.push(str.charAt(i));
            }else if(str.charAt(i)=='+' || str.charAt(i)=='-'){
                while (!stack.isEmpty() && stack.peek()!='('){
                    exp.add(String.valueOf(stack.pop()));
                }
                stack.push(str.charAt(i));
            }
        }
        while (!stack.isEmpty()){
            exp.add(String.valueOf(stack.pop()));
        }
        String[] res = new String[exp.size()];
        for (int i=0;i<exp.size();i++){
            res[i] = exp.get(i);
        }
        return res;
    }

    public static void heapAdjust (int[] arr,int fat_idx) {
        int child_idx;
        for (child_idx = 2*fat_idx+1;child_idx<arr.length-1;fat_idx=child_idx){
            if (arr[child_idx]<arr[child_idx+1]){
                child_idx +=1;
            }
            if (arr[fat_idx]<arr[child_idx]){
                swap(arr,fat_idx,child_idx);
            }else{
                break;
            }
        }
    }
    public static void swap(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static boolean isInsidePolygon(float[] point, float[][] polygon){
        boolean res = false;
        int n = polygon.length;
        for (int i=0,j=n-1;i<n;j=i++){
            boolean c1 = ((polygon[i][1]>point[1])!=(polygon[j][1]>point[1]));
            boolean c2 = (point[0]<(polygon[j][0]-polygon[i][0])*(point[1]-polygon[i][1])/
                    (polygon[j][1]-polygon[i][1])+polygon[i][0]);
            if (c1&&c2){
                res=!res;
            }
        }
        return res;
    }
    static int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
    private static boolean search(int[][] mat, int[] start, int[] end) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        mat[start[0]][start[1]] = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (end[0]==cur[0] && end[1]==cur[1]) return true;
            for (int[] dir : dirs) {
                int nx = cur[0]+dir[0];
                int ny = cur[1]+dir[1];
                if (nx>=0 && nx<mat.length && ny>=0 && ny<mat[0].length && mat[nx][ny]==0){
                    q.offer(new int[]{nx,ny});
                    mat[nx][ny] = 1;
                }
            }
        }
        return false;
    }
    /*

    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0){
            return;
        }
        BigInteger[] dp = new BigInteger[n];
        if (n==1){
            System.out.print(1);
            return;
        }
        dp[0] = new BigInteger("1");
        if (n>=2){
            dp[1] = new BigInteger("1");
        }
        for (int i=2;i<n;i++){
            dp[i] = dp[i-1].add(dp[i-2]);
        }
        System.out.println(1);
        for (int i=1;i<n;i++){
            System.out.print(1);
            System.out.print(" ");
            for (int j=1;j<=i;j++){
                System.out.print(dp[j].toString());
                System.out.print(" ");
            }
            for (int j=i-1;j>=1;j--){
                System.out.print(dp[j].toString());
                System.out.print(" ");
            }
            System.out.println(1);
        }
     */

    /*
    Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            for (int i=0;i<t;i++){
                int n = sc.nextInt();
                int m = sc.nextInt();
                int k = sc.nextInt();
                memo = new int[n+1][m+1];
                count = 0;
                Map<Integer,Set<Integer>> map = new HashMap<>();
                for (int j=1;j<=m;j++){
                    Set<Integer> set = new HashSet<>(16);
                    for (int p=1;p<=m;p++){
                        set.add(p);
                    }
                    for (int p=0;p<k;p++){
                        set.remove(sc.nextInt());
                    }
                    map.put(j,set);
                }
                for (int l=1;l<=m;l++){
                    solution(map,1,l,n);
                }
                System.out.println(count);
            }
     */
}
class SumTask implements Callable{
    int s = 0;
    int e = 0;
    CyclicBarrier cb;
    int[] res;
    int idx;
    SumTask(int start,int end,CyclicBarrier c,int[] res,int idx){
        s = start;
        e = end;
        cb = c;
        this.res = res;
        this.idx = idx;
    }
    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = s;i<e;i++){
            sum+=i;
        }
        res[idx] = sum;
        cb.await();
        return sum;
    }
}