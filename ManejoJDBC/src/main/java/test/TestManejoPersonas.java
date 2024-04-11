package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

        Persona personaActualizada = new Persona(3, "Cristiano", "Ronaldo", "siuwiii@mail.com", "7777777777" );
        personaDao.actualizar(personaActualizada);
        
//        personaDao.borrar(5);


        
         List<Persona> personas = personaDao.seleccionar();
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }

}
