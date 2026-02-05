package alex_xu_sheet.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;

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

        ArrayList<Integer> sorted = (ArrayList<Integer>) nums.stream().sorted();

        }
    }
}
