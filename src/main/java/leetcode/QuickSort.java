package leetcode;

/**
 * 快速排序
 */
public class QuickSort {
    /**
     * 思路：先找一个基准点，声明两个指针：left和right，right指针从最右边向左边走，直到找到比基准点小的元素。
     * left从最左边往右走，直到找到比基准点大的元素，然后将两个指针指向的元素互换位置。然后两个指针继续走，找到符合条件的元素就互换，
     * 直到两个指针相遇，这时将相遇点的元素和基准点元素互换位置，这样基准点左侧的元素都比他小，右边的元素都比他大，然后以基准点为界分为
     * 左右两个数组，递归调用快速排序方法，直到区间缩小为1.
     *
     * @param target
     * @param left
     * @param right
     */
    public static void quickSort(int[] target, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = target[left]; // 基准点
        int i = left;
        int j = right; // 后面做迭代的时候还需要用到最初的left和right
        while (i < j) {
            // 如果右指针指向的元素一直大于或等于基准点，则一直向左走，直到找到比基准点小的元素
            while (target[j] >= pivot && i < j) {
                j--;
            }
            // 如果左指针指向的元素一直都小于或等于基准点，则一直往右走，直到找到比基准点大的;
            while (target[i] <= pivot && i < j) {
                i++;
            }
            // 此时右指针指向的元素<基准点，左指针指向的元素>基准点，将两个元素做交换
            if (i < j) {
                int temp = target[i];
                target[i] = target[j];
                target[j] = temp;
            }
        }
        // 这里左右指针相遇了
        // 1 将相遇点的元素和基准点做交换
        target[left] = target[j];
        target[j] = pivot;
        // 2 基准点两边的元素分别在做排序
        quickSort(target, left, j - 1);
        quickSort(target, j + 1, right);
    }
}
