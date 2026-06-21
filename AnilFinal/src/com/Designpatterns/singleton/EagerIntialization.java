package com.Designpatterns.singleton;

public class EagerIntialization {
	private static EagerIntialization createInstance = new EagerIntialization();

	private EagerIntialization() {

	}

	private static EagerIntialization callMethodToCreateInstance() {
//		if (createInstance == null) {
//			createInstance = new EagerIntialization();
//		}
		/*
		 * already guarantees object creation.
		 * 
		 * So null check is meaningless in eager singleton.
		 */
		return createInstance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				"the first object hasecode is = " + EagerIntialization.callMethodToCreateInstance().hashCode());
		System.out.println(
				"the second object hasecode is = " + EagerIntialization.callMethodToCreateInstance().hashCode());

	}

}
