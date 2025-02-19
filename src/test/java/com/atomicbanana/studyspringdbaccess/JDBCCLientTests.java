package com.atomicbanana.studyspringdbaccess;

import static org.junit.Assert.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import com.atomicbanana.studyspringdbaccess.Car.CarJDBCClientService;

@SpringBootTest(properties = "spring.sql.init.mode=always")
@Import(TestcontainersConfiguration.class)
class CarJDBCClientTests {

    Logger logger = Logger.getLogger(StudyspringdbaccessApplicationTests.class.getName());

    @Autowired
    CarJDBCClientService carsService;

    @BeforeEach
    void setUp(){
        logger.info("====JDBC Client setup===");
        carsService.addCar("Audi-001", java.time.LocalDate.now());
        carsService.addCar("BMW-001", java.time.LocalDate.now());
        carsService.addCar("Mercedes-001", java.time.LocalDate.now());
        carsService.getAllCars().forEach(car -> logger.info(car.toString()));
    }

    @AfterEach
    void deleteCar(){
        logger.info("====JDBC Client deleteCarOK===");
        carsService.getAllCars().forEach(car -> carsService.deleteCar(car.id()));
    }

    @Test
    void testFindAllCars(){
        logger.info("====JDBC Client testFindAllCars===");
        assertEquals(3, carsService.getAllCars().size());
    }
}
