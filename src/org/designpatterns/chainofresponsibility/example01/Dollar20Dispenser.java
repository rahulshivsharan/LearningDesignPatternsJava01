package org.designpatterns.chainofresponsibility.example01;

public class Dollar20Dispenser implements DispenseChain{

	private DispenseChain chain;
	
	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;		
	}

	@Override
	public void dispense(Currency currency) {
		int num = 0;
		int remainder = 0;
		
		if(currency.getAmount() >= 20 ){
			
			// divide by 20 to get 
			// total number of 20$ bills can be
			// dispensed.
			num = currency.getAmount()/20;			
			System.out.println("Dispensing \""+num+"\" number of $20 currency notes");
			
			// check the remainder of division
			// if remainder is not 0 than that 
			// amount of currency is still has to 
			// be dispensed from ATM, hence pass on that
			// remainder currency to next chain of dispenser
			remainder = currency.getAmount()%20;
			if(remainder != 0){
				this.chain.dispense(new Currency(remainder));
			}
		}else{ // if the currency is less than 20$
			   // pass on to the next chain of dispenser
			   // which will be able to dispense out the 
			   // currency
			this.chain.dispense(currency); 
		}		
	}// end of dispense

}
