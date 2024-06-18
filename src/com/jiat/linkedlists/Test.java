package com.jiat.linkedlists;

public class Test {
    public static void main(String[] args) {
LinkedList linkedList = new LinkedList();
linkedList.insert(20);
linkedList.insertFirst(10);
linkedList.insert(30,2);
        System.out.println(linkedList);
linkedList.delete(20);
        System.out.println(linkedList);

        linkedList.insert(40);
        linkedList.insert(50);
        System.out.println(linkedList);
        linkedList.deleteByIndex(3);
        System.out.println(linkedList);

        linkedList.reverse();
        System.out.println(linkedList);
            System.out.println(linkedList.getSize());
    }
}
