package com.sarues.linkedlist.leetcode.Id203;

/**
 * 递归解决
 *  1->2->6->3->4->5->6
 */
public class Solution3 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return null;
//        ListNode res = removeElements(head.next,val);
//        if(head.val == val)
//            return res;
//        else{
//            head.next = res;
//            return head;
//        }
        head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;

    }
}
