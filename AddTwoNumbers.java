/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * Problem: https://leetcode.com/problems/add-two-numbers/
 */
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      
        boolean done = false, carry = false;
        ListNode currNode1 = l1;
        ListNode currNode2 = l2;
        ListNode newNode = new ListNode();
        ListNode root = newNode;
        
        int num;

        // We have at least one digit to start
             
        num = currNode1.val + currNode2.val;
                
        // Apply carry val if there is one from previous calculation
        if(carry){
            num += 1;
            carry = false;
        }
                
        //Check if we will have carry over
        if(num >= 10){
            carry = true;
            num = num % 10;
        }
                
        newNode.val = num;
               
        currNode1 = currNode1.next;
        currNode2 = currNode2.next;
        
        // Then, we move into 4 possible cases
        while (!done){  
            
            // Case 1: Both nodes have numbers. May have carry over.
            if( currNode1 != null && currNode2 != null){
                
                num = currNode1.val + currNode2.val;
                
                // Apply carry val if there is one from previous calculation
                if(carry){
                    num += 1;
                    carry = false;
                }
                
                //Check if we will have carry over
                if(num >= 10){
                    carry = true;
                    num %= 10;
                }
                
                newNode.next = new ListNode(num);
                newNode = newNode.next;
               
                currNode1 = currNode1.next;
                currNode2 = currNode2.next;
            }
            
            // Case 2: Node 1 has a number but node 2 does not
            else if( currNode1 != null && currNode2 == null){
                 
                num = currNode1.val;
                
                // Apply carry val if there is one from previous calculation
                if(carry){
                    num += 1;
                    carry = false;
                }
                
                //Check if we will have carry over
                if(num >= 10){
                    carry = true;
                    num %= 10;
                }
                
                newNode.next = new ListNode(num);
                newNode = newNode.next;
                
                currNode1 = currNode1.next;
            }
            // Case 3: Node 2 has a number but node 1 does not    
            else if( currNode1 == null && currNode2 != null){
                
                num = currNode2.val;
                
                // Apply carry val if there is one from previous calculation
                if(carry){
                    num += 1;
                    carry = false;
                }
                
                //Check if we will have carry over
                if(num >= 10){
                    carry = true;
                    num %= 10;
                }
                
                newNode.next = new ListNode(num);
                newNode = newNode.next;
                
                currNode2 = currNode2.next;
            }
            // Case 4: Neither node has a number so we are done, but we might have to add a final carry.
            else{
                
                if(carry){
                    newNode.next = new ListNode(1);
                    newNode = newNode.next;
                }
                
                done = true;
            }
            
        }
        
        return root;

    }
    

}
