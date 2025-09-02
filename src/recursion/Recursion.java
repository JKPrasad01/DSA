package recursion;

public class Recursion {
    public static void main(String[] args) {

    }

    //binary search using recursion
    public int search(int[] nums, int target) {

        return helper(nums,target,0,nums.length-1);
    }

    private int helper(int[] ar, int k , int s, int e){
        if(s>e)return -1;

        int m=s+(e-s)/2;

        if(ar[m]==k)return m;

        if(ar[m]<k){
            return helper(ar,k,m+1,e);
        }
        return helper(ar,k,s,m-1);
    }


    public int numberOfSteps(int num) {
        return  countSteps(num,0);
    }

    private int countSteps(int num,int count){
        if(num==0)return count;
        if(num%2==0){
            num=num/2;
        }
        else{
            num=num-1;
        }
        return countSteps(num,count+1);
    }
}
