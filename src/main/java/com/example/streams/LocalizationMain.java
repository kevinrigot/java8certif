package com.example.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizationMain {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Locale loc = Locale.FRANCE;
	ResourceBundle messages = ResourceBundle.getBundle("MessageBundle", loc);
	LocalDateTime today = LocalDateTime.now();
	DateTimeFormatter df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(loc);
	NumberFormat nf = NumberFormat.getCurrencyInstance(loc);
	double money = 1000000.51d;

	public static void main(String[] args) throws IOException {
		LocalizationMain app = new LocalizationMain();
		app.run();
	}

	public void run() throws IOException {
		String line = "";
		while (!(line.equals("q"))) {
			this.printMenu();
			line = br.readLine();
			switch (line) {
			case "2":
				loc = Locale.ENGLISH;
				break;
			case "1":
				loc = Locale.FRANCE;

				break;
			case "q":
				System.exit(0);
			}
			messages = ResourceBundle.getBundle("MessageBundle", loc);
			df = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(loc);
			nf = NumberFormat.getCurrencyInstance(loc);
		}

	}

	private void printMenu() {
		System.out.println(messages.getString("money")+": " + nf.format(money));
		System.out.println(messages.getString("date")+": " + today.format(df));
		System.out.println("1."+messages.getString("menu1"));
		System.out.println("2."+messages.getString("menu2"));
		System.out.println(messages.getString("menuq"));
		System.out.println(messages.getString("command"));

	}

}
