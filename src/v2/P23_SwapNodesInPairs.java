package v2;

import v2.common.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//
// !!! 注意 !!!
// 把前两个node特殊处理，显得很笨拙，也很傻
// 更好的方法：
// 建立一个帮助node，作为假head，指向真head
// 算法从假head的下一个开始运行。这样就能保证真head后都可以被做好
// 最后返回假head的next指针即可

public class P23_SwapNodesInPairs
{
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        
        if(head.next == null) return head;
        
        ListNode n1 = null;
        ListNode n2 = null;
        ListNode cur = null;
        ListNode prev = null;
        
        n1 = head; n2 = head.next;
        head = n2;
        n1.next = n2.next;
        n2.next = n1;
        
        cur = n1.next;
        prev = n1;
        
        while(cur != null && cur.next != null){
            n1 = cur;
            n2 = cur.next;
            swap(prev, n1, n2);
            
            cur = n1.next;
            prev = n1;
        }
        
        return head;
    }
    
    private void swap(ListNode prev, ListNode n1, ListNode n2)
    {
        ListNode nPair = n2.next;
        prev.next = n2;
        n2.next = n1;
        n1.next = nPair;
    }
}