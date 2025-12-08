package sliding_window;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SlidingWindowProblems {
    public static void main(String[] args) {

    }

    public Integer substring_anagrams(String s, String t) {
        if(t.length()>s.length())return 0;

        int[] expected= new int[26];
        int[] window=new int[26];
        int count=0;
        for(int i=0;i<t.length();i++){
            expected[t.charAt(i)-'a']+=1;
        }
        int i=0;
        int j=0;
        while(j<s.length()){

            window[s.charAt(j)-'a']+=1;

            if(j-i+1==t.length()){
                if(Arrays.equals(window,expected))count++;
                window[s.charAt(i)-'a']-=1;
                i++;
            }
            j++;
        }
        return count;
    }

    public Integer longest_substring_with_unique_chars(String s) {

        Set<Character> set=new HashSet<>();

        int i=0;
        int j=0;
        int max=0;
        while (j<s.length()){

            while (set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            max= Math.max(max,(j-i+1));
            set.add(s.charAt(j));
            j++;
        }

        return max;
    }
}
