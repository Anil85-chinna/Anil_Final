package com.designpattersn.AbstractFactorymethod.ConcreteFactories;

import com.designpattersn.AbstractFactorymethod.AbstarctFactory.DatabaseFactory;
import com.designpattersn.AbstractFactorymethod.AbstarctProducts.Connection;
import com.designpattersn.AbstractFactorymethod.AbstarctProducts.QueryExecutor;
import com.designpattersn.AbstractFactorymethod.AbstarctProducts.TranscactionManager;
import com.designpattersn.AbstractFactorymethod.ConcreteProducts.MySQLTranscation;
import com.designpattersn.AbstractFactorymethod.ConcreteProducts.MySqlConnection;
import com.designpattersn.AbstractFactorymethod.ConcreteProducts.MySqlQueryExecution;

public class MySQLFactory implements DatabaseFactory {

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return new MySqlConnection();
	}

	@Override
	public QueryExecutor runQuery() {
		// TODO Auto-generated method stub
		return new MySqlQueryExecution();
	}

	@Override
	public TranscactionManager completeTranscation() {
		// TODO Auto-generated method stub
		return new MySQLTranscation();
	}

}
