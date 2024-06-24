package com.jiat.linkedlists;

public class DoublyLinkedList {

    Node head;
    int size;

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.previous = current;
        }
    }

    public void insert(int value, int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            insertAtBeginning(value);
        } else {
            Node node = new Node(value);
            Node current = head;

            for (int i = 0; i < index - 1 & current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                throw new IndexOutOfBoundsException();
            }
            node.next = current.next;
            node.previous = current;
            if (current.next != null) {
                current.next.previous = node;
            }
            current.next = node;
        }


    }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        if (head != null) {
            head.previous = node;
        }
        node.next = head;
        head = node;
    }

    public void delete(int value) {
        if (head == null) {
            throw new IllegalArgumentException();
        } else {
            if (head.data == value) {
                head = head.next;
                if (head != null) {
                    head.previous = null;
                }
            } else {
                Node current = head;
                while (current != null && current.next.data != value) {
                    current = current.next;
                }
                if (current != null) {
                    if (current.next != null) {
                        current.next.previous = current.previous;
                    }
                    if (current.previous != null) {
                        current.previous.next = current.next;
                    }
                }
            }
        }
    }

    public void deleteByIndex(int index){
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
            if(current==null){
                throw new IndexOutOfBoundsException();
            }
            if(current.previous!=null){
                current.previous.next = current.next.previous;
            }

            if(current.next!=null){
                current.next = current.next.next;

            }

        }
        size--;
    }

    public void reverse(){
        Node current = head, node = null;
        while (current!=null){
                node = current.previous;
                current.previous = current.next;
                current.next = node;
                current = current.previous;
        }
        if(node!=null){
            head= node.previous;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        DoublyLinkedList.Node current = head;
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
        Node next, previous;

        private Node(int data) {
            this.data = data;
        }
    }


}
