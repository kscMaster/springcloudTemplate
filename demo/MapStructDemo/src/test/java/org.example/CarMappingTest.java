package org.example;


import org.example.dto.CarDTO;
import org.example.entity.Car;
import org.example.entity.CarType;
import org.example.mapper.CarMapping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CarMappingTest {
	
	
	private Car car;
	private CarDTO carDTO;
	
	
	@Autowired
	private CarMapping carMapping;
	
	
	@BeforeEach
	public void setUp () throws Exception {
		car = new Car();
		car.setMake("make");
		CarType type = new CarType();
		type.setType("type");
		car.setCarType(type);
		car.setNumberOfSeats(1);
	}
	
	
	@Test
	public void testcarToCarDTO () {
		carDTO = carMapping.carToCarDTO(car);
		System.out.println(carDTO.toString());
	}
	
	
}