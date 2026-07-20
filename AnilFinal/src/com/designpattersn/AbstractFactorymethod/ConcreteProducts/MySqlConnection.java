package com.designpattersn.AbstractFactorymethod.ConcreteProducts;

import com.designpattersn.AbstractFactorymethod.AbstarctProducts.Connection;

public class MySqlConnection implements Connection {

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		System.out.println("MySQL database is connected");

	}

}
