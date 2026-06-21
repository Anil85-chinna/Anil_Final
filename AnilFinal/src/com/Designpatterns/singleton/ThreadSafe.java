package com.Designpatterns.singleton;

public class ThreadSafe {
	/*
	 * Object creation internally happens in steps:
	 * 
	 * 1. Allocate memory 2. Initialize object 3. Assign reference
	 */
	private static volatile ThreadSafe createInstance;

	private ThreadSafe() {

	}

	private static ThreadSafe methodCallForCreateObject() {
		if (createInstance == null) {
			// Avoid unnecessary synchronization after object creation.
			synchronized (ThreadSafe.class) {
				if (createInstance == null) {
// Prevent multiple object creation when multiple threads enter simultaneously.
					createInstance = new ThreadSafe();
				}
			}
		}
		return createInstance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("the first object hascode is = " + ThreadSafe.methodCallForCreateObject().hashCode());
		System.out.println("the second object hascode is = " + ThreadSafe.methodCallForCreateObject().hashCode());

	}

}
