package com.interview.questions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {

	private int id;
	private String name;
	private double salary;
	private String department;

	public Employee(int id, String name, double salary, String department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	// Getters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getDepartment() {
		return department;
	}

	// Setter
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", salary=" + salary + ", department='"
				+ department + '\'' + '}';
	}
}

/*
 * Update existing list --> filter() + forEach() Return new --> list map() +
 * collect() No extra memory --> forEach() Functional/Immutable --> map()
 */
public class StreamExample {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee(101, "Anil", 40000, "IT"),
				new Employee(102, "Rahul", 60000, "HR"), new Employee(103, "Kiran", 35000, "Finance"),
				new Employee(104, "Ajay", 80000, "IT"), new Employee(105, "Ravi", 45000, "Support"));
		System.out.println("--------------------------------------------------------------------");

		// now from above list i need to employee whos lessthan 50k and apply increment
		// of 30%
		List<Employee> incrementedEmps = employees.stream().filter(emp -> emp.getSalary() < 50000)
				.collect(Collectors.toList());
		System.out.println(incrementedEmps);
		List<Employee> output = incrementedEmps.stream().map(emp -> {
			emp.setSalary(emp.getSalary() * 1.5);
			return emp;
		}).collect(Collectors.toList());
		System.out.println("the results is = " + output);

		// nbut from above example i am getting only incremented employee records onlyyy
		System.out.println("using foreach ");
		employees.stream().filter(emp -> emp.getSalary() < 50000).forEach(emp -> emp.setSalary(emp.getSalary() * 1.5));
		System.out.println(employees);

		// but i need only using maps
		List<Employee> withoutChangeOriginalList = employees.stream().map(emp -> {
			if (emp.getSalary() < 50000) {
				emp.setSalary(emp.getSalary() * 1.5);
			}
			return emp;
		}).collect(Collectors.toList());
		System.out.println("with original data = " + withoutChangeOriginalList);

		// programm for departmentwise max salary
		/*
		 * Why collectingAndThen()?
		 * 
		 * Because:
		 * 
		 * Collectors.maxBy(...)
		 * 
		 * returns
		 * 
		 * Optional<Employee>
		 * 
		 * But you want
		 * 
		 * Double
		 * 
		 * or
		 * 
		 * String
		 * 
		 * So you unwrap the Optional and extract the required field.
		 * 
		 * Interview Tip
		 * 
		 * Whenever you see:
		 * 
		 * maxBy() minBy()
		 * 
		 * remember:
		 * 
		 * Step 1: Pass a Comparator
		 * 
		 * Comparator.comparing(Employee::getSalary)
		 * 
		 * Step 2: Result is Optional<Employee>
		 * 
		 * Step 3: Use collectingAndThen() if you want a field like salary or name.
		 * 
		 * C
		 */
		Map<String, Optional<Employee>> departmentWiseMaxSalary = employees.stream().collect(Collectors.groupingBy(
				Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));
		System.out.println("output USING maxBy = " + departmentWiseMaxSalary);
		Map<String, Double> output1 = departmentWiseMaxSalary.entrySet().stream()
				.collect(Collectors.toMap(emp -> emp.getKey(), emp -> emp.getValue().get().getSalary()));
		System.out.println("getting same output using above optional one = " + output1);

		// now using the collectors.collectingAndThan
		Map<String, Double> usingCollectorsAndThan = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
								optionalEmployee -> optionalEmployee.orElseThrow().getSalary())));
		System.out.println("i solved this problem using collectAndThan = " + usingCollectorsAndThan);

		// AABBCCDD --> A2B2C2D2
		String str = "AABBCCDD";
		String sb = str.chars().mapToObj(ch -> String.valueOf((char) ch))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().map(s -> s.getKey() + s.getValue()).collect(Collectors.joining());
		System.out.println("the output is  = " + sb);

		// "aaabbbcc" = a:3,b:3c:2
		// add a+(:)2
		// map<char,log> -->key , value
		String inputString = "aaabbbcc";

		String outputString = inputString.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ch -> ch, Collectors.counting())).entrySet().stream()
				.map(eChar -> eChar.getKey() + ":" + eChar.getValue()).collect(Collectors.joining());
		System.out.println("the output String is = " + outputString);
	}
}