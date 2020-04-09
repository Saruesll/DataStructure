package com.sarues.linkedlist.leetcode.Id234;

class Solution {
    public boolean isPalindrome(ListNode head) {
       if(head == null || head.next == null)
           return true;

       //快慢指针寻找到该链表的终点
       ListNode fast = head;
       ListNode slow = head;
       while (fast != null && fast.next != null){
           fast = fast.next.next;
           slow = slow.next;
       }

       //反转链表
        ListNode curNode = slow;
        ListNode prev = null;
        while (curNode != null){
            ListNode nextTemp = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = nextTemp;
        }
        slow.next = null;

        //判断
        while (head != null && prev != null){
            if(head.val !=  prev.val)
                return false;
            head = head.next;
            prev = prev.next;

        }
        return true;
    }
}