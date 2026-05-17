package com.dsa.linkedlist.doubleinkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUChache {
	int capacity;
	Node head;
	Node tail;
	Map<Integer, Node> storeMap;

	class Node {
		int key;
		int value;
		Node prev;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public LRUChache(int capacity) {
		this.capacity = capacity;
		this.storeMap = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
	}

	/*
	 * node.prev = head node.next = oldFirst head.next = node oldFirst.prev = node
	 */
	public void addNode(Node newNode) {

		Node temp;
		temp = head.next;
		newNode.next = temp;
		newNode.prev = head;
		head.next = newNode;
		temp.prev = newNode;

	}

	public void removeNode(Node deleteNode) {
		Node prev = deleteNode.prev;
		Node next = deleteNode.next;
		prev.next = next;
		next.prev = prev;
	}

	public void moveToFront(Node givenNode) {
		removeNode(givenNode);
		addNode(givenNode);
	}

	public void removeLastNode() {
		Node lastNode = tail.prev;
		storeMap.remove(lastNode.key);
		removeNode(lastNode);
	}

//	map.get once for get methode:
//	null check
//	moveToFront
//	return value
	public Integer get(Integer key) {
		Node existingNode = storeMap.get(key);
		if (existingNode != null) {
			moveToFront(existingNode);
			return existingNode.value;
		} else {
			return -1;
		}
	}

	public void put(int key, int data) {

		if (storeMap.containsKey(key)) {
			Node nodeFromMap = storeMap.get(key);
			nodeFromMap.value = data;
			moveToFront(nodeFromMap);
		} else {
			if (storeMap.size() >= capacity) {
				removeLastNode();
			}
			Node newNode = new Node(key, data);
			addNode(newNode);
			storeMap.put(key, newNode);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUChache cache = new LRUChache(3);

		cache.put(1, 100);
		cache.put(2, 200);
		cache.put(3, 300);

		System.out.println(cache.get(1)); // 100

		cache.put(4, 400); // removes least recently used key = 2

		System.out.println(cache.get(2)); // -1
		System.out.println(cache.get(3)); // 300
		System.out.println(cache.get(4)); // 400

		cache.put(5, 500); // removes least recently used key = 1

		System.out.println(cache.get(1)); // -1
		System.out.println(cache.get(5)); // 500

	}

}
