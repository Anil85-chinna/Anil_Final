package com.designpattersn.AbstractFactorymethod.ConcreteProducts;

import com.designpattersn.AbstractFactorymethod.AbstarctProducts.TranscactionManager;

public class MySQLTranscation implements TranscactionManager {

	@Override
	public void beginTransaction() {
		// TODO Auto-generated method stub
		System.out.println("mysql transaction is started");

	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		System.out.println("mysql transaction complted and commited");

	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub
		System.out.println("mysql transaction is failed and rollbacked");

	}

}
