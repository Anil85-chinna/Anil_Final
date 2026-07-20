package com.designpattersn.AbstractFactorymethod.ConcreteProducts;

import com.designpattersn.AbstractFactorymethod.AbstarctProducts.QueryExecutor;

public class OracleQueryExecution implements QueryExecutor {

	@Override
	public void runQuery(String sql) {
		// TODO Auto-generated method stub
		System.out.println("Oracle query is completed = "+sql);
		
	}

}
