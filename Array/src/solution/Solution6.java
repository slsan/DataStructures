package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by slsan on 2018/9/14.
 */
public class Solution6 {
    public int[] test(int[] sums1, int[] sums2){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int sum : sums1){
            if (map.containsKey(sum)){
                map.put(sum,map.get(sum) + 1);
            }else {
                map.put(sum,1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int sum : sums2){
            if (map.containsKey(sum)){
                list.add(sum);
                map.put(sum,map.get(sum)-1);

                if (map.get(sum) == 0)
                    map.remove(sum);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
