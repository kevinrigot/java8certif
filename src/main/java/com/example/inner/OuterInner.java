package com.example.inner;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OuterInner {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		new OuterX.Inner();

	}

}

class OuterX {
	private int nonStaticVariable = 0;
	private static int staticVariable = 1;
	
	static class Inner {
		private int innerNonStaticVariable = 0;
		private static int innerStaticVariable = 1;
		
		public void print(){
			System.out.println(staticVariable);
//			System.out.println(nonStaticVariable);
		}
	}
}