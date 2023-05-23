package dao;

import entity.Computer;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.HibernateUtil;

import java.util.List;

public class ComputerDao {

    public void saveComputer(Computer computer, Session session) {
        session.save(computer);
    }

    public List<Computer> getComputer() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("SELECT com from Computer com", Computer.class);
            List<Computer> computers = query.list();
            return computers;

            //return session.createQuery("SELECT s from Student s", Student.class).list();
        }
    }
}
