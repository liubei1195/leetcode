package leetcode;

import java.util.Random;

/**
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthLargest {
    /*
    参考https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
    三种解法：1 暴力解法 2 减而治之 3 优先队列
     */

    // 1 暴力解法：排序后取第k个最大的元素
//    public int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        Arrays.sort(nums);
//        return nums[len - k];
//    }

    // 2 减而治之：借助快速排序的子过程partition操作；注意：随机化pivot以避免极端测试用例
    private final static Random random = new Random(System.currentTimeMillis());

    public int findKthLargest(int[] nums, int k) {
        // 第1大的数，下标是len-1
        // 第2大的数，下标是len-2
        // 第k大的数，下标是len-k
        int len = nums.length;
        int target = len - k;

        int left = 0;
        int right = len - 1;
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

    }

    private int partition(int[] nums, int left, int right) {
        // 随机交换第一个元素与他后面的任意一个元素的位置
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);

        int pivot = nums[left];
        int le = left + 1;
        int ge = right;
        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
            if (le > ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
