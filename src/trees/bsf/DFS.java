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
}
