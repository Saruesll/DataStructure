package com.sarues.linkedlist.leetcode.Id206;
import java.util.ArrayList;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 思路：将所有节点放到list集合中，然后重新构造新链表返回
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode cur = head;
        while (cur != null){
            arr.add(cur);
            cur = cur.next;
        }
        ListNode newHead = arr.get(arr.size() - 1);
        cur = newHead;
        for (int i = arr.size() - 2; i >= 0 ; i--) {
                cur.next = arr.get(i);
                cur = cur.next;
        }
        cur.next = null;
        return newHead;
    }
}
