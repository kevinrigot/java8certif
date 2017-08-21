package com.example.filenio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DirList {
	public static void main(String[] args) {
		try(Stream<Path> files = Files.list(Paths.get("."))){
			files.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("WALK ===================");
		try(Stream<Path> files = Files.walk(Paths.get(".settings"),3)){
			files.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Files or dir containing 'Main' ===================");
		try(Stream<Path> files = Files.walk(Paths.get("."))){
			files.filter((Path p) -> p.toString().contains("Main")).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Find directories ===================");
		try(Stream<Path> files = Files.find(Paths.get("."), 9, (p,a)->a.isDirectory())){
			files.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
