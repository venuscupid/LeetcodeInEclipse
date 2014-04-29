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
public class Four_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode result = null;
        ListNode cur = null;
        int carry = 0;
        int sum = 0;
        
        // 1. add the common part
        while((l1 != null) && (l2 != null)){
            sum = l1.val + l2.val + carry;  // sum will need carry to be added to
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10; // take care if sum >= 10
            
            // if cur is the 1st node
            if(cur == null){
                cur = result = new ListNode(sum);
            }
            else{
                // else
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
            
            l1 = l1.next;
            l2 = l2.next;
        }
        
        // 2. append the rest of either list, remember the carry over. create a new node if needed
        if(l1 == null){ // append l2
            while(l2 != null){
                sum = l2.val + carry;
                carry = sum > 9 ? 1 : 0;
                sum = sum % 10;
                
                cur.next = new ListNode(sum);
                cur = cur.next;
                
                l2 = l2.next;
            }
        }
        if(l2 == null){ // append l1
            while(l1 != null){
                sum = l1.val + carry;
                carry = sum > 9 ? 1 : 0;
                sum = sum % 10;
                
                cur.next = new ListNode(sum);
                cur = cur.next;
                
                l1 = l1.next;
            }
        }
        
        // 3. take care of the last carry out
        if(carry == 1){
            cur.next = new ListNode(1);
        }
        
        return result;
    }
}