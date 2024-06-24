package com.jiat.linkedlists;

public class Test2 {
    public static void main(String[] args) {
//        SinglyCircularLinkedList circularLinkedList = new SinglyCircularLinkedList();
//        circularLinkedList.insertAtBeginning(20);
//        circularLinkedList.insertAtBeginning(10);
//        circularLinkedList.insertAtBeginning(5);
//        circularLinkedList.insertAtLast(20);
//        circularLinkedList.insertAtBeginning(30);
//        circularLinkedList.insertAtLast(8);
//        System.out.println(circularLinkedList);
//        circularLinkedList.delete(2);
//        System.out.println(circularLinkedList);

        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insert(10);
        linkedList.insert(20);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insert(50);
        linkedList.reverse();
        System.out.println(linkedList);
    }
}
