package com.sarues.linkedlist.leetcode.Id203;

/**
 * 用虚拟头节点处理该问题，不用考虑头节点的特殊性，所有节点一视同仁
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);  //虚拟头节点
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val == val){
               prev.next = prev.next.next;
            }
            else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
