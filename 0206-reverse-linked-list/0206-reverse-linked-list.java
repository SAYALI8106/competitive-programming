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
    public ListNode reverseList(ListNode head) {

        // time -> O(n)
        // space -> O(n)
        // Stack<Integer> stack = new Stack<>();
        // ListNode temp = head;

        // while (temp != null) {
        //     stack.push(temp.val);
        //     temp = temp.next;
        // }

        // temp = head;

        // while(temp!=null){
        //     temp.val = stack.pop();
        //     temp = temp.next;
        // }

        // return head;

        // time -> O(n)
        // space -> O(1)

        // ListNode temp = head;
        // ListNode prev = null;

        // while (temp != null) {
        //     ListNode front = temp.next;
        //     temp.next = prev;
        //     prev = temp;
        //     temp = front;
        // }

        // return prev;

        // recursive approach

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        
        // store the front node
        ListNode front = head.next;

        // point the next node to the current node
        front.next = head;

        // remove the forward link
        head.next = null;

        // return the new head
        return newHead;

        // [1,2,3,4,5]
        // [2,3,4,5]
        // [3,4,5]
        // [4,5]
        // [5]

        // [5]
        // [5->4]
    }
}

// [1,2,3,4,5]
// prev = null,1    temp = 1,2    front = 2,3
// null<-1<- 2
// null <-1<-2<-3