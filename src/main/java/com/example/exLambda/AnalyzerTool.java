package com.example.exLambda;

@FunctionalInterface
public interface AnalyzerTool {

	public boolean analyze(String source, String target);
}
