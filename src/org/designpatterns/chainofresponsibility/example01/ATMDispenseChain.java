package org.designpatterns.chainofresponsibility.example01;

import java.util.Scanner;

public class ATMDispenseChain {

	private DispenseChain chain50;
	
	public ATMDispenseChain(){
		this.chain50 = new Dollar50Dispenser();
		DispenseChain chain20 = new Dollar20Dispenser();
		DispenseChain chain10 = new Dollar10Dispenser();
		
		this.chain50.setNextChain(chain20);
		chain20.setNextChain(chain10);
		chain10.setNextChain(new Dollar10Dispenser());
	}
	
	public DispenseChain getDispenser(){
		return this.chain50;
	}
	
	public static void main(String[] args) {
		ATMDispenseChain atm = new ATMDispenseChain();
		int amount = 0;
		System.out.println("Enter amount to be dispensed by ATM");
		
		Scanner in = new Scanner(System.in);
		amount = in.nextInt();
		
		atm.getDispenser().dispense(new Currency(amount));
		

	}

}
