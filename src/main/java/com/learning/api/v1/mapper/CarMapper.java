package com.learning.api.v1.mapper;

import com.learning.api.v1.model.CarDTO;
import com.learning.domain.Car;
import com.learning.domain.CarType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {


    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDTO carToCarDTO(Car car);
    CarType typeToCarType(String type);
    String carTypeTotype(CarType carType);
//    @Mapping(source = "seatCount",target = "numberOfSeats")
//    Car carDTOToCar(CarDTO carDTO);
}
