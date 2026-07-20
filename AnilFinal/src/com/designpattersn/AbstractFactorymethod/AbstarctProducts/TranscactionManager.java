package com.designpattersn.AbstractFactorymethod.AbstarctProducts;

public interface TranscactionManager {
	void beginTransaction();

	void commit();

	void rollback();


}
