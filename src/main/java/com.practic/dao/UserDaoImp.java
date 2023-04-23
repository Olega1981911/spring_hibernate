package com.practic.dao;

import com.practic.model.Car;
import com.practic.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCars() {
        TypedQuery<Car> queryCar = sessionFactory.getCurrentSession().createQuery("from Car");
        return queryCar.getResultList();
    }

   /* @Override
    public User findOwner(String model, int series) {

        TypedQuery<Car> findCarQuery = sessionFactory.getCurrentSession().createQuery("from Car where :model and :series")
                .setParameter("model", model)
                .setParameter("series", series);
        List<Car> findCarList = findCarQuery.getResultList();
        if(!findCarList.isEmpty()) {
            Car car = findCarList.get(0);
            List<User> userList = listUsers();
            return userList.stream()
                    .filter(users -> users.getCar().equals(car))
                    .findAny()
                    .orElse(null);
        }
        return null;
    }*/
    @Override
    @SuppressWarnings("unchecked")
    public User findOwner(String model, int series) {

        TypedQuery<User> listUser = sessionFactory.getCurrentSession().createQuery("from User JOIN FETCH Car where :model and :series")
                .setParameter("model", model)
                .setParameter("series", series);
       return (User) listUser.getResultList();

    }
}
