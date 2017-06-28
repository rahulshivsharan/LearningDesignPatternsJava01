package org.designpatterns.chainofresponsibility.example01;

public interface DispenseChain {
	void setNextChain(DispenseChain nextChain);
	
	void dispense(Currency currency);
}
