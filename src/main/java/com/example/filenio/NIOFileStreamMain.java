package com.example.filenio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NIOFileStreamMain {

	public static void main(String[] args) {
		try(Stream<String> lines = Files.lines(Paths.get("C:\\tools\\workspace_training\\training_lambdas\\src\\main\\resources\\tempest.txt"))){
			lines.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("=========================================================");
		try(Stream<String> lines = Files.lines(Paths.get("C:\\tools\\workspace_training\\training_lambdas\\src\\main\\resources\\tempest.txt"))){
			System.out.println("Spirit count:");
			long count = lines.filter(s -> s.contains("Spirit")).peek(System.out::println).count();
			System.out.println("count: "+count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
