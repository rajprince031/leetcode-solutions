/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        if(count == 0 || count == 1) return head;
        k = k % count;
        while(k-- > 0){
            ListNode temp = head;
            ListNode prev = null;
            while(temp.next != null){
                prev = temp;
                temp = temp.next;
            }
            if(prev != null) prev.next = null;
            temp.next = head;
            head = temp;
        }
        return head;
    }
}