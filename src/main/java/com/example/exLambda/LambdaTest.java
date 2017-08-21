package com.example.exLambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleSupplier;

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strList = Arrays.asList("tomorrow", "toto", "to", "timbukto", "the", "hello", "heat");
		String searchStr = "to";
		System.out.println("Searching for "+searchStr);
		
		System.out.println("Contains:");
		analyze(strList, searchStr, (String t, String s)->t.contains(s));

		System.out.println("End with:");
		analyze(strList, searchStr, (String t, String s)->t.endsWith(s));
		
		System.out.println("Contain and less than 5:");
		analyze(strList, searchStr, (String t, String s)->t.contains(s) && t.length()<5);

		
		DoubleSupplier sups = () ->Math.random()*10;
		System.out.println(sups.getAsDouble());
		
	}
	
	public static void analyze(List<String> strList, String target, AnalyzerTool tool){
		for (String source : strList) {
			if(tool.analyze(source, target)){
				System.out.println("Match: "+source);
			}
		}
	}

}
