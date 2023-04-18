package dao;

import model.Car;
import model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void add(Car car);

    List<User> listUsers();

    List<Car> listCars();

    User findOwner(String model, int series);
}
