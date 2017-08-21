package com.example.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("test");
		list.add("kevin");
		list.add("miaou");
		list.forEach(t->System.out.println(t));
		
		ToIntFunction<String> sizeFunction = s -> s.length();
		
		list.stream().filter(t->t.contains("i")).mapToInt(sizeFunction).forEach(System.out::println);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee("Kevin","Rigot",32,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.IT));
		employees.add(new Employee("Marianne","Demarteau",30,Gender.FEMALE,"kk","123","xxx","Brussels","1234", "",Departement.MARKETING));
		employees.add(new Employee("Pierre","Charlier",27,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.IT));
		employees.add(new Employee("Kevin","Baptiste",26,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.IT));
		employees.add(new Employee("John","Doe",32,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.SALES));
		employees.add(new Employee("Kevin","Spacey",45,Gender.MALE,"kk","123","xxx","Brussels","1234", "", Departement.MARKETING));
		
		Predicate<Employee> allPilots = p -> p.getAge() >=23 && p.getAge()<65;
		
		employees.stream().filter(allPilots).forEach(System.out::println);
		
		ToDoubleFunction<Employee> toDouble = t -> Bonus.byRole(t.getAge());
		
		employees.stream().mapToDouble(toDouble).forEach(System.out::println);
		
		employees.stream().sorted(Comparator.comparing(Employee::getGivenName).thenComparing((Employee t, Employee u)->u.getAge()-t.getAge()))
			.peek(t-> System.out.println("PEEK:"+t))
			.filter(t->t.getGender()!=Gender.FEMALE)
			.forEach(System.out::println);
		
		Map<Departement, Long> employeePerDeptCount = employees.stream().collect(Collectors.groupingBy(e-> e.getDepartement(), Collectors.counting()));
		System.out.println("Number of employee per dept");
		employeePerDeptCount.forEach((d, c) -> System.out.println("Dept:"+d+" count:"+c));
		
		Map<Departement, List<Employee>> employeePerDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartement));
		System.out.println("List of employee per dept");
		employeePerDept.forEach((d, e) -> System.out.println("Dept:"+d+" employees:"+e));
		
		System.out.println(employees.stream().map(Employee::getGivenName).distinct().sorted().collect(Collectors.joining(", ")));
		
		
		int reduce = employees.stream().mapToInt(Employee::getAge).reduce(0, (s,e)->s = s+e);
		System.out.println("Sum age with reduce:"+reduce);
		System.out.println("Sum age with sum:"+employees.stream().mapToInt(Employee::getAge).sum());
		
		Stream stream = Stream.of(10, 20, "30");
		System.out.println(stream.allMatch(in -> in instanceof Number));
		
		DoubleUnaryOperator power = (val) -> Math.pow(val, 2);
		System.out.println(power.applyAsDouble(3));
	}

}
