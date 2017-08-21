package com.example.threads2;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class NetworkClientCallable implements Callable<RequestResponse> {
	private RequestResponse requestResponse;

	public NetworkClientCallable(RequestResponse requestResponse) {
		this.requestResponse = requestResponse;
	}

	@Override
	public RequestResponse call() throws Exception {
		try (Socket sock = new Socket(requestResponse.host, requestResponse.port);
				Scanner scanner = new Scanner(sock.getInputStream());) {
			requestResponse.response = scanner.next();
			return requestResponse;
		} catch (IOException e) {
			throw e;
		}
	}
	
	

}
