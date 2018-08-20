package com.example.marcelo.carros.data;

import com.example.marcelo.carros.entities.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcelo on 19/12/2017.
 */

public class CarMock {

    private List<Car> mListCar;
    private Car car;

    public CarMock() {
        this.mListCar = new ArrayList<>();

        this.mListCar.add(new Car(1, "Ferrary", 1000, 1200.00));
        this.mListCar.add(new Car(1, "Ferrary XX", 1000, 1200.00));
        this.mListCar.add(new Car(1, "Ferrary XY", 1000, 1200.00));
        this.mListCar.add(new Car(1, "Ferrary ZZ", 1000, 1200.00));
        this.mListCar.add(new Car(1, "Ferrary ZS", 1000, 1200.00));


    }

    public List<Car> getList() {
        return this.mListCar;
    }

    public Car get(int id) {
        return this.mListCar.get(id);
    }


}
