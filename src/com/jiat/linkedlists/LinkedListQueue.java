package com.jiat.linkedlists;

public class LinkedListQueue {

    private Node head;
    private int size;

    public void enqueue(int data){
        Node node = new Node(data);

        if(head==null){
            head = node;
        }else{
            Node current = head;
            while (current.next!=null){
                current = current.next;
            }
            current.next= node;
        }
        size++;
    }


    public int dequeue(){
        if(head==null){
            throw new RuntimeException();
        }
Node node = head;
head= head.next;
return node.data;
    }

    public int peek(){
        if(head==null){
            throw new RuntimeException();
        }
        return head.data;
    }

    private static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }
}
