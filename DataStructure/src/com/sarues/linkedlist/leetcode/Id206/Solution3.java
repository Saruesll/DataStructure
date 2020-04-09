package com.sarues.linkedlist.leetcode.Id206;

/**
 * 思路：
 */
class Solution3 {
    public ListNode reverseList(ListNode head) {
      if(head == null || head.next == null)
          return head;
      ListNode p = reverseList(head.next);
      head.next.next = head;
      head.next = null;
      return p;
    }
}
