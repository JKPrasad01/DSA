package trees.bsf;

import java.util.ArrayList;
import java.util.List;

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


}
