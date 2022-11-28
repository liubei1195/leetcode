package leetcode;

/**
 * @Author: bainliu
 * @Date: 2022/11/18 下午2:30
 * @Desc 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *         子数组 是数组中的一个连续部分。
 *
 *         输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 *         输出：6
 *         解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class MaxSubArray {

    /*
    首先对数组进行遍历，当前最大连续子序列和为sum，结果为ans
    如果sum>0，则说明sum对结果有增益效果，则sum保留并加上当前遍历数字
    如果sum<=0，则说明sum对结果无增益效果，需要舍弃，则sum直接更新为当前遍历的数字
    每次比较sum和ans的大小，讲最大值置为ans，遍历结束返回结果
    时间复杂度O(n)
     */
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

}
