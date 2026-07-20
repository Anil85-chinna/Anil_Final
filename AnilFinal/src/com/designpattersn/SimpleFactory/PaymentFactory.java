package com.designpattersn.SimpleFactory;

/*
 * This is where Every object is created.
Notice
Only this class contains  --> new

Exactly what Factory Pattern wants.
 */
public class PaymentFactory {

	public Payment getPayment(String paymentType) {
		if (paymentType.equalsIgnoreCase("UPI")) {
			return new UPIPayment();
		} else if (paymentType.equalsIgnoreCase("NetBanking")) {
			return new NetBankingPayment();
		} else if (paymentType.equalsIgnoreCase("CARD")) {
			return new CardPayment();
		}
		throw new IllegalArgumentException("Invalid Payment Type");
	}

}
