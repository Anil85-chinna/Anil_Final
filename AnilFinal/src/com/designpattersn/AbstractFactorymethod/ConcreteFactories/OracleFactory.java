package com.designpattersn.AbstractFactorymethod.ConcreteFactories;

import com.designpattersn.AbstractFactorymethod.AbstarctFactory.DatabaseFactory;
import com.designpattersn.AbstractFactorymethod.AbstarctProducts.Connection;
import com.designpattersn.AbstractFactorymethod.AbstarctProducts.QueryExecutor;
import com.designpattersn.AbstractFactorymethod.AbstarctProducts.TranscactionManager;
import com.designpattersn.AbstractFactorymethod.ConcreteProducts.OracleConnection;
import com.designpattersn.AbstractFactorymethod.ConcreteProducts.OracleQueryExecution;
import com.designpattersn.AbstractFactorymethod.ConcreteProducts.OracleTranscationManager;

public class OracleFactory implements DatabaseFactory {

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return new OracleConnection();
	}

	@Override
	public QueryExecutor runQuery() {
		// TODO Auto-generated method stub
		return new OracleQueryExecution();
	}

	@Override
	public TranscactionManager completeTranscation() {
		// TODO Auto-generated method stub
		return new OracleTranscationManager();
	}

}
