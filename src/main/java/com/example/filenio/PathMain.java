package com.example.filenio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathMain {

	public static void main(String[] args) {
		Path path1 =Paths.get("C:\\test\\java\\nio");
		Path path2 =Paths.get("D:\\test2");
		System.out.println(path1);
		System.out.println(path2);
		System.out.println(path1.subpath(0, 3));
		System.out.println(path1.subpath(1, 3));
		//System.out.println(path1.subpath(-1, 3)); --> exception
		Path path = Paths.get(path2.getRoot().toString(), path1.subpath(0, 3).toString());
		System.out.println(path.toString());
		
		System.out.println(Paths.get("..\\test.txt"));
	
		System.out.println();
		path1 = Paths.get("c:\\whiz\\java\\NIO\\myfiles");
		path2 = Paths.get("c:\\whiz\\java\\NIO\\myfiles\\data");
		System.out.println("Relativize with:");
		System.out.println(path1);
		System.out.println(path2);
		System.out.println(path1.relativize(path2));
		System.out.println(path2.relativize(path1));
		
		System.out.println();
		path = Paths.get("users\\whiz\\output");
		System.out.println("With: "+path);
		System.out.println("getNameCount= "+path.getNameCount()); //3
		System.out.println("getName(2)= "+path.getName(2)); //output
		System.out.println("getFileName= "+path.getFileName()); //output
		System.out.println("getRoot= "+path.getRoot()); //null
		
		
	}

}
