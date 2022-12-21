package com.github.matthewdawsey.pnc;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumberCalculation {
	public static void main(String[] args) {
		ArrayList<Integer> primeNumbers = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		System.out.print("limit? ");
		int limit = input.nextInt();
		input.close();
		long lastTime = System.nanoTime();
		for (int i = 2; i < limit; i ++)
			if (isPrime(i))
				primeNumbers.add(i);
		
		long elapsed = System.nanoTime() - lastTime;
		System.out.println("there are " + primeNumbers.size() + " prime numbers between 2 and " + limit);
		System.out.println("took " + (elapsed / 1000000000.0D) + " seconds");
		
		try {
			writeOutput(primeNumbers);
		} catch (IOException e) {
			System.out.println("did not write output file :(");
		}
	}
	
	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		
		for (int i = 2; i <= n / 2; i ++) {
			if (n % i == 0)
				return false;
		}
		
		return true;
	}
	
	public static void writeOutput(ArrayList<Integer> primeNumbers) throws IOException {
		File f = new File(System.currentTimeMillis() + ".txt");
		PrintWriter writer = new PrintWriter(f);
		for (Integer i : primeNumbers) {
			writer.println(i);
		}
		
		writer.close();
	}
}
