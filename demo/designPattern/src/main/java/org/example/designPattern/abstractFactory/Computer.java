package org.example.designPattern.abstractFactory;


public interface Computer {
	public Cpu getCpu ();
	public Keyboard getKeyboard ();
	public Mouse getMouse ();
}