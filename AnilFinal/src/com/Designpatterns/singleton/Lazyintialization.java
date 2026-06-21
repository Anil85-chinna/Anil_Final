package com.Designpatterns.singleton;

public class Lazyintialization {
	private static Lazyintialization createInstance;

	private Lazyintialization() {
//		Without private constructor:
//			Singleton completely fails.

	}

	public static Lazyintialization callInstance() {
		if (createInstance == null) {
			createInstance = new Lazyintialization();
		}
		return createInstance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("creating object first time = " + Lazyintialization.callInstance().hashCode());
		System.out.println("creating object second time = " + Lazyintialization.callInstance().hashCode());

	}

}
