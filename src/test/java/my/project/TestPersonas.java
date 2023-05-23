package my.project;

import entity.*;
import org.junit.Ignore;
import org.junit.Test;
import service.PersonaService;

import java.util.ArrayList;
import java.util.List;

public class TestPersonas {

    private PersonaService personaService = new PersonaService();

    @Test
    @Ignore
    public void personCar(){

        Car car = new Car();
        car.setBrand("Hyundai");
        car.setModel("ASX");

        Car car1 = new Car();
        car1.setBrand("BMW");
        car1.setModel("X6 M");

        List<Car> listCar = new ArrayList<>();
        listCar.add(car);
        listCar.add(car1);

        Computer computer = new Computer();
        computer.setBrand("MSI");

        List<Computer> listComputer = new ArrayList<>();
        listComputer.add(computer);

        Person person = new Person();

        person.setFirstName("Rossy");
        person.setLastName("Sagasti");
        person.setDocNumber("07575558");
        person.setCars(listCar);
        person.setComputers(listComputer);
        car.setPerson(person);
        car1.setPerson(person);
        computer.setPerson(person);

        PersonaService personaService = new PersonaService();
        personaService.savePerson(person);


    }

    //devolver personas con sus carros y mostrarlo
    @org.junit.Test
    public void mostrarCarro(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsWithCar();
        for(Person persona : listaPersonas){
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
            List<Car> listcar = persona.getCars();
            for(Car car : listcar){
                System.out.println("\t" + car.getId()+" - "+car.getModel()+" "+car.getBrand()+" / ");
            }
        }

    }

    //devolver personas con sus computadoras y mostrarlo
    @org.junit.Test
    public void mostrarComputadora(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsWithComputer();
        for(Person persona : listaPersonas){
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
            List<Computer> listcomputers = persona.getComputers();
            for(Computer computer : listcomputers){
                System.out.print("\t" + computer.getId()+" "+computer.getBrand()+" ");
            }
        }
    }
    //devolver personas con sus computadoras y carros - mostrarlo
    @org.junit.Test
    public void mostrarCarroComputadora(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsWithCarComputer();
        for(Person persona : listaPersonas){
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
            List<Car> listcars = persona.getCars();
            List<Computer> listcomputers = persona.getComputers();
            for(Car car : listcars){
                System.out.println("\t" + car.getId()+" - "+car.getModel()+" "+car.getBrand()+" / ");
            }
            for(Computer computer : listcomputers){
                System.out.print("\t" + computer.getId()+" "+computer.getBrand()+" ");
            }
        }
    }
    //TODO**devolver personas con  tipodoc direccion carro y computadora


    //devolver personas tenga o no  tipodoc direccion carro y computadora
    @org.junit.Test
    public void mostarPersonasConSinInfo(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsWithWithoutInfo();
        for(Person persona : listaPersonas){
            DocType doc = persona.getDocType();
            Address a = persona.getAddress();
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
            if(doc==null){
                System.out.println(" "+doc);
            }else{
                System.out.println(" "+doc.getId()+" "+doc.getDescription());
            }
            if(a==null){
                System.out.println(" "+a);
            }else{
                System.out.println(" "+a.getId()+" "+ a.getAddress() );
            }
            List<Car> listcar = persona.getCars();
            List<Computer> listcomputers = persona.getComputers();

            for(Car car : listcar){
                System.out.println("\t"+car.getBrand());
            }
            for(Computer computer : listcomputers){
                System.out.print("\t" + computer.getId()+" "+computer.getBrand()+" ");
            }
        }

    }

    @org.junit.Test
    public void mostrarPersonasLlamadasMaria(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsCalledMaria("Maria");
        for(Person persona : listaPersonas){
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
        }

    }

    //obtener una lista de personas q se llamen maria
    @org.junit.Test
    public void mostarPersonasLlamadasLuciaSuarez() {
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsCalledLucia("Lucia", "Suarez");
        for (Person persona : listaPersonas) {
            System.out.println(persona.getId() + " " + persona.getFirstName() + " " + persona.getLastName());
        }

    }

    //obtener una lista de personas con su tipo de documento y que el doc sea dni
    @org.junit.Test
    public void mostarPersonasConDNI(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsWithDocDni("dni");
        for(Person persona : listaPersonas){
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
        }
    }

    @Test
    public void mostarPersonasConFiltros1(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsFiltered("Lucia","Suarez");
        for(Person persona : listaPersonas){
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
        }
    }

    @Test
    public void mostarPersonasConFiltros2(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsFiltered("Lucia", null);
        for(Person persona : listaPersonas){
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
        }
    }

    @Test
    public void mostarPersonasConFiltros3(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsFiltered(null, "Suarez");
        for(Person persona : listaPersonas){
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
        }
    }

    @Test
    public void mostarPersonasConFiltros4(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsFiltered("Maria", null);
        for(Person persona : listaPersonas){
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
        }
    }

    @Test
    public void mostarPersonasConFiltros5(){
        PersonaService personaService = new PersonaService();
        String dnombre = "Maria";
        List<Person> listaPersonas = personaService.getPersonsFiltered(dnombre, "Suarez");
        for(Person persona : listaPersonas){
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
        }
    }
    @Test
    public void mostarPersonasConFiltros6(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsFiltered(null, null);
        for(Person persona : listaPersonas){
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
        }
    }
}