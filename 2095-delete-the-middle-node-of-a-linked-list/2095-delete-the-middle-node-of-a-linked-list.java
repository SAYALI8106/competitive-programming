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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        temp = head;

        int middlePos = count / 2;

        count = 0;

        while (temp != null) {
            count++;

            if (count == middlePos) {
                temp.next = temp.next.next;
                break;
            }

            temp = temp.next;
        }

        return head;
    }
}

// [1,3,4,7,1,2,6]
// m = 7/2 = 3