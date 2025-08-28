package array;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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


public class reverseAnArray {
    public static void main(String[] args) {

        int[] ar={1,2,3,4,5};

        reverseArray(ar);
    }



    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return result;
        q.offer(root);
        while (!q.isEmpty()){
            int levelSize=q.size();
            double sum=0;
            for (int i=0;i<levelSize;i++){
                TreeNode temp = q.poll();
                sum+=temp.val;
                if(temp.left!=null)q.offer(temp.left);
                if(temp.right!=null)q.offer(temp.right);
            }
            double avg=sum/levelSize;
            result.add(avg);
        }
        return result;
    }

    //reverse an array
    private static void reverseArray(int[] ar) {

        for (int i = 0; i < ar.length-i; i++) {
           int temp=ar[i];
           ar[i]=ar[ar.length-1-i];
            ar[ar.length-1-i]=temp;
        }
    }
}
