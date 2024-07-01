package org.example.designPattern.instance;

public class MainTest {
	public static void main (String[] args) {
		User user = UserInstance.INSTANCE.getUser();
		System.out.println(user.getName());
	}
}