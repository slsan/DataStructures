package solution;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by slsan on 2018/9/18.
 */
public class Solution7 {
    private class Freq implements Comparable<Freq>{

        private int e,freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.freq < another.freq)
                return -1;
            else if (this.freq > another.freq)
                return 1;
            else
                return 0;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num,map.get(num) + 1);
            }else {
                map.put(num,1);
            }
        }

        PriorityQueue<Freq> queue = new PriorityQueue<>();
        for (int key: map.keySet()){
            if (queue.size() < k){
                queue.add(new Freq(key,map.get(key)));
            }else if (map.get(key) > queue.peek().freq){
                queue.remove();
                queue.add(new Freq(key,map.get(key)));
            }
        }

        LinkedList<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()){
            list.add(queue.remove().e);
        }
        return list;
    }
}
