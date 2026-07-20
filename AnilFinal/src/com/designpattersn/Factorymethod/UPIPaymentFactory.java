package com.designpattersn.Factorymethod;

import com.designpattersn.SimpleFactory.Payment;

public class UPIPaymentFactory implements PaymentFactory {

	@Override
	public Payment createPayment() {
		// TODO Auto-generated method stub
		System.out.println("the UPI payment option is selcted with factory method");
		return new UPIPayment();
	}

}
