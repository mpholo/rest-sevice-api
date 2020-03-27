package com.learning.api.v1.model;

import java.util.List;

public class CarListDTO {

    List<CarDTO> cars;

    public CarListDTO(List<CarDTO> cars) {
        this.cars = cars;
    }

    public List<CarDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarDTO> cars) {
        this.cars = cars;
    }
}
