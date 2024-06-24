package com.jiat.linkedlists;

public class SinglyCircularLinkedList {

    private Node head;

    public void insertAtLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            node.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = node;
            node.next = head;
        }
    }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            node.next = head;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            node.next = head;
            current.next = node;
            head = node;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node current = head;
//        do {
//            builder.append(current.value);
//            current = current.next;
//            if (current != head) {
//                builder.append(",");
//            }
//        } while (current != head);

        while (current.next!=head){
            builder.append(current.value);
            if(current!=head){
                builder.append(",");
            }
            current = current.next;
        }


        return builder.append("]").toString();
    }

    public void insertAtIndex(int index, int value) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            insertAtBeginning(value);
        } else {
            Node node = new Node(value);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                if (current.next != head) {
                    throw new IndexOutOfBoundsException();
                }
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
    }

    public void delete(int index) {
        if (head != null && index >= 0) {
            if (index == 0) {
                if (head.next == head) {
                    head = null;
                } else {
                    Node current = head;
                    while (current.next != head) {
                        current = current.next;
                    }
                    current.next = head.next;
                    head = head.next;
                }
            } else {
                Node current = head;
                Node previous = null;
                for (int i = 0; i < index; i++) {
                    if (current.next == head) {
                        throw new IndexOutOfBoundsException();
                    }
                    previous = current;
                    current = current.next;
                }
                previous.next = current.next;
                
            }
        }
    }

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
