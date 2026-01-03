package trees.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeProblems {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> response = new ArrayList<>();
        if (root==null)return response;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int size=q.size();

            List<Integer> ls=new ArrayList<>();

            for (int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);
                ls.add(cur.val);
            }
            response.add(ls);
        }
        return response;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> response=new ArrayList<>();
        if (root==null)return response;
        boolean isFirst=true;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int size=q.size();

            List<Integer> ls=new ArrayList<>();

            for(int i=0;i<size;i++){

                TreeNode cur=q.poll();

                if(isFirst){
                    ls.add(cur.val);

                }
                else{
                    ls.add(0,cur.val);
                }

                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);
            }
            isFirst=!isFirst;
            response.add(ls);
        }
        return response;
    }

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> response=new ArrayList<>();
        if (root==null)return response;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);
                if(i==size-1)response.add(cur.val);
            }

        }
        return response;
    }

    public int minDepth(TreeNode root) {

        if(root==null) return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        int depth=1;
        while (!q.isEmpty()){

            int size=q.size();

            for (int i=0;i<size;i++){
                TreeNode cur=q.poll();
                if(cur.left==null && cur.right==null)return depth;

                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);
            }
            depth++;
        }
        return depth;
    }

}
