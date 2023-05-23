package dao;

import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.HibernateUtil;

import java.util.List;

public class AddressDao {
    public void saveAddress(Address address, Session session) {
        session.save(address);
    }

    public List<Address> getAddress() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("SELECT a from Address a", Address.class);
            List<Address> address = query.list();
            return address;

            //return session.createQuery("SELECT s from Student s", Student.class).list();
        }
    }
}
