package com.iqmsoft.concurrency;

import java.util.concurrent.*;

class Sum implements Callable<Integer> {
	int lass;

	Sum(int lass) {
		this.lass = lass;
	}

	@Override
	public Integer call() throws Exception {

		int sum = 0;

		for (int i = 0; i <= lass; i++) {
			sum += i;
		}

		return sum;

	}

}

class Hypot implements Callable<Double> {
	double height;
	double base;

	Hypot(double base, double height) {
		this.height = height;
		this.base = base;
	}

	@Override
	public Double call() throws Exception {

		return Math.sqrt(height * height + base * base);
	}

}

class Fib implements Callable<Integer> {
	
	int res;
	

	Fib(int res) {
		this.res = res;
		
	}

	@Override
	public Integer call() throws Exception {

		return result(this.res);
	}
	
	private int result(int x)
	{
		if( x == 0) return 1;
		if( x == 1) return 1;
		
		return result(x - 1) + result(x - 2);
	}

}


class Fact implements Callable<Long> {
	long n;
	double base;

	Fact(long n) {
		this.n = n;
	}

	@Override
	public Long call() throws Exception {

		return calc(n);
	}
	
	private long calc(long n)
	{
		if (n == 0) return 1;
		else return n * calc(n - 1);
	}

}

public class FutureTest {

	ExecutorService es = Executors.newFixedThreadPool(4);

	public void test() {

		Future<Integer> f1 = es.submit(new Sum(10));

		Future<Double> f2 = es.submit(new Hypot(3, 4));
		
		Future<Long> f3 = es.submit(new Fact(10));
		
		Future<Integer> f4 = es.submit(new Fib(10));

		try {
			System.out.println(f1.get());
			System.out.println(f2.get());
			System.out.println(f3.get());
			System.out.println(f4.get());
		} catch (Exception e) {

		}
	}

}
