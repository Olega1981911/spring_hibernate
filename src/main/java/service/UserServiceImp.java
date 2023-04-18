package service;

import dao.UserDao;
import model.Car;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    @Lazy
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Transactional
    @Override
    public void add(Car car) {
        userDao.add(car);
    }

    @Transactional
    @Override
    public List<Car> listCars() {
        return userDao.listCars();
    }

    @Override
    @Transactional
    public User findOwner(String model, int series) {
        return userDao.findOwner(model, series);
    }
}
