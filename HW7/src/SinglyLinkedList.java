/**
 * The SinglyLinkedList class represents a singly linked list data structure.
 * It allows adding elements to the end of the list, reversing the list, and displaying the elements.
 */
public class SinglyLinkedList {

    /**
     * Each Node object represents a node in a singly linked list.
     * It contains an integer data and a reference to the next node in the list.
     * The constructor takes an integer as an argument and initializes the data field with it.
     */
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;

    /**
     * Adds a new node with the specified data to the end of the list.
     * If the list is empty, the new element becomes the head of the list.
     *
     * @param data the data of the new element to be added.
     */
    public void add(int data) {
        Node newNode = new Node(data);
        
        // Check if the list is empty, if so set the new node as the head. 
        if (head == null) {
            head = newNode;
            return;
        }

        // Find the end of the list
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Add the new node to the end of the list
        current.next = newNode;
    }

    /**
     * Reverses the order of the elements in the list.
     * The head of the list becomes the tail and vice versa.
     */
    public void reverse() {
        Node prev = null;
        Node current = head;
        while (current != null) {

            // Store the next node before changing the pointer
            Node next = current.next;

            // Reverse the next pointer
            current.next = prev;

            // Update prev and current for next iteration
            prev = current;
            current = next;
        }
        // After the loop, prev becomes the new head
        head = prev;
    }

    /**
     * Prints the list data from the first node to the last node.
     * The elements are printed in the order they appear in the list.
     */
    public void display() {
        Node current = head;

        // Iterate until the end of the list if found.
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("Original List:");
        list.display();

        list.reverse();
        System.out.println("Reversed List:");
        list.display();
    }
}
