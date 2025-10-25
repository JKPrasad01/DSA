package trees.bsf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFS {

    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null)return null;

      TreeNode leftMost=invertTree(root.left);
      TreeNode rightMost = invertTree(root.right);

      root.left=rightMost;
      root.right=leftMost;
      return root;
    }


    public int maxDepth(TreeNode root) {
        if(root==null)return 1;

        int left=maxDepth(root.left);
        int right=maxDepth(root.right);

        return Math.max(left,right);

    }

    //preOrder
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list=new ArrayList<>();

        preOrder(root,list);
        return list;
    }

    private void preOrder(TreeNode node, List<Integer> list) {
        if(node==null)return;
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }


    //inOrder
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();

        inOrder(root,res);
    return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root==null)return;

        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }

    //postOrder
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();

        postOrder(root,res);
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> res) {
        if (root==null)return;

        postOrder(root.left,res);
        postOrder(root.right,res);
        res.add(root.val);
    }

    // check the tree is balanced
    public boolean isBalanced(TreeNode root) {
        if (root==null)return true;
        return checkBalanced(root)!=-1;
    }

    private int checkBalanced(TreeNode node) {
        if( node==null)return 0;

        int left=checkBalanced(node.left);
        if(left==-1)return -1;
        int right=checkBalanced(node.right);
        if(right==-1)return -1;

        if(Math.abs(left-right)>1)return -1;

        return Math.max(left,right)+1;
    }

    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)return 0;

         diameter(root);
         return diameter;
    }

    private int diameter(TreeNode node) {
        if (node==null)return 0;

        int left=diameter(node.left);
        int right=diameter(node.right);
        diameter=Math.max(diameter,left+right);

        return Math.max(left,right)+1;
    }


    int max=0;
    public int maxPathSum(TreeNode root) {
        if(root==null)return 0;

        max=root.val;
        maxSum(root);
        return max;
    }

    private int maxSum(TreeNode node) {
        if(node==null)return 0;
        int l=Math.max(0,maxSum(node.left));
        int r=Math.max(0,maxSum(node.right));

        max=Math.max(max,l+r+node.val);
        return Math.max(l,r)+node.val;
    }

    public void flatten(TreeNode root) {
        if(root==null)return;

        TreeNode cur=root;

        while (cur!=null){

            if(cur.left!=null){
                TreeNode leftMost=cur.left;
                while (leftMost.right!=null){
                    leftMost=leftMost.right;
                }
                leftMost.right=cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
        }
    }



    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)return null;

        if(root==p || root==q)return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null)return root;

        return left==null ? right : left;
    }

}
