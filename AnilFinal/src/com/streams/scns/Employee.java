package com.streams.scns;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {
	private String name;
	private int age;
	private double salary;
	private String department;
	private String gender;

	public Employee(String name, int age, double salary, String department, String gender) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.department = department;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return name + " " + age + " " + salary + " " + department + " " + gender;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee("Chinna", 28, 75000, "IT", "Male"));
		employees.add(new Employee("Ravi", 30, 80000, "Finance", "Male"));
		employees.add(new Employee("Anita", 26, 65000, "HR", "Female"));
		employees.add(new Employee("Kiran", 32, 90000, "IT", "Male"));
		employees.add(new Employee("Divya", 29, 72000, "Marketing", "Female"));
		employees.add(new Employee("Ravi", 30, 80000, "Finance", "Male"));
		employees.add(new Employee("Arjun", 27, 75000, "IT", "Male"));
		employees.add(new Employee("Sneha", 26, 65000, "HR", "Female"));
		employees.add(new Employee("Vikas", 35, 95000, "Finance", "Male"));
		employees.add(new Employee("Meena", 31, 70000, "IT", "Female"));

		employees.forEach(System.out::println);

		// departmentwise minimum salary
		Map<String, String> deptWiseMinSalary = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
						Collectors.minBy(Comparator.comparing(Employee::getSalary)), emp -> emp.get().getName())));
		System.out.println(deptWiseMinSalary);

	}

}
