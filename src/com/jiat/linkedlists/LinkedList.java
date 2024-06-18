package com.jiat.linkedlists;

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

    public void insert(int value,int index){
        if(index<0){
            throw new IllegalArgumentException("Index cannot be negative");
        }

        if(index == 0){
            insertFirst(value);
        }else{
            Node node = new Node(value);
            Node current = head;
            for(int i = 0;i<index-1&&current!=null;i++){
                current = current.next;
            }

            if(current == null){
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

@Override
public String toString (){
StringBuilder builder = new StringBuilder("[");
Node current = head;
while (current!=null){
    builder.append(current.data);

    if(current.next!=null){
        builder.append(",");
    }
    current = current.next;
}
return  builder.append("]").toString();
}


    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }
}
