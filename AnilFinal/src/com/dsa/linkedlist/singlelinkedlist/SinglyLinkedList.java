package com.dsa.linkedlist.singlelinkedlist;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

public class SinglyLinkedList {

	Node head;
	Node tail;

	// ==================================================
	// 1. INSERT OPERATIONS
	// ==================================================

	// Add node at beginning
	public void addAtBeginning(int data) {
		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;
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

	// Insert node at given position
	public void insertAtPosition(int pos, int data) {

		if (pos < 0 || pos > size()) {
			return;
		}

		if (pos == 0) {
			addAtBeginning(data);
			return;
		}

		if (pos == size()) {
			addAtEnd(data);
			return;
		}

		Node newNode = new Node(data);
		Node temp = head;

		// move to (pos - 1)
		for (int i = 0; i < pos - 1; i++) {
			temp = temp.next;
		}

		newNode.next = temp.next;
		temp.next = newNode;
	}

	// ==================================================
	// 2. UTILITY METHODS
	// ==================================================

	// Print all nodes
	public void traversal() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}

		System.out.println("null");
	}

	// Return size of list
	public int size() {
		int count = 0;
		Node temp = head;

		while (temp != null) {
			count++;
			temp = temp.next;
		}

		return count;
	}

	// ==================================================
	// 3. DELETE OPERATIONS
	// ==================================================

	// Delete first node
	public void deleteHead() {

		if (head == null) {
			return;
		}

		head = head.next;

		// if list became empty
		if (head == null) {
			tail = null;
		}
	}

	// Delete last node
	public void deleteTail() {

		if (head == null) {
			return;
		}

		// only one node
		if (head.next == null) {
			head = null;
			tail = null;
			return;
		}

		Node temp = head;

		while (temp.next != tail) {
			temp = temp.next;
		}

		temp.next = null;
		tail = temp;
	}

	// Delete node by value
	public void deleteByValue(int value) {

		if (head == null) {
			return;
		}

		// delete head
		if (head.data == value) {
			deleteHead();
			return;
		}

		Node prev = head;
		Node curr = head.next;

		while (curr != null) {

			if (curr.data == value) {
				prev.next = curr.next;

				// if deleting tail
				if (curr == tail) {
					tail = prev;
				}

				return;
			}

			prev = curr;
			curr = curr.next;
		}
	}

	public void deleteByPosition(int pos) {

		// empty list
		if (head == null) {
			return;
		}

		// invalid position
		if (pos < 0 || pos >= size()) {
			return;
		}

		// delete first node
		if (pos == 0) {
			deleteHead();
			return;
		}

		// delete last node
		if (pos == size() - 1) {
			deleteTail();
			return;
		}

		Node temp = head;

		// move to (pos - 1)
		for (int i = 0; i < pos - 1; i++) {
			temp = temp.next;
		}

		// skip target node
		temp.next = temp.next.next;
	}
	
	// ==================================================
	// 4. MAIN METHOD
	// ==================================================

	public static void main(String[] args) {

		SinglyLinkedList list = new SinglyLinkedList();

		list.addAtEnd(10);
		list.addAtEnd(20);
		list.addAtEnd(30);

		list.addAtBeginning(5);

		list.insertAtPosition(2, 15);

		list.traversal(); // 5 -> 10 -> 15 -> 20 -> 30 -> null

		list.deleteHead();
		list.traversal(); // 10 -> 15 -> 20 -> 30 -> null

		list.deleteTail();
		list.traversal(); // 10 -> 15 -> 20 -> null

		list.deleteByValue(15);
		list.traversal(); // 10 -> 20 -> null

		System.out.println("Size: " + list.size());
	}
}