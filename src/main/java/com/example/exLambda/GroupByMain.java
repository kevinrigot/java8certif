package com.example.exLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.streams.Departement;
import com.example.streams.Employee;
import com.example.streams.Gender;

public class GroupByMain {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Kevin","Rigot",32,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.IT));
		employees.add(new Employee("Marianne","Demarteau",30,Gender.FEMALE,"kk","123","xxx","Brussels","1234", "",Departement.MARKETING));
		employees.add(new Employee("Pierre","Charlier",27,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.IT));
		employees.add(new Employee("Kevin","Baptiste",26,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.IT));
		employees.add(new Employee("John","Doe",32,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.SALES));
		employees.add(new Employee("Kevin","Spacey",45,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.MARKETING));
		
		System.out.println("Employees grouped by departement");
		Map<Departement, List<Employee>> groupByDepartement = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartement));
		System.out.println(groupByDepartement);
		Set<Employee> collect = employees.stream().collect(Collectors.toSet());
		System.out.println("Employees names grouped by departement");
		Map<Departement, List<String>> namesGroupByDepartement = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartement, 
						Collectors.mapping(Employee::getGivenName, Collectors.toList())));
		System.out.println(namesGroupByDepartement);
		
		System.out.println("Average age grouped by departement");
		Map<Departement, Double> avgAgePerDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartement, 
						Collectors.averagingDouble(Employee::getAge)));
		System.out.println(avgAgePerDept);
		
		double collect2 = employees.stream().collect(Collectors.averagingInt(Employee::getAge));
		System.out.println(collect2);
		double d = 1.5d;
		int i = (int)d;
		System.out.println(i);
		
		System.out.println("Employee >=30y old");
		Map<Boolean, List<String>> partitionOver30 = employees.stream()
				.collect(Collectors.partitioningBy(e->e.getAge()>=30, 
						Collectors.mapping(Employee::getGivenName, Collectors.toList())));
		System.out.println(partitionOver30);
		
		List<Number> list = new ArrayList<>();
		list.add(new Integer(10));
		
		Predicate<Integer> p = (t) -> t>5;
		p = t -> t>5;
		p = t -> {return t>5;};
		//p = t -> return t>5; --> Brackets missing
		//p = t -> {return t>5}; --> Semicolon missing
		//p = p -> p>5; --> Can not reuse 'p'
		System.out.println("rangeClosed(1,5)");
		IntStream ints = IntStream.rangeClosed(1,5); //5 included
		ints.forEach(s -> System.out.println(s+", "));
		System.out.println("range(1,5)");
		ints = IntStream.range(1,5); //5 NOT included
		ints.forEach(s -> System.out.println(s+", "));
		

	}

}
