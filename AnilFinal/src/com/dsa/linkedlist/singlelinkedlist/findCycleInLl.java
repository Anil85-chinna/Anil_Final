package com.dsa.linkedlist.singlelinkedlist;

public class findCycleInLl {

    Node head;
    Node tail;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    // Add node at end
    public void addAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    // Detect cycle using Floyd Algorithm
    public boolean detectCycle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;          // move 1 step
            fast = fast.next.next;    // move 2 steps

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        findCycleInLl list = new findCycleInLl();

        list.addAtEnd(10);
        list.addAtEnd(20);
        list.addAtEnd(30);
        list.addAtEnd(40);
        list.addAtEnd(50);
        list.addAtEnd(60);

        // Creating cycle: 60 -> 30
        list.tail.next = list.head.next.next;

        if (list.detectCycle()) {
            System.out.println("Given linked list has cycle / loop");
        } else {
            System.out.println("Given linked list has no cycle");
        }
    }
}