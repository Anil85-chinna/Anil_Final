package com.streams.yellowcoders;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {

	private int id;
	private String name;
	private String gender;
	private String department;
	private double salary;

	public Employee(int id, String name, String gender, String department, double salary) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee{" + "id=" + id + ", name='" + name + '\'' + ", gender='" + gender + '\'' + ", department='"
				+ department + '\'' + ", salary=" + salary + '}';
	}
}

public class AllInOne {

	public static void main(String[] args) {

		List<Employee> employees = Arrays.asList(new Employee(101, "Anil", "Male", "IT", 65000),
				new Employee(102, "Priya", "Female", "HR", 55000), new Employee(103, "Rahul", "Male", "Finance", 70000),
				new Employee(104, "Sneha", "Female", "IT", 72000), new Employee(105, "Kiran", "Male", "Admin", 50000),
				new Employee(106, "Divya", "Female", "HR", 58000), new Employee(107, "Vikram", "Male", "IT", 80000),
				new Employee(108, "Meena", "Female", "Finance", 75000),
				new Employee(109, "Arjun", "Male", "Sales", 62000),
				new Employee(110, "Kavya", "Female", "Sales", 61000));

		employees.forEach(System.out::println);
		// How many male and female employees are there in organization ?
		System.out.println("How many  male and female employees are there in organization ?");
		Map<String, Long> countOfEachGender = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(countOfEachGender);
		System.out.println("now printing the average salary of each gender ");
		Map<String, Double> averageOfEachGender = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(e -> e.getSalary())));
		System.out.println(averageOfEachGender);

		System.out.println("Q16. Find Sum of odd and even numbers in given list ?");
		List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Map<String, Integer> output = input.stream().collect(Collectors.groupingBy(ele -> ele % 2 == 0 ? "Even" : "Odd",
				Collectors.summingInt(num -> num.intValue())));
		System.out.println(output);

		System.out.println(" Find duplicate elements in a integers list ?");
		List<Integer> in = Arrays.asList(1, 2, 3, 5, 41, 2, 3, 5, 4, 1);
		Set<Integer> duplicates = new HashSet<>();
		Set<Integer> out = in.stream().filter(ele -> !duplicates.add(ele)).collect(Collectors.toSet());
		System.out.println(out);
		System.out.println("using hashmap");
		List<Integer> duplicatees = in.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(value -> value.getValue() > 1).map(entry -> entry.getKey()).collect(Collectors.toList());
		System.out.println(duplicatees);

		System.out.println("Remove all occurances of a given character from a string ?");
		char inputChar = 'a';
		String str = "anilamulaanju";
		String finalValue = str.chars().filter(ch -> ch != inputChar).mapToObj(ch -> String.valueOf((char) ch))
				.collect(Collectors.joining());
		System.out.println("string after removeing the given char = " + finalValue);
		String st = "String text = \"Ja@va#8 Str!eam$ 20%26 & Spring_Boot*\";";
		System.out.println(" Find Special characters in a given String ?");
		String res = st.chars().mapToObj(c -> (char) c).filter(ele -> !Character.isLetterOrDigit(ele))
				.map(e -> String.valueOf(e)).collect(Collectors.joining());
		System.out.println(" the result string = " + res);
		System.out.println(" Find out numbers starting with 1 ?");
		List<Integer> numbers = Arrays.asList(123, 456, 101, 789, 120, 132, 204);
		List<Integer> startWithGivenChar = numbers.stream().map(ele -> String.valueOf(ele))
				.filter(e -> e.startsWith("1")).map(strToInt -> Integer.parseInt(strToInt))
				.collect(Collectors.toList());
		System.out.println(" Find out numbers starting with 1 ? = " + startWithGivenChar);
		System.out.println(" Find the employee with the highest salary from a list of employee objects ?");

		Employee maxSalaryEmp = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(maxSalaryEmp);
		System.out.println("Q22. Concatenate a list of strings into a single string, seperated by commas ?");
		List<String> strings = List.of("apple", "banana", "cherry");
		String combinedString = strings.stream().collect(Collectors.joining(""));
		System.out.println(combinedString);
		System.out.println("Q23. Find the first non-repeating character in a string ");
		String givenString = "iindia";
		Character nonRepeatingChar = givenString.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(ele -> ele.getValue() == 1).findFirst().get().getKey();
		System.out.println(nonRepeatingChar);
		System.out.println(" Find frequency of characters of a given string ?");
		String an = "anil";
		Map<Character, Long> frequnecyOfEachChar = an.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(frequnecyOfEachChar);
		System.out.println("Group a list of strings by their length ?");
		List<String> words = Arrays.asList("Java", "API", "Spring", "Code", "Microservice", "SQL", "Kafka", "Boot",
				"AWS", "Docker");

		Map<Integer, List<String>> groupOFStringWithLength = words.stream()
				.collect(Collectors.groupingBy(String::length));
		System.out.println(groupOFStringWithLength);
		System.out.println(
				"Q27. 'Filter' a list of numbers to only include those 'greater than 10' and then find their 'average' ?");
		List<Integer> number = Arrays.asList(5, 10, 15, 20, 25);
		Double averageOFgivenNumbers = number.stream().filter(num -> num > 10).mapToInt(e -> e).average().getAsDouble();
		System.out.println(averageOFgivenNumbers);
		System.out.println("From array second hihest number");
		int[] ar = { 1, 2, 3, 6, 5, 4, 7, 8, 9 };
		int secondHighest = Arrays.stream(ar).boxed().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst()
				.get();
		System.out.println("the second highr = " + secondHighest);

		System.out.println("Convert a list of strings to map where key is the string and the value is the length ?");
		Map<String, Integer> stringWithLength = words.stream().collect(Collectors.toMap(el -> el, String::length));
		System.out.println(stringWithLength);
		System.out.println("now sorting the map by its values");
		Map<String, Integer> mapAfterSort = stringWithLength.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		System.out.println(mapAfterSort);
		System.out.println(" Flatten a list of lists of integers into a single list of integers ?");
		List<List<Integer>> listOfLists = Arrays.asList(

				Arrays.asList(1, 2, 3),

				Arrays.asList(4, 5),

				Arrays.asList(6, 7, 8, 9)

		);
		List<Integer> flateIntegerList = listOfLists.stream().flatMap(ele -> ele.stream()).collect(Collectors.toList());
		System.out.println(flateIntegerList);

		System.out.println("Collect all 'unique' words from a list of 'sentences'");
		List<String> sentences = Arrays.asList(

				"Java 8 introduced streams",

				"Streams are powerful",

				"Use streams to process data"

		);
		Set<String> op = sentences.stream().map(ele -> ele.split("\\s+")).flatMap(el -> Arrays.stream(el))
				.collect(Collectors.toSet());
		System.out.println(op);
		List<String> op1 = sentences.stream().map(ele -> ele.split("\\s+")).flatMap(el -> Arrays.stream(el)).distinct()
				.collect(Collectors.toList());
		System.out.println(op1);
		System.out.println("Convert a list of strings to a list of their respective length using streams ?");
		List<Integer> lengths = op1.stream().map(el -> el.length()).collect(Collectors.toList());
		System.out.println(lengths);
		System.out.println(". Find the 'product' of all elements in a list of 'integers' ");
		List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
		int product = num.stream().reduce(1, (a, b) -> a * b);
		System.out.println(product);
		System.out.println("'Merge' two lists of integers and 'remove duplicates' ?");
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8);
		List<Integer> combined = Stream.concat(list1.stream(), list2.stream()).distinct().toList();
		System.out.println(combined);

		System.out.println("top 3 highest paid salries employees");
		List<Employee> top3SalariedEmps = employees.stream()
				.sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).collect(Collectors.toList());
		System.out.println(top3SalariedEmps);
	}
}
