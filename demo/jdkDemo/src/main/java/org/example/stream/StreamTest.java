package org.example.stream;

import org.example.vo.Student;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main (String args[]) {
		List<Student> students = new ArrayList<Student>() {
			{
				add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
				add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
				add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
				add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
				add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
				add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
				add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
				add(new Student(20160002, "伯约", 23, 2, "信息安全", "武汉大学"));
				add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
				add(new Student(20161001, "翼德", 22, 2, "机械与自动化", "华中科技大学"));
			}
		};
		
		List<Student> whuStudents = students.stream()
				.filter(student -> "武汉大学".equals(student.getSchool()))
				.collect(Collectors.toList());
		
//		System.out.println("whuStudents = " + whuStudents.toString());
		
		List<Student> evens = students.stream()
				.filter(num -> num.getGrade() % 2 == 0).sorted(Comparator.comparingInt(Student::getAge))
				.skip(0)
				.limit(2)
				.collect(Collectors.toList());
		
//		System.out.println("evens = " + evens.toString());
		
		List<String> names = students.stream()
				.filter(student -> "计算机科学".equals(student.getMajor()))
				.map(Student::getName).collect(Collectors.toList());
		
//		System.out.println("names = " + names);
		
		int totalAge = students.stream()
				.filter(student -> "计算机科学".equals(student.getMajor()))
				.mapToInt(Student::getAge).sum();
		
//		System.out.println("totalAge = " + totalAge);
		
		
		String[] strs = {"java8", "is", "easy", "to", "use"};
		
		List<String> collect = Arrays.stream(strs)
				.map(str -> str.split(""))  // 映射成为Stream<String[]>
				.flatMap(array -> Arrays.stream(array))  // 扁平化为Stream<String>
//				.distinct()
				.collect(Collectors.toList());
//		System.out.println("distinctStrs = " + (collect));
//
		boolean isAdult = students.stream().allMatch(student -> student.getAge() >= 21);
		System.out.println("isAdult = " + isAdult);
		
		boolean hasWhu = students.stream().anyMatch(student -> "武汉大学".equals(student.getSchool()));
		System.out.println("hasWhu = " + hasWhu);
		
		boolean noneCs = students.stream().noneMatch(student -> "计算机科学".equals(student.getMajor()));
		System.out.println("noneCs = " + noneCs);
		
		Optional<Integer> totalAge2 = students.stream()
				.filter(student -> "计算机科学".equals(student.getMajor()))
				.map(Student::getAge)
				.reduce((a, b) -> Integer.sum(a, b));
		System.out.println("totalAge2 = " + totalAge2.get());

		
	}
	
}