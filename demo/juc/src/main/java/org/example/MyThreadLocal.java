package org.example;

// 演示threadLocal给定默认值防止出现null
public class MyThreadLocal extends ThreadLocal{

	@Override
	protected Object initialValue() {
		return "This is the initial value";
	}

	public static void main(String[] args) {
		MyThreadLocal myThreadLocal = new MyThreadLocal();
		System.out.println(myThreadLocal.get());
		myThreadLocal.set("This is the new value");
		System.out.println(myThreadLocal.get());
		myThreadLocal.remove();
		System.out.println(myThreadLocal.get());
	}
}