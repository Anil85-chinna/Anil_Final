package com.designpattersn.AbstractFactorymethod.ConcreteFactories;

import com.designpattersn.AbstractFactorymethod.AbstarctFactory.DatabaseFactory;
import com.designpattersn.AbstractFactorymethod.AbstarctProducts.Connection;
import com.designpattersn.AbstractFactorymethod.AbstarctProducts.QueryExecutor;
import com.designpattersn.AbstractFactorymethod.AbstarctProducts.TranscactionManager;

public class MainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Change only this line to switch databases
		DatabaseFactory dbfy = new MySQLFactory();

		Connection conn = dbfy.getConnection();
		QueryExecutor qet = dbfy.runQuery();
		TranscactionManager tsm = dbfy.completeTranscation();
		conn.connect();
		tsm.beginTransaction();
		qet.runQuery("get deatils for all employees");
		tsm.commit();

	}

}
