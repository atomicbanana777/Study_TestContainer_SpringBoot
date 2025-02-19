package com.atomicbanana.studyspringdbaccess.Car;

import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CarJDBCTemplateService {
    private final JdbcTemplate jdbcTemplate;
    
    public CarJDBCTemplateService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> getAllCars(){
        return jdbcTemplate.query("SELECT * FROM CAR", 
        (rs, rowNum) -> new Car(rs.getInt("id"), 
                                rs.getString("model"), 
                                rs.getDate("dateOfProduction").toLocalDate()
                                ));
    }

    public void addCar(String model, LocalDate dateOfProduction){
        jdbcTemplate.update("INSERT INTO CAR(id, model, dateOfProduction) VALUES(nextval('car_id_seq'), ?, ?)", model, dateOfProduction);
    }

    public int deleteCar(int id){
        return jdbcTemplate.update("DELETE FROM CAR WHERE id = ?", id);
    }
}
