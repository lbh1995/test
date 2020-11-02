package com.company;
import java.util.ArrayList;
import java.util.List;
public class FloydInGraph {
    private static int INF = Integer.MAX_VALUE;
    private int[][] dist;
    private int[][] path;
    private List<Integer> result = new ArrayList<Integer>();
    public static void main(String[] args) {
        FloydInGraph graph = new FloydInGraph(17);
        int[][] matrix = { {INF, 30, INF, 10, 50},
                {INF, INF, 60, INF, INF},
                {INF, INF, INF, INF, INF},
                {INF, INF, INF, INF, 30},
                {50, INF, 40, INF, INF}, };
        int begin=0;
        int end=14;
        System.out.println(graph.floyd(matrix, begin, end));
    }
    public int floyd(int[][] matrix, int begin, int end){
        int size=matrix.length;
        for(int i=0;i< size;i++){
            for(int j=0;j< size;j++){
                dist[i][j]=matrix[i][j];
            }
        }
        for(int k=0;k< size;k++){
            for(int i=0;i< size;i++){
                for(int j=0;j< size;j++){
                    if(dist[i][k]!=-1&& dist[k][j]!=-1&&
                            dist[i][k]+dist[k][j]< dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        return dist[begin][end];
    }
    public FloydInGraph(int size){
        this.path=new int[size][size];
        this.dist=new int[size][size];
    }
}
