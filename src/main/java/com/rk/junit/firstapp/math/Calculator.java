package com.rk.junit.firstapp.math;

public class Calculator {
	public int addTwo(int a, int b) {
		return a + b;
	}

	public int subTwo(int a, int b) {
		return a - b;
	}

	public int multiplyTwo(int a, int b) {
		return a * b;
	}

	public int divideTwo(int a, int b) {
		return a / b;
	}

	public int doAction() {
		int a=10;
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
				a+=10;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return a;
	}
}
