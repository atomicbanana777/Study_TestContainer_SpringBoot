package com.atomicbanana.studyspringdbaccess;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.atomicbanana.studyspringdbaccess.Car.CarJDBCTemplateService;

@SpringBootApplication
public class StudyspringdbaccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyspringdbaccessApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CarJDBCTemplateService cars){
		return args -> {
			System.out.println("====commandLineRunner===");
			cars.getAllCars().forEach(System.out::println);
		};
	}

}
