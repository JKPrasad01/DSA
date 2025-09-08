package array.binarySearch;

import java.util.HashMap;

public class BinarySearch {

    public static void main(String[] args) {

    }

    public int mySqrt(int X) {

        long s=1;
        long e=X;


        while(s<=e){

            long m=s+(e-s)/2;

            if(m*m==X)return (int)m;
            else if(m*m<X)s=m+1;
            else e=m-1;
        }

        return (int)e;
    }


    public int guessNumber(int n) {

        int s=1;
        int e=n;

        while(s<e){
            int m=s+(e-s)/2;

            int num=guess(m);

            if(num==-1)e=m-1;
            else if(num==1)s=m+1;
            else{
                return m;
            }
        }
        return -1;
    }

    private int guess(int m) {
            return 0;
    }

    public int firstBadVersion(int n) {

        int s=1;
        int e=n;
        int res=-1;
        while(s<=e){

            int m=s+(e-s)/2;

            boolean isBad=isBadVersion(m);// commented. because it will work on leetCode

            if(!isBad){
                s=m+1;
            }
            else{
                res=m;
                if(true){
                    e=m-1;
                }
                else{
                    s=m+1;
                }
            }
        }
        return res;
    }

    private boolean isBadVersion(int m) {
        int res=13;
        return res==m;
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

    public boolean isPerfectSquare(int num) {

        long s=0;
        long e=num;

        while(s<=e){
            long m=s+(e-s)/2;

            if(m*m<num)s=m+1;
            else if(m*m>num)e=m-1;
            else return true;
        }
        return false;
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

    public int peakIndexInMountainArray(int[] arr) {
        int s=0;
        int e=arr.length-1;

        while(s<e){

            int m=s+(e-s)/2;

            if(arr[m]<arr[m+1])s=m+1;
            else{
                e=m;
            }
        }
        return s;
    }

    public int singleNonDuplicate(int[] nums) {
        int s=0;
        int e=nums.length-1;

        while (s < e) {
            int m = s + (e - s) / 2;


            if (m % 2 == 1) {
                m--;
            }

            if (nums[m] == nums[m + 1]) {
                s = m + 2;
            } else {
                e = m;
            }
        }
        return nums[s];
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

    public int singleNonDuplicate2(int[] nums) {

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


    //binary search in 2D Array
    public boolean searchMatrix(int[][] ar, int target) {

        int s=0;
        int e=(ar[0].length * ar.length)-1;

        while(s<=e){
            int m=s+(e-s)/2;

            int r=m/ar[0].length;
            int c=m%ar[0].length;
            if(ar[r][c]==target)return true;
            else if(ar[r][c]<target)s=m+1;
            else e=m-1;
        }
        return false;
    }


//    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
//    Output: true
    public boolean searchMatrix2(int[][] matrix, int target) {

        int s=0;
        int e=matrix[0].length-1;

        while(s<matrix.length && e>=0){

            if(matrix[s][e]==target)return true;
            else if(matrix[s][e]<target)s++;
            else e--;
        }
        return false;
    }
}
