package my.project;


import dao.PersonaDao;
import entity.Address;
import entity.DocType;
import entity.Person;
import org.junit.Test;
import service.PersonaService;

import java.util.ArrayList;
import java.util.List;

public class GuardarPersona {
    @Test
    public void guardarPersona(){
        Person person = new Person();
        person.setFirstName("Lidia");
        person.setLastName("Lara");
        person.setDocNumber("42589884");
        PersonaService personaService = new PersonaService();
        personaService.savePerson(person);

    }

    @Test
    public void guardarPersona1(){
        PersonaDao personaService = new PersonaDao();
        Person person = new Person();
        person.setFirstName("Lidia");
        person.setLastName("Lara");
        person.setDocNumber("42589884");
        System.out.println("ff");
    }
    @Test
    public void creandoPersonas(){
        Person person = new Person();
        person.setFirstName("Lidia");
        person.setLastName("Lara");
        person.setDocNumber("42589884");

        Person person1 = new Person();
        person1.setFirstName("Elias");
        person1.setLastName("Carranza");
        person1.setDocNumber("46846985");

        Person person2 = new Person();
        person2.setFirstName("Jimena");
        person2.setLastName("Mendoza");
        person2.setDocNumber("46234985");

        Person person3 = new Person();
        person3.setFirstName("Armando");
        person3.setLastName("Sandoval");
        person3.setDocNumber("75546985");

        Person person4 = new Person();
        person4.setFirstName("Maria");
        person4.setLastName("Saavedra");
        person4.setDocNumber("46842311");

        PersonaService personaService = new PersonaService();
        personaService.savePerson(person);
        personaService.savePerson(person1);
        personaService.savePerson(person2);
        personaService.savePerson(person3);
        personaService.savePerson(person4);

        List<Person> lista = personaService.getPersons();
        for(Person resultado : lista){
            System.out.println(resultado.getId()+ " " +resultado.getDocNumber()+ " "+resultado.getFirstName()+ " "+ resultado.getLastName()+ " "+ resultado.getAddress()+ " "
            + " "+resultado.getDocType());
        }

    }

