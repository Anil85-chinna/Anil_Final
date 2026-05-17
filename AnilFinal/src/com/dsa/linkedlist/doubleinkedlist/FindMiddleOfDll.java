package com.dsa.linkedlist.doubleinkedlist;

public class FindMiddleOfDll {

	Node head;
	Node tail;

	class Node {
		int data;
		Node previous;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	// Add Node at End
	public void addNode(int data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}

		tail.next = newNode;
		newNode.previous = tail;
		tail = newNode;
	}

	// Display List
	public void display() {

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println();
	}

	public Node middleOfDll() {
		if (head == null) {
			return null;
		}
		if (head == tail) {
			System.out.println(head.data);
			return head;
		}
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("The middle node is = " + slow.data);
		return slow;
	}

	public void deleteMiddleNote() {
		Node middle = middleOfDll();
		Node prev = middle.previous;
		Node next = middle.next;

		if (prev != null) {
			prev.next = next;
		} else {
			head = next;
		}

		if (next != null) {
			next.previous = prev;
		} else {
			tail = prev;
		}

	}

	public static void main(String[] args) {

		FindMiddleOfDll list = new FindMiddleOfDll();

		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.addNode(50);
		list.addNode(60);

		list.display();
		list.middleOfDll();
	}
}