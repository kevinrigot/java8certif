package com.example.threads2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NetworkServerMain {

	public static void main(String[] args) {
		ExecutorService exSrv = Executors.newCachedThreadPool();
		List<Runnable> runners = new ArrayList<>();
		for (int port = 10000; port < 10010; port++) {
			Runnable r;
			try {
				r = new PriceRangeServer(port, 20, 110);
				runners.add(r);
			} catch (IOException ex) {
				System.out.println("Port " + port + " already in use");
			}
		}
		for (Runnable r : runners) {
			exSrv.execute(r);
		}

		try {
			Thread.sleep(500);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Press enter to quit...");
		try {
			int a = System.in.read();
			System.out.println(a);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.out.println("Quiting...");
		exSrv.shutdownNow();

	}
}