package dao;

import entity.Car;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.HibernateUtil;

import java.util.List;

public class CarDao {
    public void saveCar(Car car, Session session) {
        session.save(car);
    }

    public List<Car> getCar() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("SELECT c from Car c", Car.class);
            List<Car> cars = query.list();
            return cars;

            //return session.createQuery("SELECT s from Student s", Student.class).list();
        }
    }
}
