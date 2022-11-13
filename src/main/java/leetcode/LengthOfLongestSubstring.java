package leetcode;

import java.util.HashMap;

/**
 * @Author: bainliu
 * @Date: 2022/11/10 下午7:59
 * @Desc
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {
    // https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>(); // Map<字符, 字符出现的位置>
        int max = 0; // 最大不重复子串的长度
        int left = 0; // 滑动窗口左指针
        /**
         * 思路：
         * 1、当前字符在map里不存在的话，加入到map里（字符，字符下标）
         * 2、如果存在：
         *  2.1 当前字符包含在当前有效最长子串中，如abca，当遍历到第二个a时，当前有效最长有效子串为abc，我们又遍历到a，那么此时更新left为map.get(a) +1=1,
         *  当前有效字段更新为bca;
         *  2.2 当前字符不包含在当前有效子串中，如abba，我们先添加a,b进map，此时left=0，再添加b，发现map中包含b，而且b包含在最长有效子串中，就是2.1的情况，
         *  更新left=map.get(b)+1=2,此时有效子串更新为b，而且map中有a，map.get(a)=0,如果像2.1一样处理，left=map.get(a)+1=1，实际上left应该不变，
         *  为2，子串变为ba才对
         */
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 不管是否更新left，都更新map里s.charAt(i)的位置
            map.put(s.charAt(i) , i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }

}
