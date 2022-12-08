package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给一个数组：[1, 2, 2]，找出所有子数组，例如这个数组的子数组有：[], [1], [2], [1, 2], [2, 2], [1, 2, 2]
 */
public class Subsets {
    static Set<List<Integer>> res = new HashSet<>();

    public static Set<List<Integer>> subsets(int[] nums) {
        trackback(0, nums, new ArrayList<Integer>());
        return res;
    }

    public static void trackback(int index, int[] nums, List<Integer> list) {
        res.add(new ArrayList<Integer>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            trackback(i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        System.out.println("subsets: " + subsets(a));
    }
}
