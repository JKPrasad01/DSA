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


    //number of provinces
    public int findCircleNum(int[][] isConnected) {

        int n=isConnected.length;
        boolean[] visited = new boolean[n];
        int count =0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, visited,isConnected);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i,boolean[] visited,int[][] isConnected){
        visited[i]=true;

        for(int j=0;j<isConnected[i].length;j++){
            if(isConnected[i][j]==1 && !visited[j]){
                dfs(j,visited,isConnected);
            }
        }
    }

    // number of islands
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfsIslands(grid,i,j);
                }
            }
        }
        return count;
    }

    private void dfsIslands(char[][] grid, int i, int j) {

        if(i < 0 || j < 0 || i>grid.length-1 || j> grid[0].length-1 || grid[i][j]=='0')return ;

        grid[i][j]='0';

        dfsIslands(grid,i,j+1);//right side
        dfsIslands(grid, i, j-1);//left side
        dfsIslands(grid,i-1,j);//up
        dfsIslands(grid,i+1,j);//down
    }


    // flood fill
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if(image[sr][sc]==color)return image;
        dfsFloodFill(image,image[sr][sc],color,sr,sc);
        return image;
    }

    private void dfsFloodFill(int[][] image, int color,int newColor,int i,int j) {

        if(i< 0 || j<0 || i>image.length-1 || j>image[0].length-1 ){
            return;
        }
        if(image[i][j]!=color)return;
        image[i][j]=newColor;

        dfsFloodFill(image,color,newColor,i-1,j);
        dfsFloodFill(image,color,newColor,i+1,j);
        dfsFloodFill(image,color,newColor,i,j-1);
        dfsFloodFill(image,color,newColor,i,j+1);
    }
}
