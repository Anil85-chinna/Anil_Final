package com.Designpatterns.singleton;

import java.lang.reflect.Constructor;

public class ReflectionToBreak {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BillPughSingleton obje1 = BillPughSingleton.methodcallForObjectCreation();

		Constructor<BillPughSingleton> cons = BillPughSingleton.class.getDeclaredConstructor();
		cons.setAccessible(true);
		BillPughSingleton obj2 = cons.newInstance();
		System.out.println("the first object hashcode = " + obje1.hashCode() + "---" + "the second object hashcode = "
				+ obj2.hashCode());

	}

}
