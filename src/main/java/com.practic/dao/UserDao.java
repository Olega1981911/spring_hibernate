package com.practic.dao;

import com.practic.model.Car;
import com.practic.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void add(Car car);

    List<User> listUsers();

    List<Car> listCars();

    User findOwner(String model, int series);
}
