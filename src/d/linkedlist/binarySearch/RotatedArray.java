package d.linkedlist.binarySearch;

public class RotatedArray {
    public static void main(String[] args) {
        int[] ar={3,4,5,6,7,8,9,1,2};
        int k=2;
        int ans = searchTarget(ar,k);
        System.out.println(ans);
    }

    private static int searchTarget(int[] ar, int k) {
        int s=0;
        int e=ar.length-1;
        while (s<=e){

            int m=s+(e-s)/2;

            if(ar[m]==k)return m;

            if(ar[s]<=ar[m]){

                if(k>=ar[s] && k<=ar[m]){
                    e=m-1;
                }
                else {
                    s=m+1;
                }
            }
            else {
                if(k>=ar[m] && k<=ar[e]){
                    s=m+1;
                }
                else {
                    e=m-1;
                }
            }
        }
        return -1;
    }
}
