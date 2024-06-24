package com.jiat.linkedlists;

public class Test3 {
    public static void main(String[] args) {
        DoublyCircularLinkedList linkedList = new DoublyCircularLinkedList();
        linkedList.insertAtEnd(10);
        linkedList.insertAtEnd(20);
        linkedList.insertAtEnd(30);
        linkedList.insertAtEnd(40);
        linkedList.insertAtBeginning(50);
        linkedList.insertAt(60,2);
        System.out.println(linkedList);

        //linkedList.delete(30);
        System.out.println(linkedList);

        linkedList.delete(30);

        System.out.println(linkedList);
    }
}
