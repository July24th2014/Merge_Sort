
public class Solution3 {
    /**
     * The definition for the linked list. DO NOT modify this class.
     */
    public static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    /**
     * Merges two sorted lists.
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        // TODO You can copy and paste the merge() method from Assignment 1.
        ListNode MergeResult; // I create a new list --> STORED number if elements of the list

        if (l1 == null && l2 == null) { //Check whether if both of lists is empty --> Return null because there is no INTERSECTION
            return null;
        } // No merge point

        //Return the numbers that LEFT of the other list
        if (l1 == null) { //Check whether if list 1 is empty
            return l2; //EMPTY --> return list 2
        } else if (l2 == null) { //Check whether if list 2 is empty
            return l1; // EMPTY --> return list 1
        }

        if (l1.value < l2.value) { //Check which value is SMALLER --> USE that list
            MergeResult = l1; //HOLDS all the values of l1 --> Looping through the list
            MergeResult.next = merge(l1.next, l2); // Updating for the new list -> l1.next --> MOVE list 1 to the right
        } else {
            MergeResult = l2; //HOLDS all the values of l2 --> Looping through the list
            MergeResult.next = merge(l1, l2.next); // Updating for the new list -> l2.next --> MOVE list 2 to the right
    }
        return MergeResult;
    }

    public ListNode mergeSort(ListNode list, int size) {
        // TODO The method for you to implement
        // divide the array into two halves --> sort the left and right --> merge
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return list;
        }

        if (list == null || list.next == null) {
            return list;
        }
        ListNode middle = getMiddle(list);
        ListNode nextofMiddle = middle.next;
        middle.next = null;
        ListNode left = mergeSort(list,size);
        ListNode right = mergeSort(nextofMiddle,size);
        ListNode sortedlist = merge(left, right);
        return sortedlist;
    }

    public ListNode getMiddle(ListNode list)
    {
        if(list == null)
            return list;
        ListNode slow= list, fast = list;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast = fast.next.next;
        }
        return slow;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution3 solution = new Solution3();
        ListNode result = solution.mergeSort(node1, 5);
        // The output should be 2, 4, 4, 5, 8,
        while (null != result) {
            System.out.print(result.value + ", ");
            result = result.next;
        }
    }
}
