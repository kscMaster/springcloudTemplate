package org.example.designPattern.abstractFactory;

public class ComputerTest {
	public static void main (String[] args) {
		DellFactory dellFactory = new DellFactory();
		dellFactory.getCpu().operation();
		dellFactory.getKeyboard().operation();
		dellFactory.getMouse().operation();
	}
}