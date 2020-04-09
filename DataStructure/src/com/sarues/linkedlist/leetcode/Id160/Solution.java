package com.sarues.linkedlist.leetcode.Id160;

import java.util.List;

/**
 *

编写一个程序，找到两个单链表相交的起始节点。
        注意：
        如果两个链表没有交点，返回 null.
        在返回结果后，两个链表仍须保持原有的结构。
        可假定整个链表结构中没有循环。
        程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
*
 * 解题思路
 * 可以理解为两个人走相同长的路程，速度一样，如果两人最后一段路重合，那么最后一段距离一定是手牵手肩并肩一起走的。
 * 我先走进自己的路，然后走你的路，你先走你自己的路，然后再走我的路。我们走的路程就相同，速度一样的话那么我们一定会在相交处汇合。
 */


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)   //先判断给的的两个头节点是否有null，直接返回 null.
               return null;
        ListNode Pa = headA;  //选手a,先沿着headA头节点出发
        ListNode Pb = headB;  //选手b,先沿着headB头节点出发
        while(Pa != Pb){      //循环条件是两人不相遇
            Pa = Pa == null ? headB : Pa.next;  //a选手先沿headA节点的路径出发，如果为null则跑去headB的节点路径
            Pb = Pb == null ? headA : Pb.next;  //b选手先沿headB节点的路径出发，如果为null则跑去headA的节点路径
        }
        return Pa;   //循环结束后，返回a选手或者b选手指定的节点。有两种情况，一是存在相交点，那么最终会停在相交的节点处被返回
                     //情况二是两个路径不相交，那么两个选手都指向null值的时候，也会使循环结束。
    }
}
