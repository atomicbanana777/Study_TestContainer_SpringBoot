package com.atomicbanana.studyspringdbaccess.Car;

import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

@Service
public class CarJDBCClientService {
    private final JdbcClient jdbcClient;

    public CarJDBCClientService(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public void addCar(String model, LocalDate dateOfProduction){
        String sql = "INSERT INTO CAR(id, model, dateOfProduction) VALUES(nextval('car_id_seq'), ?, ?)";
        jdbcClient.sql(sql)
            .param(model)
            .param(dateOfProduction)
            .update();
    }

    public int deleteCar(int id){
        String sql = "DELETE FROM CAR WHERE id = ?";
        int reval = jdbcClient.sql(sql)
            .param(id)
            .update();

        return reval;
    }

    public List<Car> getAllCars(){
        String sql = "SELECT * FROM CAR";
        
        List<Car> cars = jdbcClient.sql(sql)
            .query(Car.class)
            .list();
        
        return cars;
    }
}
