package com.jiat.linkedlists;

public class DoublyCircularLinkedList {

    private Node head;


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
            builder.append(current.data);
            if(current!=head){
                builder.append(",");
            }
            current = current.next;
        }


        return builder.append("]").toString();
    }

    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            node.next = node.previous = node;
            head = node;

        } else {
            Node last = head.previous;
            node.next = head;
            head.previous = node;
            node.previous = last;
            last.next = node;
        }
    }

    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        Node last = head.previous;

        node.next = head;
        node.previous = last;

        last.next = head.previous = node;
        head = node;
    }


    public void insertAt(int value, int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }

        if (index == 0) {
            insertAtBeginning(value);
        }
        Node node = new Node(value);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        Node next = current.next;
        current.next = node;
        node.previous = current;
        node.next = next;
        next.previous = node;


    }

//public void delete(int index){
//        if(head!=null&& index>=0){
//            if(index==0){
//                if(head.next == head){
//                    head= null;
//                }else{
//Node current = head;
//while(current.next!=head){
//    current = current.next;
//}
//current.next = head.next;
//
//head = head.next;
//                }
//            }
    //       }

//}


    public void deleteFirst() {
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head.next;
        if (current == head) {
            head = null;

        } else {
            head.next = current.next;
            current.next.previous = head;
        }
    }

    public void delete(int value) {
        Node current = head, prev = null;
        while (current.data != value) {
            if (current.next == head) {
                throw new IllegalArgumentException();
            }
            prev = current;
            current = current.next;

        }

        if (current.next == head && prev == null) {
            head = null;
        } else {
            if (current == head) {
                prev = head.previous;
                head = head.next;
                prev.next = head;
                head.previous = prev;
            } else if (current.next == head) {
                prev.next = head;
                head.next = prev;
            } else {
                Node node = current.next;

                prev.next = node;
                node.next = prev;
            }
        }
    }


    public void deleteByIndex(int index) {
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
            }
//            else {
//                Node current = head;
//                Node previous = null;
//                for (int i = 0; i < index; i++) {
//                    if (current.next == head) {
//                        throw new IndexOutOfBoundsException();
//                    }
//                    previous = current;
//                    current = current.next;
//                }
//                previous.next = current.next;
//
//            }
        }
    }


    private static class Node {
        int data;
        Node next, previous;

        private Node(int data) {
            this.data = data;
        }
    }
}
