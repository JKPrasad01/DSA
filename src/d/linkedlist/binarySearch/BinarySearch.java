package d.linkedlist.binarySearch;

import java.util.HashMap;
import java.util.HashSet;

public class BinarySearch {

    public static void main(String[] args) {

    }


    //nums = [-1,0,3,5,9,12], target = 9

    public int findTarget(int[] ar, int k){
        int s=0;
        int e=ar.length-1;
        while (s<=e){
            int m =s+(e-s)/2;
            if (ar[m]==k)return m;
            else if(ar[m]<k) s=m+1;
            else e=m-1;
        }
        return -1;
    }
//      0 1 2 3 4
//    [3,5,8,15,19], x = 9
    //1 1
    public int lowerBound(int[] ar , int k){

        int s=0;
        int e=ar.length-1;
        int res=-1;
        while(s<=e){

            int m=s+(e-s)/2;
            if(ar[m]==k)
            {
             res=m;
             if(ar[s] <= ar[m] && ar[m]==ar[m-1])
                 e=m;
             else return res;
            }

            else if (ar[m]<k)s=m+1;
            else e=m-1;
        }
        return s>ar.length-1 ? ar.length : s;
    }

    //first and last occurrence of the target
    public int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        res[0]=findK(nums,target,true);
        if(res[0]==-1){
            res[1]=res[0];
        }
        res[1]=findK(nums,target,false);
        return res;
    }

    private int findK(int[] ar, int k, boolean check) {

        int s=0;
        int e=ar.length-1;
        int res=-1;
        while(s<=e){
            int m=s+(e-s)/2;

            if(ar[m]<k){
                s=m+1;
            } else if (ar[m]>k) {
                e=m-1;
            }
            else{
                res=m;
                if(check){
                    e=m-1;
                }
                else{
                    s=m+1;
                }
            }
        }
        return res;
    }



    // count occurrence
    public int count(int[] nums, int target) {
        int res[]={-1,-1};
        res[0]=findElement(nums,target,true);
        if(res[0]==-1){
            res[1]=res[0];
            return 0;
        }
        res[1]=findElement(nums,target,false);
        return res[1]-res[0]+1;
    }
    private int findElement(int[] ar, int k, boolean check) {
        int s=0;
        int e=ar.length-1;
        int res=-1;
        while(s<=e){
            int m=s+(e-s)/2;

            if(ar[m]<k){
                s=m+1;
            } else if (ar[m]>k) {
                e=m-1;
            }
            else{
                res=m;
                if(check){
                    e=m-1;
                }
                else{
                    s=m+1;
                }
            }
        }
        return res;
    }


    //floor
    //[1, 2, 8, 10, 10, 12, 19], x = 5

    private int floor(int[] ar, int k){     // if you have multiple occurrence go for bigger index
        int s=0;
        int e=ar.length-1;
        int res=-1;
        while (s<=e){
            int m=s+(e-s)/2;

            if(ar[m]<k){
                s=m+1;
            } else if (ar[m]>k) {
                e=m-1;
            }
            else{
                res = m;
                s = m + 1;
            }
        }
        if(res!=-1)return res;
        return e;
    }

    //insertion index
    public int searchInsert(int[] ar, int k) {
        int s=0;
        int e=ar.length-1;

        while (s<=e){
            int m=s+(e-s)/2;

            if(ar[m]<k){
                s=m+1;
            } else if (ar[m]>k) {
                e=m-1;
            }
            else{
                return m;
            }
        }
        return s;
    }


    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int req = target - cur;
            if(hmap.get(req) != null) {
                return new int[]{hmap.get(req), i};
            } else {
                hmap.put(cur, i);
            }
        }

        return new int[]{-1, -1};
    }


//    Input: nums = [1,2,3,1]
//    Output: 2
//    Explanation: 3 is a peak element and your function should return the index number 2.



    public int findPeakElement(int[] nums) {
        int s=0;
        int e=nums.length-1;

        while(s<e){
            int m=s+(e-s)/2;

            if(nums[m]<nums[m+1]){
                s=m+1;
            }
            else{
                e=m;
            }
        }
        return e;
    }


//    Input: nums = [1,1,2,3,3,4,4,8,8]
//    Output: 2

    public int singleNonDuplicate(int[] nums) {

        int s=0;
        int e=nums.length-1;

        while(s<e){
            int m=s+(e-s)/2;

            if(nums[s]==nums[s+1]){
                s=s+2;
            }
            if(nums[e]==nums[e-1]){
                e=e-2;
            }
        }
        return nums[e];
    }

}
