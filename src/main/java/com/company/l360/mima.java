package com.company.l360;

import java.util.*;

public class mima {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> arrived = new HashSet<>();
        Set<Integer> last = new HashSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i=1;i<=n;i++){
            last.add(i);
        }
        int last_left = -1;
        int first_arrived = -1;
        for (int i=0;i<m;i++){
            int id = sc.nextInt();
            int op = sc.nextInt();
            if (op==1){
                if (first_arrived==-1){
                    first_arrived = id;
                    arrived.add(id);
                }else {
                    arrived.add(id);
                    last.remove(id);
                }
            }else{
                if (last_left==-1){
                    last_left = id;
                    if (!arrived.contains(id)){
                        if (first_arrived!=-1){
                            last.remove(id);
                            last.remove(first_arrived);
                        }
                    }
                }else{
                    last.remove(last_left);
                    if (!arrived.contains(id)){
                        if (first_arrived!=-1){
                            last.remove(id);
                            last.remove(first_arrived);
                        }
                    }
                    last_left = id;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i:last){
            q.offer(i);
        }
        while (!q.isEmpty()){
            System.out.print(q.poll());
            System.out.print(" ");
        }
    }
}
