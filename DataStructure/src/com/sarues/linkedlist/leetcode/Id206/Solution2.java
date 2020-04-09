package com.sarues.linkedlist.leetcode.Id206;
import java.util.ArrayList;

/**
 * 思路：
 */
class Solution2 {
    public ListNode reverseList(ListNode head) {
       if(head == null || head.next == null)
           return head;
       ListNode prev = null;   //prev节点用于指定当前节点的前一个节点该是什么，初始为null
       ListNode cur = head;    //cur节点用于指定当前遍历到节点。
       while (cur != null){
            ListNode nextTemp = cur.next;  //找出当前节点的下一个节点，
            cur.next = prev;   //反转链表，将当前节点的前一个节点（prev）连接到当前节点后面
            prev = cur;        //维护prev，用于指定当前节点的下一个节点的前一个节点
            cur = nextTemp;    //维护cur，
       }
       return prev;   //遍历结束后prev节点指向的节点为反转链表的头节点。
    }
}
