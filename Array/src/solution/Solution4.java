package solution;

import java.util.TreeSet;

/**
 * Created by slsan on 2018/9/12.
 */
public class Solution4 {

    public int solution(String[] words) {
        String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.",
                "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.",
                "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-",
                ".--", "-..-", "-.--", "--.."};

        TreeSet<String> tree = new TreeSet<>();

        for (String word : words) {
            StringBuilder res = new StringBuilder();

            for (int i = 0; i < word.length() ; i++) {
                res.append(codes[word.charAt(i) - 'a']);
            }
            tree.add(res.toString());
        }

        return tree.size();
    }
}
