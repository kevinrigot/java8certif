package com.example.inner;
public class Outer {
	public static void main(String[] args) {
		Inner in = new Outer().new Inner();
		in.y = 10;
		in.print();
	}

	class Inner {
		private int y = 0;

		protected void print() {
			System.out.println(y);
		}
	}
}