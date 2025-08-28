package array.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] ar={38, 27, 43, 3, 9, 82, 10,1,2};
        bubbleSort(ar);
        System.out.println(Arrays.toString(ar));
    }

    //bubbleSort
    public static void bubbleSort(int[] ar){

        for (int i=0;i<ar.length-1;i++){
            for(int j=i+1;j<ar.length;j++){
                if(ar[i]>ar[j]){
                    int temp=ar[i];
                    ar[i]=ar[j];
                    ar[j]=temp;
                }
            }
        }
    }

    //insertionSort
    public static void insertionSort(int[] ar){
        for(int i=0;i<ar.length-1;i++){
            for(int j=i+1;j>0;j--){

                if(ar[j]<ar[j-1]){
                   int temp=ar[j-1];
                   ar[j-1]=ar[j];
                   ar[j]=temp;
                }
                else{
                    break;
                }
            }
        }
    }


    //mergeSort
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
