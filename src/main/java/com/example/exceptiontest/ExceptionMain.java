package com.example.exceptiontest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionMain {

	public static void main(String[] args) {
		//Must add argument -ea (enable Assertions)
		assert args.length>0 : "Argument must be passed!";
		try(BufferedReader b = new BufferedReader(new FileReader(args[0]));){
			System.out.println("Reading from file: " + args[0]);
			String s = null;
			while((s=b.readLine())!=null){
				System.out.println(s);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No file specified!");
		} catch (IOException e) {
			System.out.println("File not found!");
		}catch(Exception e){
			e = new IllegalArgumentException("test");
		}
	}

}
