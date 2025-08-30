package trees.bsf;

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


}
