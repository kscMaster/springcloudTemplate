package org.example.designPattern.instance;



public enum UserInstance {
	INSTANCE;

	private User user = new User();
	public User getUser() {
		return this.user;
	}
}