package sliding_window;

/**
 * @Author: bainliu
 * @Date: 2022/11/10 下午8:28
 * @Desc 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *         示例 1：
 *         输入：head = [1,2,3,4,5]
 *         输出：[5,4,3,2,1]
 */
public class reverseList {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null; // 前一个节点
        ListNode cur = head; // 当前节点
        ListNode tmp = null; // 临时节点
        while (cur != null) {
            // 记录当前节点的下一个节点
            tmp = cur.next;
            // 将当前节点指向pre
            cur.next = pre;
            // pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

}


class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
