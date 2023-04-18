package service;

import model.Car;
import model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    void add(User user);

    void add(Car car);

    List<User> listUsers();

    List<Car> listCars();

    User findOwner(String model, int series);
}
