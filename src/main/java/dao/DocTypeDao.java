package dao;

import entity.DocType;
import org.hibernate.Session;
import org.hibernate.query.Query;
import service.HibernateUtil;

import javax.print.Doc;
import java.util.List;

public class DocTypeDao {
    public void saveDocType(DocType docType, Session session) {
        session.save(docType);
    }

    public List<DocType> getDocType() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("SELECT d from DocType d", DocType.class);
            List<DocType> docType = query.list();
            return docType;
            //return session.createQuery("SELECT s from Student s", Student.class).list();
        }
    }
}
