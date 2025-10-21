package array;

import java.util.*;

public class TwoPointer {

    public static void main(String[] args) {
        int[] ar = {0, -1, 2, -3, 1};
        List<List<Integer>> triplets = findPairOfTriplet(ar);

        System.out.println("Triplets that sum to 0:");
        for (List<Integer> t : triplets) {
            System.out.println(t);
        }
    }

    private static List<List<Integer>> findPairOfTriplet(int[] ar) {

        // 1 .using  brute-force using nested loops O(n^3)

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < ar.length - 2; i++) {
            for (int j = i + 1; j < ar.length - 1; j++) {
                for (int k = j + 1; k < ar.length; k++) {
                    if (ar[i] + ar[j] + ar[k] == 0) {
                        List<Integer> triplet = Arrays.asList(ar[i], ar[j], ar[k]);
                        Collections.sort(triplet); // Ensure uniqueness regardless of order
                        set.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(set);



        // 2. using the two pointers

        /*
        * case 1: first make an array as sorted
        * case 2: traversal from the 0th index that is the main pointer
        * case 3: take the left pointer as after main index and right pointer is the length-1 of the array index
        * case 4: if the sum of the main + left + right ==0
        *           then add into result list. if the sum < 0 left++;
        *           else sum > 0 right--;
        *
        * other cases for duplication
        *                   case 1: check the present main index and previous index it should be same if it is same skip the present index.
        *                   case 2: check th left and right pointer with the previous pointers if it is same skip.
         */

        Arrays.sort(ar);

        List<List<Integer>> res=new ArrayList<>();

        for (int i=0;i<ar.length-2;i++){
            if(i>0 && ar[i]==ar[i-1])continue;

            int left=i+1;
            int right=ar.length-1;

            while (left<right){

                int sum=ar[i]+ar[left]+ar[right];

                if(sum==0){
                    res.add(Arrays.asList(ar[i],ar[left],ar[right]));

                    while (left<right && ar[left]==ar[left+1])left++;
                    while (left<right && ar[right]==ar[right-1])right--;
                } else if (sum>0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return res;
    }
}
