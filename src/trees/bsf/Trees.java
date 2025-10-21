package trees.bsf;

public class Trees {
    private TreeNode root;


    private class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private int val;

         TreeNode(int val){
            this.val=val;
        }
    }


    public void add(int val){

        if(root==null){
            TreeNode node=new TreeNode(val);
            root=node;
        }


    }
}
