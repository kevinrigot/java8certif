package com.example.exceptiontest;

import java.io.IOException;

public class ResourceTest implements AutoCloseable {

	@Override
	public void close() throws IOException{ //Autocloseable close throws Exception. 
										//Here we can throw Exception, IOException or nothing
		// TODO Auto-generated method stub
		System.out.println("closed");
	}

}
