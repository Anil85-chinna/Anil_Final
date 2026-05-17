package com.dsa.linkedlist.doubleinkedlist;

public class FindTheLoopInDll {

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

	// Add node at end
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

	public void findTheLoop() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("The list have loop");
				return;
			}

		}
	}

	public void findTheStartingNodeOfLoop() {
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				slow = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				System.out.println("the starting of the loop is = " + slow.data);
				return;
			}
		}
	}

	public static void main(String[] args) {

		FindTheLoopInDll list = new FindTheLoopInDll();

		list.addNode(10);
		list.addNode(20);
		list.addNode(30);
		list.addNode(40);
		list.addNode(50);
		list.tail.next = list.head.next.next;
		list.findTheLoop();
		list.findTheStartingNodeOfLoop();

	}
}
