package com.dsa.linkedlist.singlelinkedlist;

public class middleOfLinkedList {
	Node head;
	Node tail;

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

	public void findMiddle() {
		Node slow = head;
		Node fast = head;
		if (head == null) {
			return;
		}

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("the middle of the given linked list is  = " + slow.data);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		middleOfLinkedList mll = new middleOfLinkedList();

		mll.addAtEnd(10);
		mll.addAtEnd(20);
		mll.addAtEnd(30);
		mll.addAtEnd(40);
		mll.addAtEnd(50);
		mll.addAtEnd(60);

		mll.findMiddle();

	}

}
