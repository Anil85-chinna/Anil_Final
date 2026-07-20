package com.designpattersn.Factorymethod;

import com.designpattersn.SimpleFactory.Payment;

public class UPIPayment implements Payment {

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("the upi payment option is selected");
		
	}

}
