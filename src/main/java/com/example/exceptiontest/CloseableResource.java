package com.example.exceptiontest;

import java.io.Closeable;
import java.nio.channels.ClosedChannelException;

public class CloseableResource implements Closeable {

	@Override
	public void close() throws ClosedChannelException{//Closeable close throws IOException
		//We can throw IOException or subclasses, or nothing
		// TODO Auto-generated method stub

	}

}
