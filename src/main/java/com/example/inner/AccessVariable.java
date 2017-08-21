package com.example.inner;
public class AccessVariable {
	int x = 10;

	public static void method(int c, int i) {
		class Test {
			public void in() {
				//System.out.println(x); --> instance var
				System.out.println(i);
				//System.out.println(c); --> must be final or effectively final
				
			}
		}
		c += 2;
		new Test().in();
	}

	public static void main(String p[]) {
		AccessVariable.method(3, 4);
	}
}