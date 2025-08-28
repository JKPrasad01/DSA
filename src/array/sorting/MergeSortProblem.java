package array.sorting;


import java.util.Arrays;

public class MergeSortProblem {

    public static void main(String[] args) {

        int[] ar={38, 27, 43, 3, 9, 82, 10,1,2};


       int[] ans= mergeSort(ar,0,ar.length-1);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] mergeSort(int[] ar, int s, int e) {
        if(s==e) return new int[]{ar[s]};
        int m= s+(e-s)/2;
        int[] start=mergeSort(ar,s,m);
        int[] mid=mergeSort(ar,m+1,e);
        return merge(start,mid);
    }

    private static int[] merge(int[] start, int[] mid) {

        int i=0;
        int j=0;
        int k=0;
        int[] res =new int[start.length+mid.length];
        while(i<start.length && j<mid.length){
            if(start[i]<=mid[j]){
                res[k++]=start[i++];
            }
            else{
                res[k++]=mid[j++];
            }
        }

        while (i< start.length){
            res[k++]=start[i++];
        }


        while (j< mid.length){
            res[k++]=mid[j++];
        }

        return res;
    }
}