    @Test
    public void creandoPersonas1(){
        Person person = new Person();
        person.setFirstName("Lidia");
        person.setLastName("Lara");
        person.setDocNumber("42589884");

        Person person1 = new Person();
        person1.setFirstName("Elias");
        person1.setLastName("Carranza");
        person1.setDocNumber("46846985");

        Person person2 = new Person();
        person2.setFirstName("Jimena");
        person2.setLastName("Mendoza");
        person2.setDocNumber("46234985");

        Person person3 = new Person();
        person3.setFirstName("Armando");
        person3.setLastName("Sandoval");
        person3.setDocNumber("75546985");

        Person person4 = new Person();
        person4.setFirstName("Maria");
        person4.setLastName("Saavedra");
        person4.setDocNumber("46842311");

        List<Person> personas = new ArrayList<>();
        personas.add(person);
        personas.add(person1);
        personas.add(person2);
        personas.add(person3);
        personas.add(person4);

        PersonaService personaService = new PersonaService();
        personaService.savePersons(personas);

        List<Person> lista = personaService.getPersons();
        for(Person resultado : lista){
            System.out.println(resultado.getId()+ " " +resultado.getDocNumber()+ " "+resultado.getFirstName()+ " "+ resultado.getLastName()+ " "+ resultado.getAddress()+ " "
                    + " "+resultado.getDocType());
        }

    }
    @Test
    public void creandoPersonas2(){
        Person person = new Person();
        Address address = new Address();

        person.setFirstName("Lucia");
        person.setLastName("Suarez");
        person.setDocNumber("08565888");
        person.setAddress(address);
        address.setAddress("Av. el sol");
        address.setDepartment("Lima");
        address.setDistrict("Rimac");
        address.setFloorNumb(2);
        address.setProvince("Lima");

        PersonaService personaService = new PersonaService();
        personaService.savePerson(person);

            System.out.println(person.getId()+ " " +person.getDocNumber()+ " "+person.getFirstName()+ " "+ person.getLastName()+ " "+ person.getAddress().getId()+ " "
                    + " "+person.getDocType());

    }
    @Test
    public void creandoPersonas3(){
        Person person = new Person();
        Address address = new Address();

        person.setFirstName("Lucia");
        person.setLastName("Suarez");
        person.setDocNumber("08565888");
        //person.setAddress(address);
        address.setAddress("Av. el sol");
        address.setDepartment("Lima");
        address.setDistrict("Rimac");
        address.setFloorNumb(2);
        address.setProvince("Lima");

        PersonaService personaService = new PersonaService();
        personaService.savePerson(person);

        System.out.println(person.getId()+ " " +person.getDocNumber()+ " "+person.getFirstName()+ " "+ person.getLastName()+ " "
                + " "+person.getDocType());

    }
    @Test
    public void creandoPersonas4(){
        Person person = new Person();
        Address address = new Address();
        DocType docType = new DocType();

        person.setFirstName("Lucia");
        person.setLastName("Suarez");
        person.setDocNumber("08565888");
        person.setAddress(address);
        address.setAddress("Av. el sol");
        address.setDepartment("Lima");
        address.setDistrict("Rimac");
        address.setFloorNumb(2);
        address.setProvince("Lima");
        person.setDocType(docType);
        docType.setDescription("dni");



        PersonaService personaService = new PersonaService();
        personaService.savePerson(person);
        System.out.println(person.getId()+ " " +person.getDocNumber()+ " "+person.getFirstName()+ " "+ person.getLastName()+ " "
                + " "+person.getDocType());

    }
    @Test
    public void creandoPersonas5() {
        Person person = new Person();
        Address address = new Address();
        DocType docType = new DocType();

        person.setFirstName("Lucia");
        person.setLastName("Suarez");
        person.setDocNumber("08565888");
        person.setAddress(address);
        address.setAddress("Av. el sol");
        address.setDepartment("Lima");
        address.setDistrict("Rimac");
        address.setFloorNumb(2);
        address.setProvince("Lima");
        person.setDocType(docType);
        docType.setDescription("dni");


        Person person1 = new Person();
        Address address1 = new Address();
        DocType docType1= new DocType();

        person1.setFirstName("Maria");
        person1.setLastName("Martinez");
        person1.setDocNumber("08561231");
        person1.setAddress(address1);
        address1.setAddress("Av. la perla");
        address1.setDepartment("Lima");
        address1.setDistrict("Callao");
        address1.setFloorNumb(1);
        address1.setProvince("Callao");
        person1.setDocType(docType1);
        docType1.setDescription("pasaporte");

        Person person2 = new Person();
        Address address2 = new Address();
        DocType docType2= new DocType();

        person2.setFirstName("Juan");
        person2.setLastName("Valdez");
        person2.setDocNumber("74585454");
        //person2.setAddress(address2);
        address2.setAddress("Av. arenales 34");
        address2.setDepartment("Lima");
        address2.setDistrict("Lince");
        address2.setFloorNumb(4);
        address2.setProvince("Lima");
        person2.setDocType(docType2);
        docType2.setDescription("CE");

        Person person3 = new Person();
        Address address3 = new Address();
        DocType docType3= new DocType();

        person3.setFirstName("Daniela");
        person3.setLastName("Ruffo");
        person3.setDocNumber("84759683");
        person3.setAddress(address3);
        address3.setAddress("Av. los incas 123");
        address3.setDepartment("Lima");
        address3.setDistrict("Surco");
        address3.setFloorNumb(10);
        address3.setProvince("Lima");
        //person3.setDocType(docType3);
        docType3.setDescription("dni");

        Person person4 = new Person();
        Address address4 = new Address();
        DocType docType4= new DocType();

        person4.setFirstName("Miranda");
        person4.setLastName("Montaner");
        person4.setDocNumber("01012245");
        //person4.setAddress(address4);
        address4.setAddress("Av. Chimpu ocllo");
        address4.setDepartment("Lima");
        address4.setDistrict("Carabayllo");
        address4.setFloorNumb(4);
        address4.setProvince("Lima");
        //person3.setDocType(docType3);
        docType4.setDescription("dni");


        PersonaService personaService = new PersonaService();
        personaService.savePerson(person);
        personaService.savePerson(person1);
        personaService.savePerson(person2);
        personaService.savePerson(person3);
        personaService.savePerson(person4);


        System.out.println(person.getId()+ " " +person.getDocNumber()+ " "+person.getFirstName()+ " "+ person.getLastName()+ " "
                + " "+person.getDocType());

    }

}
