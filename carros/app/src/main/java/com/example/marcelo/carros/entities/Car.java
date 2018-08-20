package com.example.marcelo.carros.entities;

/**
 * Created by Marcelo on 19/12/2017.
 */

public class Car
{
    public String model;
    public int horsePower;
    public Double price;
    public int id;

    public Car(int id, String model, int horsePower, Double price)
    {
        this.id = id;

        this.model = model;
        this.horsePower = horsePower;
        this.price = price;

    }
}
