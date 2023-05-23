package service;

import dao.*;
import entity.Car;
import entity.Computer;
import entity.Person;
import exception.PtmException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PersonaService {
    PersonaDao personDao = new PersonaDao();
    AddressDao addressDao = new AddressDao();
    DocTypeDao docTypeDao = new DocTypeDao();
    CarDao carDao = new CarDao();
    ComputerDao computerDao = new ComputerDao();

    public void savePerson(Person persona){
        Session session = null;

        try  {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();

            if(persona.getAddress() != null){
                addressDao.saveAddress(persona.getAddress(),session);
            }
            if(persona.getDocType() != null){
                docTypeDao.saveDocType(persona.getDocType(),session);
            }
            personDao.savePerson(persona,session);

            if(persona.getCars()!=null){
                for(Car car : persona.getCars()){
                    carDao.saveCar(car,session);
                }
            }
            if(persona.getComputers()!=null){
                for(Computer computer : persona.getComputers()){
                    computerDao.saveComputer(computer, session);
                }
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }


    public void savePersons(List<Person> personas){
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.getTransaction().begin();
            int count = 0;
            for(Person persona : personas){
                personDao.savePerson(persona,session);
                count++;
                if(count == 3){
                    throw new PtmException("la cagamos");
                }
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Person> getPersons() {
        return personDao.getPersonas();
    }
    public List<Person> getPersonsWithDocument(){
        return personDao.getPersonasConDocumento();
    }
    public List<Person> getPersonsWithAddress(){
        return personDao.getPersonasConDireccion();
    }
    public List<Person> getPersonsWithDocAdd(){
        return personDao.getPersonasConDocDirec();
    }
    public List<Person> getPersonsWithoutDocument(){
        return personDao.getPersonasSinDocumento();
    }
    public List<Person> getPersonsWithoutAddress(){
        return personDao.getPersonasSinDireccion();
    }
    public List<Person> getPersonsWithoutDocAdd(){
        return personDao.getPersonasSinDocDirec();
    }
    public List<Person> getPersonsWithCar(){return personDao.getPersonasConCarro();}
    public List<Person> getPersonsWithComputer(){return personDao.getPersonasConComputadora();}
    public List<Person> getPersonsWithCarComputer(){return personDao.getPersonasConCarCompu();}
    public List<Person> getPersonsCalledMaria(String dnombre){ return  personDao.getPersonasLlamadasMaria(dnombre); }
    public List<Person> getPersonsCalledLucia(String dnombre, String dapellido){ return  personDao.getPersonasLlamadasLucia(dnombre, dapellido); }
    public List<Person> getPersonsFiltered(String dnombre, String dapellido){ return  personDao.getPersonsFiltered(dnombre, dapellido); }

    public List<Person> getPersonsWithDocDni(String documento){
        return personDao.getPersonaConDni(documento);
    }
    public List<Person> getPersonsWithWithoutInfo(){
        return personDao.getPersonasConSinTodaInfo();
    }

}
