package com.designpattersn.SimpleFactory;

/*
But let's understand
what actually happened.
Runtime Flow
Suppose user selects
UPI

Execution

Main
↓
factory.getPayment("UPI")
↓
PaymentFactory
↓
new UPIPayment()
↓
returns Payment
↓
payment.pay()
Notice

Main never executes

new UPIPayment()

Factory does.
 */
public class MainMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentFactory pfact = new PaymentFactory();
		Payment payment = pfact.getPayment("cad");
		payment.pay();

	}

}
