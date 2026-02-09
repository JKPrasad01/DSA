package alex_xu_sheet.hashMapsAndSets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapAndHastSetProblems {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> pair_sum_unsorted(ArrayList<Integer> nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {

            int needed = target - nums.get(i);

            if (map.containsKey(needed)) {

                ArrayList<Integer> ans = new ArrayList<>();

                ans.add(map.get(needed));
                ans.add(i);

                return ans;
            }
            map.put(nums.get(i), i);
        }

        return new ArrayList<>();
    }
}
