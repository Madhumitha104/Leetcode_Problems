class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static ListNode deserialize(String data) {
        if (data == null || data.isEmpty() || data.equals("[]")) {
            return null;
        }
        data = data.replace("[", "").replace("]", ""); 
        String[] parts = data.split(","); 
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String part : parts) {
            current.next = new ListNode(Integer.parseInt(part.trim()));
            current = current.next;
        }
        return dummy.next; 
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode current = this;
        result.append("[");
        while (current != null) {
            result.append(current.val);
            if (current.next != null) {
                result.append(",");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }
}
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); 
        ListNode current = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10; 
            current.next = new ListNode(sum % 10); 
            current = current.next;
        }
        return dummy.next; 
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = ListNode.deserialize("[2,4,3]");
        ListNode l2 = ListNode.deserialize("[5,6,4]");
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println(result); 
    }
}