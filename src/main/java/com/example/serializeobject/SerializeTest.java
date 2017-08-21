package com.example.serializeobject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.example.streams.Departement;
import com.example.streams.Employee;
import com.example.streams.Gender;

public class SerializeTest {
	private static String file = "C:\\tools\\workspace_training\\training_lambdas\\src\\main\\resources\\file.txt";

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Kevin","Rigot",32,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.IT));
		employees.add(new Employee("Marianne","Demarteau",30,Gender.FEMALE,"kk","123","xxx","Brussels","1234", "",Departement.MARKETING));
		employees.add(new Employee("Pierre","Charlier",27,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.IT));
		employees.add(new Employee("Kevin","Baptiste",26,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.IT));
		employees.add(new Employee("John","Doe",32,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.SALES));
		employees.add(new Employee("Kevin","Spacey",45,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.MARKETING));
		
		try(FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream out = new ObjectOutputStream(fos);){
			out.writeObject(employees);
		}catch(IOException e ){
			System.out.println("Error writing employees");
		}
		List<Employee> employeesIn = new ArrayList<Employee>();
		try(FileInputStream fis = new FileInputStream(file);
				ObjectInputStream in = new ObjectInputStream(fis);){
			employeesIn = (List<Employee>)in.readObject();
		}catch(ClassNotFoundException | IOException e ){
			System.out.println("Error writing employees");
		} 
		employeesIn.forEach(System.out::println);
		
		
	}
}
