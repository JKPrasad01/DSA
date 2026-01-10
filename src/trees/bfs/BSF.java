package trees.bfs;

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


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class BSF {
    public static void main(String[] args) {

    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return result;
        q.offer(root);

        while (!q.isEmpty()){
            List<Integer> list=new ArrayList<>();
                int level=q.size();
            for(int i=0;i<level;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);

                list.add(cur.val);
            }
            result.add(list);
        }
        return result;
    }


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return result;
        q.offer(root);

        while (!q.isEmpty()){
           int level=q.size();
           int sum=0;
            for(int i=0;i<level;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);

               sum+=cur.val;
            }
            double avg = (double) sum /level;
            result.add(avg);
        }
        return result;

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res=new ArrayList<>();
        if(root==null)return res;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int length = q.size();

            List<Integer> al=new ArrayList<>();

            for(int i=0;i<length;i++){

                TreeNode cur=q.poll();
                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);

                al.add(cur.val);
            }

            res.addFirst(al);
        }
        return res;
    }


    public Node connects(Node root) {

       if(root==null)return null;

       Node leftMost=root;

       while (leftMost.left!=null){

           Node cur=leftMost;

           while (cur!=null){

               cur.left=cur.right;

               if(cur.next!=null)cur.right.next=cur.next.left;

               cur=cur.next;
           }
           leftMost = leftMost.left;
       }
       return root;
    }




    public List<Integer> rightSideViews(TreeNode root) {


        List<Integer> res=new ArrayList<>();
        if(root!=null)return null;

        Queue<TreeNode> q=new LinkedList<>();

        while (!q.isEmpty()){

            int length=q.size();

            for(int i=0;i<length;i++){

                TreeNode cur=q.poll();

                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);

                if(i==length-1)res.add(cur.val);
            }
        }
        return res;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)return result;
        q.offer(root);
        int count=0;
        while (!q.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int level=q.size();
            for(int i=0;i<level;i++){
                TreeNode cur=q.poll();
                if(cur.left!=null)q.offer(cur.left);
                if(cur.right!=null)q.offer(cur.right);

                if(count%2==0){
                    list.add(cur.val);
                }
                else{
                    list.addFirst(cur.val);
                }
            }
            count++;
            result.add(list);
        }
        return result;

    }


    public Node connect(Node root) {
        if(root==null)return null;
        Node leftMost=root;
        while (leftMost.left!=null){

            Node cur=leftMost;
            while (cur!=null){
                cur.left.next=cur.right;

                if(cur.next!=null){
                    cur.right.next=cur.next.left;
                }
                cur=cur.next;
            }
            leftMost=leftMost.left;

        }
        return root;
    }


    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list=new ArrayList<>();
        if(root==null)return list;


        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){

            int level= queue.size();

            for(int i=0;i<level;i++){
                TreeNode temp=queue.poll();
                if(temp.left!=null)queue.offer(temp.left);
                if(temp.right!=null)queue.offer(temp.right);

                if(i==level-1){
                    list.add(temp.val);
                }
            }
        }
        return list;

    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;

        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()){

            TreeNode cur1=q.poll();
            TreeNode cur2=q.poll();

            if(cur1==null && cur2==null){
                continue;
            }
            if(cur1==null || cur2==null){
                return false;
            }
            if(cur1.val!=cur2.val) {
                return false;
            }

                q.offer(cur1.left);
                q.offer(cur2.right);
                q.offer(cur1.right);
                q.offer(cur2.left);
        }
        return true;
    }


//    public boolean isSymmetric(TreeNode root) {
//        if(root==null)return true;
//
//        TreeNode cur=root;
//
//
//    }
}
