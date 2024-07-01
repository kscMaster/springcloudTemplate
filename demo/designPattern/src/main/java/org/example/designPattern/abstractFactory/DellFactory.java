package org.example.designPattern.abstractFactory;

public class DellFactory implements Computer {
	@Override
	public Cpu getCpu () {
		return new DellCpu();
	}
	
	@Override
	public Keyboard getKeyboard () {
		return new DellKeyboard();
	}
	
	@Override
	public Mouse getMouse () {
		return new DellMouse();
	}
}