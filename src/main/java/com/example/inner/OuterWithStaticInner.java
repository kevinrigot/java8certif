package com.example.inner;

public class OuterWithStaticInner {
	static int i = 10;

	public class Inner {
		//We can not define a static content inside non static inner class
		//static int i =1;
		int j =1;
		static final int k =1;
		//public static void print() {
		public void print() {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		Inner in = new OuterWithStaticInner().new Inner();
		in.print();
	}
}