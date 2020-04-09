package com.sarues.linkedlist.leetcode.Id141;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。

 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 *
 */

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)  //先判断给的头节点是否为空或者它的下一个节点为空，直接返回false
            return false;
        ListNode fast = head;  //定义快指针，先指向头节点
        ListNode slow = head;  //定义慢指针，先指向头节点
        while (fast != null && fast.next != null){  //不知循环多少次，使用while循环，条件是快指针为空或者快指针的next为空
            fast = fast.next.next;    //快指针跑得快每次跑两个节点
            slow = slow.next;         //慢指针每次跑一个节点
            if(slow == fast)          //如果有环，那么最终快指针会和慢指针重合，返回true;
                return true;
        }
        return false;                //上述条件判断完毕，说明没有环，则返回false
    }
}