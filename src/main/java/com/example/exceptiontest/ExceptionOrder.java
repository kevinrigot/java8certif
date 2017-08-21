package com.example.exceptiontest;

public class ExceptionOrder {

	public static void main(String[] args) throws Exception {
		/**
		 * output: try with resource
		 * Resource method
		 * close resource
		 * catch exception: Exception thrown by method
		 * finally
		 */
		try(Resource r = new ExceptionOrder().new Resource()){
			r.method();
			r.methodThrowException();
		}catch (Exception e) {
			System.out.println("catch Exception: "+e.getMessage());
		}finally{
			System.out.println("finally");
		}
		
		System.out.println("*********************************************");
		/**
		 * output: try with resource
		 * Resource method
		 * closing resource (and rethrow a new exception)...
		 * catch exception: Exception thrown by method
		 * suppressed exception: Exception thrown while closing ResourceExceptionThrower
		 * finally
		 */
		System.out.println("Second test:");
		try(ResourceExceptionThrower r = new ExceptionOrder().new ResourceExceptionThrower()){
			r.method();
			r.methodThrowException();
		}catch (Exception e) {
			System.out.println("catch Exception: "+e.getMessage());
			System.out.println("suppressed exception"+((Exception)e.getSuppressed()[0]).getMessage());

		}finally{
			System.out.println("finally");
		}
	}
	
	public class Resource implements AutoCloseable {
		public Resource(){
			System.out.println("try with resource");
		}
		public void methodThrowException() throws Exception {
			throw new Exception("Exception thrown by method");
		}
		public void method(){
			System.out.println("Resource method");
		}

		@Override
		public void close() throws Exception {
			System.out.println("close resource");
			
		}
		
	}
	
	class ResourceExceptionThrower implements AutoCloseable{
		public ResourceExceptionThrower(){
			System.out.println("try with resource");
		}
		public void methodThrowException() throws Exception {
			throw new Exception("Exception thrown by method");
		}
		public void method(){
			System.out.println("Resource method");
		}
		@Override
		public void close() throws Exception {
			System.out.println("closing Resource (and rethrow exception)...");
			throw new Exception("Exception thrown while closing ResourceExceptionThrower");
		}
	}

}
