package org.example.designPattern.abstractFactory;

public class DellCpu implements Cpu {
	@Override
	public void operation () {
		System.out.println("this is DellCpu");
	}
}