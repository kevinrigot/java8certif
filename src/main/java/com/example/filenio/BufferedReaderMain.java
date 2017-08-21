package com.example.filenio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderMain {

	public static void main(String[] args) {
		try(BufferedReader bReader = new BufferedReader(new FileReader("C:\\tools\\workspace_training\\training_lambdas\\src\\main\\resources\\tempest.txt"))){
			bReader.lines().forEach(System.out::println);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
