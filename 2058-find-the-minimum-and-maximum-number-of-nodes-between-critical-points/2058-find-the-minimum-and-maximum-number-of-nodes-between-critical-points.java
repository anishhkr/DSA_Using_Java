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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = {-1, -1};
        
        if (head == null || head.next == null || head.next.next == null) {
            return result; 
        }
        
        int index = 2; // start from the second node (1-based indexing)
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        
        int firstCritical = -1;
        int lastCritical = -1; 
        int minDistance = Integer.MAX_VALUE;
        
        while (next != null) {
            // Check if current node is a local maxima or minima
            if ((curr.val > prev.val && curr.val > next.val) || 
                (curr.val < prev.val && curr.val < next.val)) {
                
                if (firstCritical == -1) {
                    firstCritical = index; // first critical point found
                } else {
                    // update minDistance between consecutive critical points
                    minDistance = Math.min(minDistance, index - lastCritical);
                }
                lastCritical = index; // update last critical point
            }
            
            // Move forward
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }
        
        if (firstCritical != -1 && lastCritical != firstCritical) {
            result[0] = minDistance;
            result[1] = lastCritical - firstCritical; // max distance
        }
        
        return result;
    }
}
