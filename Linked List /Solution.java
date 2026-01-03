/*
Problem: Flattening the Linked List 
Approach: Recursion Stack 
Time Complexity: O(n)
Space Complexity: O(n)
*/





class Solution {

    // Function to merge two sorted bottom-linked lists
    Node merge(Node a, Node b) {
        // Base cases
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data <= b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null; // Important: remove next pointer
        return result;
    }

    // Function to flatten the linked list
    Node flatten(Node root) {
        // Base case
        if (root == null || root.next == null)
            return root;

        // Recursively flatten the rest of the list
        root.next = flatten(root.next);

        // Merge current list with flattened next list
        root = merge(root, root.next);

        return root;
    }
}
