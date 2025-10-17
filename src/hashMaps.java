import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class hashMaps {
    public static void main(String[] args) {

        int[] ar={-1,3,4,2};
        int k=3;

       int[] res= pairSum(ar,k);
        System.out.println(res);
    }




    public static int[] pairSum(int[] ar, int k){


        Map<Integer,Integer> m=new HashMap<>();

        for (int i=0;i<ar.length;i++){
            m.put(ar[i],i);
        }
        System.out.println(m);

        for(int i=0;i<ar.length;i++){

            int y= k-ar[i];
            if (m.containsKey(y) && m.get(y) != i) {
                return new int[]{i,m.get(y)};
            }
        }
        return new int[]{0};
    }


}
