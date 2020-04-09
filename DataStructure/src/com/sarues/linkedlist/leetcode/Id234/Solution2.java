package com.sarues.linkedlist.leetcode.Id234;

import java.util.ArrayList;

class Solution2 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null )
            return true;
        ArrayList<Integer> list = new ArrayList();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        for (int i = 0; i < list.size()/2; i++) {
            if(!list.get(i) .equals(list.get(list.size() - i - 1)))
                return false;
        }
        return true;
    }
}