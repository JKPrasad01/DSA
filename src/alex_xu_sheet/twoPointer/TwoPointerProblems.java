package alex_xu_sheet.twoPointer;

import java.util.*;

public class TwoPointerProblems {
    public static void main(String[] args) {

    }

//    1. pair sum
    public ArrayList<Integer> pair_sum_sorted(ArrayList<Integer> nums, int target) {

        ArrayList<Integer> ar=new ArrayList<>();

        int i=0;
        int j=nums.size()-1;

        while(i<j){

            int sum = nums.get(i)+nums.get(j);

            if(sum<target)i++;
            else if(sum>target)j--;
            else{
                ar.add(i);
                ar.add(j);
                return ar;
            }
        }
        return ar;
    }

//    2.triplet
    public ArrayList<ArrayList<Integer>> triplet_sum(ArrayList<Integer> nums) {

        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int n=nums.size();
        for(int i=0;i<n-2;i++){

            if(i>0 && Objects.equals(nums.get(i), nums.get(i - 1))){
                continue;
            }

            int j=i+1;
            int k=n-1;

            while (j<k){

                int sum=nums.get(i)+nums.get(j)+nums.get(k);

                if(sum==0){
                    res.add(new ArrayList<>(
                            List.of(nums.get(i), nums.get(j), nums.get(k))
                    ));
                    j++;
                    k--;

                    while (j<k && nums.get(j).equals(nums.get(j-1)))j++;
                    while (j<k && nums.get(k).equals(nums.get(k+1)))k--;
                }
                else if(sum<0){
                    j++;
                }
                else{
                    k--;
                }
            }

        }
        return res;
    }


    public int largest_container(ArrayList<Integer> heights) {
        int i=0;
        int j=heights.size()-1;

        int max=0;
        while (i<j){

            int water=Math.min(heights.get(i),heights.get(j))*(j-i);
            max=Math.max(water,max);

            if(heights.get(i)<heights.get(j))i++;
            else j--;
        }

        return max;

    }
}
