package slidingWindow;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SlidingWindowProblems {


    public static void main(String[] args) {

        String s= "abcabcbb";
        String t="abc";
        int count =countRepeated(s,t);
        System.out.println(count);
    }



    public static int countRepeated(String s, String t) {


        Map<Character, Integer> fixed = new HashMap<>();


        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            fixed.put(ch, fixed.getOrDefault(ch, 0) + 1);
        }

        int count = 0;

        int l = 0;
        int r = 0;
        Map<Character, Integer> window = new HashMap<>();

        while (r<s.length()){

            while (r-l+1<t.length()){
                char ch=t.charAt(r);
                window.put(ch,window.getOrDefault(ch,0)+1);
                r++;
            }
            if(window.equals(fixed))count++;

            Character left = s.charAt(l);
            int val= window.get(left);
            if(val==1)window.remove(left);
            else{
                window.put(left,window.get(left)-1);
            }
            l++;
        }

        return count;
    }


    int search(String s, String t) {

        int[] a=new int[t.length()];
        int[] b=new int[t.length()];

        for (int i=0;i<t.length();i++) {
            char ch= t.charAt(i);
            a[t.charAt(i)-'a']=  (a[t.charAt(i)-'a']+1);
        }
        int count=0;
        int i=0;
        int j=0;
        while (j<s.length()) {
            b[t.charAt(j) - 'a']++;
            while (j - i + 1 < t.length()) {
                b[t.charAt(j) - 'a']++;
                j++;
                continue;
            }

            if (Arrays.equals(b, a)) count++;
            b[t.charAt(j) - 'a']--;
        }
        return count;
    }


    public int[] maxSlidingWindow(int[] nums, int k) {

        int l=0;
        int max=Integer.MIN_VALUE;

        int[] ar=new int[nums.length/k];

        for(int r=0;r<nums.length;r++){
            max=Math.max(max,nums[r]);

            if(r-l+1==k){
                ar[l]=max;
                l++;
            }
        }
        return ar;
    }

}
