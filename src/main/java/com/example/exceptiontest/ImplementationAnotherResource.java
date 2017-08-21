package com.example.exceptiontest;

public class ImplementationAnotherResource implements AnotherResource {

	@Override
	public void close() throws RuntimeException{
		//We can not throw any checked exception
		//But Unchecked exception well

	}

}
