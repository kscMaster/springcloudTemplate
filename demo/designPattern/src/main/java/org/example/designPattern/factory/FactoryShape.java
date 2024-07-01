package org.example.designPattern.factory;

public class FactoryShape {
	//使用 getShape 方法获取形状类型的对象
	public Shape getShape(String shapeType){
		if(shapeType == null){
			return null;
		}
		if(shapeType.equalsIgnoreCase("CIRCLE")){
			return new ShapeCircle();
		} else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new ShapeSquare();
		}
		return null;
	}
}