package org.example.valid;

import org.springframework.stereotype.Component;

@Component
public class MainTest {
	
	private Validators validators;
	public void test() {
		validators.validate("email", "password", "name");
	}
}