package com.company;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

class MT2 implements Runnable{
    CountDownLatch cd = null;

    public MT2(CountDownLatch cd) {
        this.cd = cd;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cd.countDown();

    }
}
class ListNode{
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Test {
    public static void main(String[] args) throws InterruptedException {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ReverseList(listNode);
    }
    static ListNode tail = null;
    public static ListNode ReverseList(ListNode head) {
        if(head==null) return head;
        dfs(head);
        return tail;
    }
    public static ListNode dfs(ListNode head){
        if(head.next==null) {
            tail = head;
            return head;
        }
        ListNode temp = dfs(head.next);
        head.next = null;
        temp.next = head;
        return head;
    }
}

class ValueComparator implements Comparator<String> {

    Map<String, Long> base;
    //这里需要将要比较的map集合传进来
    public ValueComparator(Map<String, Long> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.
    //比较的时候，传入的两个参数应该是map的两个key，根据上面传入的要比较的集合base，可以获取到key对应的value，然后按照value进行比较
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}