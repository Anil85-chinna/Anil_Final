package com.designpattersn.Factorymethod;

import com.designpattersn.SimpleFactory.Payment;

public class NetBankingPaymentFactory implements PaymentFactory {

	@Override
	public Payment createPayment( ) {
		// TODO Auto-generated method stub
		System.out.println("netbanking payment option is selected using factory method");
		return new NetBankingPayment();
	}

}
