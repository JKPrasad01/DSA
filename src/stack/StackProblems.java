package stack;


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
}
