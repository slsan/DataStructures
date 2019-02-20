package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


/**
 * Created by slsan on 2018/9/14.
 */
public class Solution5 {
    public int[] test5(int[] nums1,int[] nums2){

        TreeSet<Integer> tree = new TreeSet<>();
        for (int nums : nums1){
            tree.add(nums);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2){
            if (tree.contains(num)){
                list.add(num);
                tree.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i ++)
            res[i] = list.get(i);

        return res;
    }
}
