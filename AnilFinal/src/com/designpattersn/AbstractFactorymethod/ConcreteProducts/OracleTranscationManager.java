package com.designpattersn.AbstractFactorymethod.ConcreteProducts;

import com.designpattersn.AbstractFactorymethod.AbstarctProducts.TranscactionManager;

public class OracleTranscationManager implements TranscactionManager {

	@Override
	public void beginTransaction() {
		// TODO Auto-generated method stub
		System.out.println("oracle transcation is started");

	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		System.out.println("the oracle transaction is complted ");

	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub
		System.out.println("the oracle transaction is failed and rollbacked");

	}

}
