package com.Designpatterns.singleton;

public class BillPughSingleton {
	private BillPughSingleton() {
	}

	public static class SingletonInstanceCreation {
		private final static BillPughSingleton singletonInstance = new BillPughSingleton();
	}

	public static BillPughSingleton methodcallForObjectCreation() {
		BillPughSingleton singletonObject = SingletonInstanceCreation.singletonInstance;
		return singletonObject;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				"using BILLPUGH first object is = " + BillPughSingleton.methodcallForObjectCreation().hashCode());
		System.out.println(
				"using BILLPUGH second object is = " + BillPughSingleton.methodcallForObjectCreation().hashCode());

	}

}
