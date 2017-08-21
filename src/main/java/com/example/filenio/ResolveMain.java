package com.example.filenio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveMain {

	public static void main(String[] args) {
		Path path1 = Paths.get("c:\\whiz\\java\\NIO\\myfiles");
		Path path2 = Paths.get("myfiles\\myfile.txt");
		Path path = path2.resolve(path1);
		//If we pass an absolute path, then the resolve will just return the absolute path 
		System.out.println(path);
		System.out.println(path1.resolve(path2));

		
		//System.out.println(path1.relativize(path2)); --> throw exception
		
		

	}

}
