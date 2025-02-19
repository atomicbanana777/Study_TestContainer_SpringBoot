package com.atomicbanana.studyspringdbaccess.Car;

import java.time.LocalDate;

public record Car(int id, String model, LocalDate dateOfProduction){
}