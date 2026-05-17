	package com.dsa.linkedlist.singlelinkedlist;

public class reverseSingleLinkedlist {

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

	// Print linked list
	public void traversal() {

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}

		System.out.println("null");
	}

	// Reverse linked list
	public void reverse() {

		if (head == null || head.next == null) {
			return;
		}

		Node oldHead = head;

		Node prev = null;
		Node curr = head;
		Node next = null;

		while (curr != null) {

			next = curr.next;

			curr.next = prev;

			prev = curr;

			curr = next;
		}

		head = prev;
		tail = oldHead;
	}

	public static void main(String[] args) {

		reverseSingleLinkedlist list = new reverseSingleLinkedlist();

		list.addAtEnd(10);
		list.addAtEnd(20);
		list.addAtEnd(30);
		list.addAtEnd(40);
		list.addAtEnd(50);

		System.out.println("Before Reverse:");
		list.traversal();

		list.reverse();

		System.out.println("After Reverse:");
		list.traversal();
	}
}