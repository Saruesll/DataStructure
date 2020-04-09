package com.sarues.linkedlist.leetcode.Id21;


import javax.xml.soap.Node;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(-1);   //虚拟头节点
        ListNode cur = dummyHead;   //指定插入节点的前一个节点
        while (l1 != null && l2 != null){    //循环条件，不知道循环多少次，使用while循环

            if(l1.val <= l2.val){  //情况一，l1节点指定的值小于等于l2，故应该将l1的值插入
                cur.next = l1;     //插入
                cur = cur.next;    //维护待插入节点的前一个节点的位置
                l1 = l1.next;      //维护l1
            }else{                 //情况二，l1节点指定的值大于l2，故应该将l2的值插入
                cur.next = l2;     //插入
                cur = cur.next;    //维护待插入节点的前一个节点的位置
                l2 = l2.next;      //维护l2
            }
        }
        cur.next = l1 == null ? l2:l1;  //循环结束，肯定存在一个节点为空或者两个都为空，判断谁为空并将不是空的插入
        return dummyHead.next;          //返回虚拟头节点的下一个节点。
    }
}
