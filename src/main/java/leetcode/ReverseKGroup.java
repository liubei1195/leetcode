package leetcode;

/**
 * @Author: bainliu
 * @Date: 2022/11/17 下午5:28
 * @Desc 25. K 个一组翻转链表
 *         给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 *         k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *         你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换
 */
public class ReverseKGroup {
    /*
    思路：把链表分为已翻转部分+待翻转部分+未翻转部分
    每次翻转链表的长度是k
    需记录翻转链表的前驱和后继，方便翻转完完成后把已翻转部分和未翻转部分连接起来
    初始化需要两个变量pre和end，pre代表待翻转链表的前驱，end代表待翻转链表的末尾
    经过k次循环，end到了末尾，记录待翻转链表的后继 next = end.next
    翻转链表，然后将三部分链表连接起来，然后重置pre和end指针，然后进入下一次循环
    当翻转部分的长度不足k时，end==null，结束

     */

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        // 定义一个假的节点(桩节点)
        ListNode dummy = new ListNode(0);
        // 假节点的next指向head, dummy->1->2->3……
        dummy.next = head;
        // 初始化pre和end
        ListNode pre = dummy; // 要翻转链表的头结点的前驱
        ListNode end = dummy; // 每次翻转链表的尾节点
        while (end.next != null) {
            // 循环k次，找到需要翻转的链表的结尾
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 如果end=null，即需要翻转的链表的节点数小于k，不执行翻转
            if (end == null) {
                break;
            }
            // 先记录下end.next 方便后面链接链表
            ListNode next = end.next;
            // 然后断开链表
            end.next = null;
            // 记录要翻转链表的头结点
            ListNode start = pre.next;
            // 翻转链表，pre.next指向翻转后的链表。
            pre.next = reverse(start);
            // 翻转后头结点变到最后，通过.next把断开的链表重新链接
            start.next = next;
            // 把pre换成下次要翻转的链表的头结点的上一个节点，即start
            pre = start;
            // 翻转结束，将end置为下次要翻转的链表的头结点的上一个节点，即start
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode cur = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
