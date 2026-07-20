package com.designpattersn.Factorymethod;

import com.designpattersn.SimpleFactory.Payment;

public class CardPaymentFactory implements PaymentFactory {

	@Override
	public Payment createPayment() {
		// TODO Auto-generated method stub
		System.out.println("card payment option usingfactory method");
		return new CardPayment();
	}

}
