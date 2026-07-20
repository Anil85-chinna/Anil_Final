package com.designpattersn.Factorymethod;

public class MainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentFactory pfactory = new UPIPaymentFactory();
		pfactory.createPayment();
		PaymentFactory pfact = new CardPaymentFactory();
		pfact.createPayment();
		PaymentFactory pfacty = new NetBankingPaymentFactory();
		pfacty.createPayment();

	}

}
