package com.company;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class HeapSort {

    public static void main(String[] args) {
        int sum = dfs(new int[]{1,2,3,4,5},0);
        System.out.println(sum);
        LCS("abcb","cbacb");
    }
    public static int dfs(int[] nums,int idx){
        if (idx==nums.length) return 0;
        return nums[idx] + dfs(nums,idx+1);
    }

    /**
     * 堆排序
     */
    private static void heapSort(int[] arr) {
        // 将待排序的序列构建成一个大顶堆
        for (int i = arr.length / 2; i >= 0; i--){
            heapAdjust(arr, i, arr.length);
        }

        // 逐步将每个最大值的根节点与末尾元素交换，并且再调整二叉树，使其成为大顶堆
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i); // 将堆顶记录和当前未经排序子序列的最后一个记录交换
            heapAdjust(arr, 0, i); // 交换之后，需要重新检查堆是否符合大顶堆，不符合则要调整
        }

    }

    public static String LCS (String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[n2+1][n1+1];
        for(int i=1;i<=n2;i++){
            for(int j=1;j<=n1;j++){
                if(s2.charAt(i-1)==s1.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i-1][j-1]+1,dp[i][j-1]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int last_idx = n2;
        int count = 0;
        for(int i=1;i<=n2;i++){
            for(int j=1;j<=n1;j++){
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        for(int j=1;j<=n1;j++){
            for(int i=1;i<=n2;i++){
                if(dp[i][j]!=dp[i-1][j]){
                    if(dp[i][j]>count){
                        sb.append(s2.charAt(i-1));
                        count = dp[i][j];
                        last_idx = i;
                        break;
                    }else if (count==dp[i][j]){
                        if(i<last_idx){
                            if(n2-i>=dp[n2][n1]-sb.length() && n1-j>=dp[n2][n1]-sb.length())
                                sb.delete(sb.length()-1,sb.length());
                            sb.append(s2.charAt(i-1));
                            last_idx = i;
                            break;
                        }
                    }
                }
            }
        }
        return sb.toString();
    }
    /**
     * 构建堆的过程
     * @param arr 需要排序的数组
     * @param i 需要构建堆的根节点的序号
     * @param n 数组的长度
     */
    private static void heapAdjust(int[] arr, int i, int n) {
        int child;
        int father;
        for (father = arr[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);

            // 如果左子树小于右子树，则需要比较右子树和父节点
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child++; // 序号增1，指向右子树
            }

            // 如果父节点小于孩子结点，则需要交换
            if (father < arr[child]) {
                arr[i] = arr[child];
            } else {
                break; // 大顶堆结构未被破坏，不需要调整
            }
        }
        arr[i] = father;
    }

    // 获取到左孩子结点
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    // 交换元素位置
    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
