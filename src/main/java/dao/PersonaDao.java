package dao;

import entity.Person;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.QueryHints;
import org.hibernate.query.Query;
import service.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonaDao {
    public void savePerson(Person person, Session session) {
        session.save(person);
    }

    public List<Person> getPersonas() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("SELECT s from Person s", Person.class);
            List<Person> personas = query.list();
            return personas;
            //return session.createQuery("SELECT s from Student s", Student.class).list();
        }
    }
    public List<Person> getPersonasConDocumento() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("select p from Person p inner join fetch p.docType doc", Person.class);
            List<Person> personas = query.list();
            return personas;
            //return session.createQuery("SELECT s from Student s", Student.class).list();
        }
    }
    public List<Person> getPersonasConDireccion() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("select p from Person p inner join fetch p.address a", Person.class);
            List<Person> personas = query.list();
            return personas;
            //return session.createQuery("SELECT s from Student s", Student.class).list();
        }
    }
    public List<Person> getPersonasConDocDirec() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("select p from Person p inner join fetch p.docType doc inner join fetch p.address", Person.class);
            List<Person> personas = query.list();
            return personas;
            //return session.createQuery("SELECT s from Student s", Student.class).list();
        }
    }
    public List<Person> getPersonasSinDocumento() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("select p from Person p LEFT JOIN FETCH  p.address where p.docType is null", Person.class);
            List<Person> personas = query.list();
            return personas;
            //return session.createQuery("SELECT s from Student s", Student.class).list();
        }
    }
    public List<Person> getPersonasSinDireccion() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("select p from Person p LEFT JOIN FETCH p.docType where p.address is null", Person.class);
            List<Person> personas = query.list();
            return personas;
            //return session.createQuery("SELECT s from Student s", Student.class).list();
        }
    }
    public List<Person> getPersonasSinDocDirec() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query query = session.createQuery("select p from Person p where p.docType is null and p.address is null", Person.class);
            List<Person> personas = query.list();
            return personas;
            //return session.createQuery("SELECT s from Student s", Student.class).list();
        }
    }
    public List<Person> getPersonasConCarro(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery("SELECT DISTINCT p FROM Person p INNER JOIN fetch p.cars", Person.class);
            List<Person> personas = query.list();
            return personas;
        }
    }
    public List<Person> getPersonasConComputadora(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery("select DISTINCT p from Person p inner join fetch p.computers", Person.class);
            List<Person> personas = query.list();
            return personas;
        }
    }
    public List<Person> getPersonasConCarCompu(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery("select distinct p from Person p inner join fetch p.cars", Person.class);
            List<Person> personas = query.list();
            Query query1 = session.createQuery("select distinct p from Person p inner join fetch p.computers where p in :personas",Person.class);
            query1.setParameter("personas", personas);
            List<Person> personas1 = query1.list();
            return personas1;
        }
    }
    public List<Person> getPersonasConSinTodaInfo(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery("select DISTINCT p from Person p left join fetch p.docType left join fetch p.address left join fetch p.cars", Person.class);
            List<Person> personas = query.list();

            Query query3 = session.createQuery("select distinct p from Person p left join fetch p.computers where p in :personas",Person.class);
            query3.setParameter("personas", personas);
            List<Person> personas3 = query3.list();

            /*
            Query query = session.createQuery("select DISTINCT p from Person p left join fetch p.docType", Person.class);
            List<Person> personas = query.list();

            Query query1 = session.createQuery("select distinct p from Person p left join fetch p.address where p in :personas",Person.class);
            query1.setParameter("personas", personas);

            List<Person> personas1 = query1.list();
            Query query2 = session.createQuery("select distinct p from Person p left join fetch p.cars where p in :personas",Person.class);

            query2.setParameter("personas", personas);
            List<Person> personas2 = query2.list();

            Query query3 = session.createQuery("select distinct p from Person p left join fetch p.computers where p in :personas",Person.class);
            query3.setParameter("personas", personas);
            List<Person> personas3 = query3.list();
            */
            return personas;
        }
    }
    public List<Person> getPersonasLlamadasMaria(String dnombre){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery("select p from Person p where p.firstName = :nombre ", Person.class);
            query.setParameter("nombre", dnombre);
            List<Person> personas = query.list();
            return personas;
        }
    }
    public List<Person> getPersonasLlamadasLucia(String dnombre, String dapellido){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery("select p from Person p where p.firstName = :nombre and p.lastName = :apellido ", Person.class);
            query.setParameter("nombre", dnombre);
            query.setParameter("apellido", dapellido);
            List<Person> personas = query.list();
            return personas;
        }
    }

    public List<Person> getPersonsFiltered(String dnombre, String dapellido){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            String stringQuery = "";
            stringQuery = stringQuery + "select p from Person p ";
            stringQuery = stringQuery + "where (:nombre IS NULL OR p.firstName = :nombre) ";
            stringQuery = stringQuery + "or (:apellido IS NULL OR p.lastName = :apellido)";

            Query query = session.createQuery(stringQuery, Person.class);
            query.setParameter("nombre", dnombre);
            query.setParameter("apellido", dapellido);
            List<Person> personas = query.list();
            return personas;
        }
    }

    //obtener una lista de personas con su tipo de documento y que el doc sea dni

    public List<Person> getPersonaConDni(String documento){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            Query query = session.createQuery("select p from Person p inner join p.docType doc where doc.description in :documento ", Person.class);
            query.setParameter("documento", documento);
            List<Person> personas = query.list();
            return personas;
        }
    }


/*
* --     //devolver personas con sus carros y mostrarlo
select * from person
inner join car on person.id = car.person_fk;

-- devolver personas con sus computadoras y mostrarlo
select * from person
inner join computer on person.id = computer.person_fk;

-- devolver personas con sus computadoras y carros - mostrarlo
select * from person
inner join car on person.id = car.person_fk
inner join computer on person.id = computer.person_fk;

-- devolver personas con tipodoc direccion carro y computadora
select * from person
inner join doc_type on person.doc_type_fk = doc_type.id
inner join direccion on person.address_fk = direccion.id
inner join car on person.id = car.person_fk
inner join computer on person.id = computer.person_fk;
* */

}
