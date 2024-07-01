package org.example.mapper;

import org.example.dto.CarDTO;
import org.example.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


@Mapper(componentModel = "spring",imports = {LocalDateTime.class, Date.class, ZoneId.class})//交给spring管理
public interface CarMapping {
	
	/**
	 * 用来调用实例 实际开发中可使用注入Spring  不写
	 */
	CarMapping CAR_MAPPING = Mappers.getMapper(CarMapping.class);
	
	
	/**
	 *  源类型 目标类型 成员变量相同类型 相同变量名 不用写{@link org.mapstruct.Mapping}来映射
	 *
	 * @param car the car
	 * @return the car dto
	 */
	@Mapping(target = "type", source = "carType.type") // 对象的引用
	@Mapping(target = "seatCount", source = "numberOfSeats") // 字段不一样的时候，用来映射
//	@Mapping(target = "student.name", source = "teacher.name") // 字段不一样的时候，用来映射
	CarDTO carToCarDTO(Car car);
}