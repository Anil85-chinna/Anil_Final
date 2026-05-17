package com.dsa.linkedlist.doubleinkedlist;

public class ReverseDoublyLinkedList {

	Node head;
	Node tail;

	// Add at end
	public void addLast(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = tail = newNode;
			return;
		}

		tail.next = newNode;
		newNode.previous = tail;
		tail = newNode;
	}

	// Forward traversal
	public void traversalForward() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " <-> ");
			temp = temp.next;
		}

		System.out.println("null");
	}

	// Backward traversal
	public void traversalBackward() {
		Node temp = tail;

		while (temp != null) {
			System.out.print(temp.data + " <-> ");
			temp = temp.previous;
		}

		System.out.println("null");
	}

	// Reverse Doubly Linked List
	public void reverseDLL() {

		if (head == null || head.next == null) {
			return;
		}

		Node oldHead = head;
		Node temp = null;
		Node current = head;

		while (current != null) {

			temp = current.previous;
			current.previous = current.next;
			current.next = temp;

			current = current.previous;
		}

		head = temp.previous;
		tail = oldHead;
	}

	public static void main(String[] args) {

		ReverseDoublyLinkedList dll = new ReverseDoublyLinkedList();

		dll.addLast(10);
		dll.addLast(20);
		dll.addLast(30);
		dll.addLast(40);

		System.out.println("Before Reverse:");
		dll.traversalForward();

		dll.reverseDLL();

		System.out.println("After Reverse:");
		dll.traversalForward();

		System.out.println("Backward Traversal:");
		dll.traversalBackward();
	}
}