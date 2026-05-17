package com.dsa.linkedlist.doubleinkedlist;

class Node {
	Node next;
	Node previous;
	int data;

	public Node(int data) {
		this.data = data;
	}
}

public class DoubleLinkedListImpl {

	Node head;
	Node tail;

	public void addFirst(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = tail = newNode;
			return;
		}

		newNode.next = head;
		head.previous = newNode;
		head = newNode;
	}

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

	public void traversalForward() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " <-> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public int size() {
		int count = 0;
		Node temp = head;

		while (temp != null) {
			count++;
			temp = temp.next;
		}

		return count;
	}

	public void insertAtPosition(int index, int data) {

		if (index < 1 || index > size() + 1) {
			System.out.println("Invalid Position");
			return;
		}

		if (index == 1) {
			addFirst(data);
			return;
		}

		if (index == size() + 1) {
			addLast(data);
			return;
		}

		Node newNode = new Node(data);
		Node temp = head;
		/*
		 * If I need to add at 4th place, I need to go till 3rd place. In that case it
		 * will break the loop.
		 * 
		 * Yes — that is the correct way to think about insertion.
		 */

		for (int i = 1; i < index - 1; i++) {
			temp = temp.next;
		}

		newNode.next = temp.next;
		newNode.previous = temp;

		temp.next.previous = newNode;
		temp.next = newNode;
	}

	public void deleteFirst() {
		if (head == null) {
			return;
		}
		if (head.next == null) {
			head = tail = null;
			return;
		}
		head = head.next;
		head.previous = null;
	}

	public void deleteLast() {
		if (head == null) {
			return;
		}
		if (head.next == null) {
			head = tail = null;
			return;
		}
		tail = tail.previous;
		tail.next = null;

	}

	// Return size of list
	public int size1() {
		int count = 0;
		Node temp = head;

		while (temp != null) {
			count++;
			temp = temp.next;
		}

		return count;
	}

	public void deleteAtPosition(int index) {
		if (index < 1 || index > size()) {
			return;
		}
		if (index == 1) {
			deleteFirst();
			return;
		}
		if (index == size()) {
			deleteLast();
			return;
		}
		Node temp = head;
		for (int i = 1; i < index - 1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		temp.next.previous = temp;

		// For better readbility we can take one extra node
		// Node deleteNode = temp.next;
		// temp.next = deleteNode.next;
		// deleteNode.next.previous = temp;

	}

	public boolean findTheGivenNode(int input) {

		Node temp = head;
		while (temp != null) {
			if (temp.data == input) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public static void main(String[] args) {

		DoubleLinkedListImpl dll = new DoubleLinkedListImpl();

		dll.addLast(10);
		dll.addLast(20);
		dll.addLast(30);
		dll.addLast(40);
		dll.addLast(50);

		dll.traversalForward();

		dll.insertAtPosition(3, 25);

		dll.traversalForward();
		dll.deleteFirst();
		dll.traversalForward();
		dll.deleteAtPosition(3);
		dll.traversalForward();

		if (dll.findTheGivenNode(20)) {
			System.out.println("the given node is present in the list");
		} else {
			System.out.println("not present");
		}

	}
}