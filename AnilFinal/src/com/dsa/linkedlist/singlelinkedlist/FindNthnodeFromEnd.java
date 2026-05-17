package com.dsa.linkedlist.singlelinkedlist;

import com.dsa.linkedlist.singlelinkedlist.findCycleInLl.Node;

public class FindNthnodeFromEnd {
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

	public void findNthNodeFromEnd(int n) {
		if (head == null) {
			return;
		}
		Node first = head;
		Node second = head;
		for (int i = 1; i <= n; i++) {
			first = first.next;
		}
		while (first != null) {
			first = first.next;
			second = second.next;
		}
		System.out.println("The " + n + "th node from the end is = " + second.data);
	}

	public static void main(String[] args) {

		// Example input
		int n = 2;
		FindNthnodeFromEnd list = new FindNthnodeFromEnd();
		list.addAtEnd(10);
		list.addAtEnd(20);
		list.addAtEnd(30);
		list.addAtEnd(40);
		list.addAtEnd(50);
		list.addAtEnd(60);
		list.findNthNodeFromEnd(n);

	}
}