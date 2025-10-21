package string;

import java.util.Arrays;

public class StringProblems {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length())return false;

        char[] a=new char[s.length()];
        char[] b=new char[t.length()];

        for (int i = 0; i < s.length(); i++) {
            a[i]=s.charAt(i);
        }
        for (int j=0;j<t.length();j++){
            b[j]=t.charAt(j);
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int i=0;
        int j=0;

        while (i<a.length && j<b.length){
            if(a[i]!=b[j]){
                return false;
            }
            i++;
            j++;
        }
        return true;
    }


    public String largestOddNumber(String num) {

    }
}
