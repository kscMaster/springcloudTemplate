package org.example.designPattern.factory;

public class Main {
	public static void main (String[] args) {
		FactoryShape factory = new FactoryShape();
		Shape shape1 = factory.getShape("CIRCLE");
		shape1.draw();
		Shape shape2 = factory.getShape("SQUARE");
		shape2.draw();
	}
}