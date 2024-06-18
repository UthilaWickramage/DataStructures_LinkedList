package com.jiat.linkedlists;

import org.w3c.dom.Node;

public class LinkedList {

    private Node head;
    private int size;

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null)
            head = node;
        else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public void insert(int value, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }

        if (index == 0) {
            insertFirst(value);
        } else {
            Node node = new Node(value);
            Node current = head;
            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.next;
            }

            if (current == null) {
                throw new IndexOutOfBoundsException("Index is out of Bound");
            }
            node.next = current.next;
            current.next = node;
        }


    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }


    public void delete(int value) {
        if (head == null) {
            throw new IllegalArgumentException("No value found");
        } else {
            if (head.data == value) {
                head = head.next;
            } else {
                Node current = head;
                while (current.next != null && current.next.data != value) {
                    current = current.next;
                }
                if (current == null || current.next == null) {
                    throw new IndexOutOfBoundsException();
                }
                current.next = current.next.next;

            }
        }
    }

    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public void reverse() {
        Node current = head, next = null, previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    public int getSize(){
        Node current = head;
        int count = 0;
        while(current.next!=null){
            count++;
        }
        return count;

    }

    public void deleteByIndex(int index) {
        if (head == null) {
            throw new RuntimeException("List is Empty");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.next;
            }
            if (current != null) {
                current.next = current.next.next;
            }
        }
        size--;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            builder.append(current.data);

            if (current.next != null) {
                builder.append(",");
            }
            current = current.next;
        }
        return builder.append("]").toString();
    }


    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
