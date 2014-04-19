package v1;
import v1.common.ListNode;

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
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode head = null;
        ListNode cur = null;
        ListNode node;
        while((l1 != null) && (l2 != null)){
            if(l1.val < l2.val){
                node = l1;
                l1 = l1.next;
            }
            else{
                node = l2;
                l2 = l2.next;
            }
            
            if(head == null){ head = node; cur = head;}
            else {cur.next = node; cur = cur.next;}
        }
        if((l1 == null) && (l2 != null)) cur.next = l2;
        if((l1 != null) && (l2 == null)) cur.next = l1;
        
        return head;
    }
}