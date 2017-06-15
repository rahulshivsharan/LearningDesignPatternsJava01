package org.designpatterns.stratagy.example01;

public class Customer {
	private PaymentStratagy paymentStratagy;
	
	private double totalPaymentAmount;
	
	public Customer(PaymentStratagy paymentStratagy){
		this.paymentStratagy = paymentStratagy;
	}

	public void setPaymentStratagy(PaymentStratagy paymentStratagy) {
		this.paymentStratagy = paymentStratagy;
	}
	
	public void addAmount(double amt){
		this.totalPaymentAmount += amt;
	}
	
	public void resetAmount(){
		this.totalPaymentAmount = 0;
	}
	
	public void payment(){
		paymentStratagy.payAmount(totalPaymentAmount);
	}
}
