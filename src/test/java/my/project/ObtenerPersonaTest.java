package my.project;

import entity.Address;
import entity.DocType;
import entity.Person;
import org.junit.Test;
import service.PersonaService;

import java.util.List;

public class ObtenerPersonaTest {
    @Test
    public void obtenerPersona(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersons();
        for(Person persona : listaPersonas){
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName() );
        }
    }

    @Test
    public void obtenerPersonaConDocumento(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsWithDocument();
        for(Person persona : listaPersonas){
            DocType doc = persona.getDocType();
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName()+" "+doc.getId()+" "+doc.getDescription() );

        }
    }
    @Test
    public void obtenerPersonaConDireccion(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsWithAddress();
        for(Person persona : listaPersonas){
            Address a = persona.getAddress();
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName()+" "+a.getId()+" "+a.getAddress()+" "+a.getFloorNumb()+
                    " "+a.getDepartment()+" "+a.getDistrict()+" "+a.getProvince());

        }
    }
    //TODO corregir!
    @Test
    public void obtenerPersonaConDocDirecc(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsWithDocAdd();
        for(Person persona : listaPersonas){
            DocType doc = persona.getDocType();
            Address a = persona.getAddress();
            System.out.println(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName()+" "+doc.getId()+" "+doc.getDescription()+" "+a.getId()+
                    " "+a.getAddress()+" "+a.getFloorNumb()+" "+a.getDepartment()+" "+a.getDistrict()+" "+a.getProvince());
        }
    }
    @Test
    public void obtenerPersonaSinDocumento(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsWithoutDocument();
        for(Person persona : listaPersonas){
            System.out.print(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
            if(persona.getAddress() == null){
                System.out.println(" "+persona.getAddress());
            }else{
                System.out.println(" "+persona.getAddress().getId() );
            }
        }
    }

    @Test
    public void obtenerPersonaSinDireccion(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsWithoutAddress();
        for(Person persona : listaPersonas){
            System.out.print(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName() );
            if(persona.getDocType()==null){
                System.out.println(" "+persona.getDocType());
            }else{
                System.out.println(" "+persona.getDocType().getId() );
            }
        }
    }
    @Test
    public void obtenerPersonaSinDocDireccion(){
        PersonaService personaService = new PersonaService();
        List<Person> listaPersonas = personaService.getPersonsWithoutDocAdd();
        for(Person persona : listaPersonas){
            System.out.print(persona.getId()+ " "+persona.getFirstName()+" "+persona.getLastName());
        }
    }
}
