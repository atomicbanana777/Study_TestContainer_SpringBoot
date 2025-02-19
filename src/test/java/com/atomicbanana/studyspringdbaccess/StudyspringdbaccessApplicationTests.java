package com.atomicbanana.studyspringdbaccess;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import com.atomicbanana.studyspringdbaccess.Car.Car;
import com.atomicbanana.studyspringdbaccess.Car.CarJDBCTemplateService;

@SpringBootTest(properties = "spring.sql.init.mode=always")
@Import(TestcontainersConfiguration.class)
class StudyspringdbaccessApplicationTests {

	@Autowired
	CarJDBCTemplateService cars;

	@BeforeEach
	void setUp(){
		System.out.println("====setup===");
		cars.addCar("Audi-001", java.time.LocalDate.now());
		cars.addCar("BMW-001", java.time.LocalDate.now());
		cars.addCar("Mercedes-001", java.time.LocalDate.now());
		List<Car> carList = cars.getAllCars();
		carList.forEach(System.out::println);
	}

	@AfterEach
	void tearDown(){
		System.out.println("====tearDown===");
		List<Car> carList = cars.getAllCars();
		carList.forEach(car->cars.deleteCar(car.id()));
	}
	
	@Test
	void findAllCars(){
		System.out.println("====findAllCars===");
		List<Car> carList = cars.getAllCars();
		carList.forEach(System.out::println);
		assertNotNull(carList);
	}

	@Test
	void deleteSuccess(){
		System.out.println("===deleteSuccess===");
		assertEquals(1, cars.deleteCar(1000000));
		List<Car> carList = cars.getAllCars();
		carList.forEach(System.out::println);
	}
}
