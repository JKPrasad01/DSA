package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphProblems {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        adj.add(0, (ArrayList<Integer>) List.of(1,2));
        adj.add(1, (ArrayList<Integer>) List.of(0,3));
        adj.add(2, (ArrayList<Integer>) List.of(0,4));
        adj.add(3, (ArrayList<Integer>) List.of(1));
        adj.add(4, (ArrayList<Integer>) List.of(2));
        boolean[] visited=new boolean[adj.size()];
        ArrayList<Integer> result =new ArrayList<>();
        dfsRec(0,visited,adj,result);
    }


    public static void dfsRec(int node,boolean[] visited,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> res) {

        visited[node]=true;
        res.add(node);

        ArrayList<Integer> neighbours=adj.get(node);
        for(int i=0;i<neighbours.size();i++){
            int n=neighbours.get(i);
            if(!visited[n]){
                    dfsRec(n,visited,adj,res);
            }
        }
    }

    // this is DFS iterative using stack
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result=new ArrayList<>();
        boolean[] visited =new boolean[adj.size()];

        Stack<Integer> s=new Stack<>();
        s.push(0);

        while (!s.isEmpty()){
            int node = s.pop();

            if(!visited[node]){
                visited[node]=true;
                result.add(node);
            }

            ArrayList<Integer> neighbours=adj.get(node);

            for (int i=neighbours.size()-1;i>=0;i--) {
                int n=neighbours.get(i);
                if (!visited[n]) {
                    s.push(n);
                }
            }
        }
        return result;
    }


    public int findCircleNum(int[][] isConnected) {

        boolean[] visited = new boolean[isConnected.length];
        int count =0;

        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                dfs(i, visited,isConnected);
                count++;
            }
        }

        return count;
    }

    public void dfs(int i,boolean[] visited,int[][] isConnected){
        visited[i]=true;

        for(int j=0;j<isConnected[i].length;j++){
            if(isConnected[i][j]==1 && !visited[j]){
                dfs(j,visited,isConnected);
            }
        }
    }





}
