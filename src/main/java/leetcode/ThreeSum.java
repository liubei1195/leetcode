package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: bainliu
 * @Date: 2022/11/18 上午10:21
 * @Desc 三数之和
 */
public class ThreeSum {
    /*
    思路：排序+双指针
    先对数组进行排序，排序后固定一个数nums[i], 再使用左右指针指向nums[i]后面的两端，分别为nums[L]和 nums[R]，计算三数之和是否满足为0，满足
    则添加进ans结果集
    如果nums[i]大于0，则三数之和必然无法等于0，结束循环
    如果nums[i]==nums[i--]，说明该数字重复，会导致结果重复，所有才跳过
    当sum==0, nums[L]==nums[L+1]则会导致结果重复，应该跳过，L++
    当sum==0，nums[R]==nums[R-1]则会导致结果重复，应该跳过，R--
    当sum<0 L+=;当sum>0 R--;
    */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ans;
        }
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue; // 去重
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;//去重
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--; //去重
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }
}
