package com.example.threads2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;

public class NetworkClientMain {

	public static void main(String[] args) {
		String host = "localhost";
		ExecutorService es = Executors.newCachedThreadPool();
		Map<RequestResponse, Future<RequestResponse>> callables = new HashMap<RequestResponse, Future<RequestResponse>>();
		for (int port = 10000; port < 10010; port++) {
			RequestResponse requestResponse = new RequestResponse(host, port);
			Future<RequestResponse> submit = es.submit(new NetworkClientCallable(requestResponse));
			callables.put(requestResponse, submit);
		}
		es.shutdown();
		try {
			es.awaitTermination(5, TimeUnit.SECONDS);
			callables.forEach(handleResponseConsumer());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static BiConsumer<? super RequestResponse, ? super Future<RequestResponse>> handleResponseConsumer() {
		return (req, res)-> {
			try {
				RequestResponse requestResponse = res.get();
				System.out.println(requestResponse.host+":"+requestResponse.port+" "+requestResponse.response);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
	}

}
