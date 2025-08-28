import d.linkedlist.DL;
import d.linkedlist.LL;

import java.util.*;


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
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Input: nums = [1,2,3,4,5,6,7], k = 3
//        Output: [5,6,7,1,2,3,4]
//        Explanation:
//        rotate 1 steps to the right: [7,1,2,3,4,5,6]
//        rotate 2 steps to the right: [6,7,1,2,3,4,5]
//        rotate 3 steps to the right: [5,6,7,1,2,3,4]

        int[] num = {1,2,3,4,5,6,7};
        int k = 3;

        int[] res = new int[num.length];

        int j=0;
        for(int i=num.length-k ;i<=num.length;i++){
            res[j]=num[i];
            j++;
        }

        for(int i=0 ;i<num.length-k;i++){
            res[j]=num[i];
            j++;
        }

        System.out.println(Arrays.toString(res));

    }
    public List<List<Integer>> levelOrder(TreeNode root) {

        TreeNode r = root;

        Deque<TreeNode> q = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        q.addLast(root);

        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int level = q.size();
            for (int i = 0; i < level; i++) {
                TreeNode temp = q.removeFirst();
                list.add(temp.val);
                if (temp.left != null) q.addLast(temp.left);
                if (temp.right != null) q.addLast(temp.right);
            }
            result.add(list);
        }
        return result;
    }
}