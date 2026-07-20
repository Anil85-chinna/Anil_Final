package com.designpattersn.SimpleFactory;

/*
 * The interface only says

Every payment must know how to pay.

It never says

How.

This is called

Programming to an Interface

One of the biggest interview topics.
 */
public interface Payment {
	void pay();
}
