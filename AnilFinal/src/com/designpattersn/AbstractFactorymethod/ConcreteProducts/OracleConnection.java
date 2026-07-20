package com.designpattersn.AbstractFactorymethod.ConcreteProducts;

import com.designpattersn.AbstractFactorymethod.AbstarctProducts.Connection;

public class OracleConnection implements Connection {

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("oracle connection is done");
		
	}

}
