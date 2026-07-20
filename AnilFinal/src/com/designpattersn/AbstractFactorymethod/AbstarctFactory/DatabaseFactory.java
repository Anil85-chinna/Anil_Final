package com.designpattersn.AbstractFactorymethod.AbstarctFactory;

import com.designpattersn.AbstractFactorymethod.AbstarctProducts.Connection;
import com.designpattersn.AbstractFactorymethod.AbstarctProducts.QueryExecutor;
import com.designpattersn.AbstractFactorymethod.AbstarctProducts.TranscactionManager;

public interface DatabaseFactory {
	Connection getConnection();

	QueryExecutor runQuery();

	TranscactionManager completeTranscation();

}
