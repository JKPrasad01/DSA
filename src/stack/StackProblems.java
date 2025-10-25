package stack;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class StackProblems {

    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {

        HashMap<Character,Character> m=new HashMap<>();

        m.put('[',']');
        m.put('{','}');
        m.put('(',')');
        Stack<Character> stack=new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if(m.containsKey(s.charAt(i))){
                stack.add(s.charAt(i));
            }
           else{
               if(stack.empty() || m.get(stack.pop())!=s.charAt(i)){
                   return false;
               }
            }
        }
        return stack.empty();
    }
    public int[] largestNextNum(int[] ar){

        int[] num=new int[ar.length];

        for(int i=0;i<ar.length-1;i++){

            int max=ar[i];
            for(int j=i+1;j<ar.length;j++){

                if(max<ar[j]){
                    max=ar[j];
                    break;
                }

            }
            if(ar[i]!=max){
                num[i]=max;
            }
            else {
                num[i]=-1;
            }
        }
        num[ar.length-1]=-1;

        return num;
    }

    /*[5, 2, 4, 6 , 1] */
    //[ 6, 4 ,6 -1 , -1]  , s = 6,4,2
    public ArrayList<Integer> next_largest_number_to_the_right(ArrayList<Integer> ar) {

        Stack<Integer> stack = new Stack<>();

        ArrayList<Integer> al = new ArrayList<>();

        int i = ar.size() - 1;
        while (i >= 0){

            // 5>2
            if (!stack.isEmpty()) {
                if (ar.get(i) > stack.peek()) {
                    stack.pop();
                    al.add(i, -1);
                    stack.push(ar.get(i));
                } else {
                    al.add(stack.peek());
                    stack.push(ar.get(i));
                    i--;
                }
            } else {
                al.add(i, -1);
                stack.push(ar.get(i));
                i--;
            }

        }
        return al;
    }

}
