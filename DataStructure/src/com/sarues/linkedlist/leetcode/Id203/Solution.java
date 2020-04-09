package com.sarues.linkedlist.leetcode.Id203;




/**
 * id 203
 * 删除链表中等于给定值 val 的所有节点。
 *
 *         示例:
 *
 *         输入: 1->2->6->3->4->5->6, val = 6
 *         输出: 1->2->3->4->5
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //处理头节点的值等于指定值的情况，可能存在连续几个头节点都为指定值的情况，用while循环。
        while (head != null && head.val == val){
               ListNode delNode = head;
               head = head.next;
               delNode.next = null;
        }

        //处理完头节点之后，可能链表为空，直接返回
        if(head == null)
            return null;

        //处理头节点不是指定值的情况，找到待删除节点之前的节点
        ListNode prev = head;
        while (prev.next != null){
           if(prev.next.val ==  val){
               ListNode delnode = prev.next;
               prev.next = delnode.next;
               delnode.next = null;
           }
           else
               prev = prev.next;
        }

        return head;
    }
}