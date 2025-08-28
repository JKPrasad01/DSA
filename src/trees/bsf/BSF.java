package trees.bsf;

import java.util.LinkedList;
import java.util.Queue;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class BSF {
    public static void main(String[] args) {

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)return true;
        if(p == null || q == null)return false;

        Queue<TreeNode> q1=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();

        q1.offer(p);
        q2.offer(q);

        while (!q1.isEmpty() && !q2.isEmpty()){

            TreeNode cur1=q1.poll();
            TreeNode cur2=q2.poll();
            if(cur1.val!=cur2.val)return false;
            if(cur1.left!=null && cur2.left!=null) {
                q1.offer(cur1.left);
                q2.offer(cur2.left);
            }
            else if(cur1.left!=null || cur2.left!=null){
                return false;
            }

            if(cur1.right!=null && cur2.right!=null){
                q1.offer(cur1.right);
                q2.offer(cur2.right);
            }
            else if(cur1.right!=null || cur2.right!=null){
                return false;
            }
        }

        return q1.isEmpty() && q2.isEmpty();

    }





    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;

        TreeNode cur=root;


    }
}
