package com.SiTE;


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    public void insertAtPos(int data, int position) {
        Node newNode = new Node(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        Node prev = null;
        int currentPos = 1;
        while (current != null && currentPos < position) {
            prev = current;
            current = current.next;
            currentPos++;
        }

        if (prev != null) {
            prev.next = newNode;
        }
        newNode.next = current;
    }

    public void deleteAtPosition(int position) {
        if (head == null) {
            return;
        }

        if (position == 1) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;
        int currentPos = 1;
        while (current != null && currentPos < position) {
            prev = current;
            current = current.next;
            currentPos++;
        }

        if (current == null) {
            return;
        }

        if (prev != null) {
            prev.next = current.next;
        }
    }

    public void deleteAfterNode(Node targetNode) {
        if (head == null || targetNode == null || targetNode.next == null) {
            return;
        }

        Node nextNode = targetNode.next;
        targetNode.next = nextNode.next;
    }

    public Node searchNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}

class Stack {
    LinkedList linkedList;

    Stack() {
        linkedList = new LinkedList();
    }

    public void push(int data) {
        linkedList.insertAtPos(data, 1);
    }

    public Integer pop() {
        if (linkedList.head == null) {
            return null;
        }

        int value = linkedList.head.data;
        linkedList.deleteAtPosition(1);
        return value;
    }

    public Integer peek() {
        if (linkedList.head == null) {
            return null;
        }

        return linkedList.head.data;
    }
}

public class LinkedListImp {
    public static void main(String[] args) {
        // Inserting a Node at Any Given Position in a Singly Linked List
        LinkedList linkedList = new LinkedList();
        linkedList.insertAtPos(1, 1);
        linkedList.insertAtPos(2, 2);
        linkedList.insertAtPos(3, 3);
        linkedList.insertAtPos(4, 2);

        // Deleting a Node at Any Given Position in a Singly Linked List
        linkedList.deleteAtPosition(2);

        // Deleting a Node After a Given Node in a Singly Linked List
        Node node = linkedList.searchNode(2);
        if (node != null) {
            linkedList.deleteAfterNode(node);
        }

        // Searching a Node in a Singly Linked List
        Node foundNode = linkedList.searchNode(3);
        if (foundNode != null) {
            System.out.println(foundNode.data);
        } else {
            System.out.println("Node not found");
        }

        // Implementing a Stack Using Linked Lists
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());  // Output: 3
        System.out.println(stack.peek());  // Output: 2
    }
}
