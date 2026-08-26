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

        ListNode temp = head;
        ListNode prev = null;

        while(temp!=null){
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
    }
}

// [1,2,3,4,5]
// prev = null,1    temp = 1,2    front = 2,3
// null<-1<- 2
// null <-1<-2<-3