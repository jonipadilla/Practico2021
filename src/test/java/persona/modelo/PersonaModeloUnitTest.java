package persona.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import persona.excepciones.PersonaIncompletaException;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class PersonaModeloUnitTest {

    @Test
    public void InstanciarPersona_AtributosCorrectos_InstanciaCorrecta() {
        //Arrange & Act
        Persona unaPersona = Persona.instancia(1, "Quintero", "Juanfer", LocalDate.of(2018, 12, 9), "31313131", 1.5, 90.0);
        //Assert
        Assertions.assertNotNull(unaPersona);
    }

    @Test
    public void InstanciarPersona_FaltaApellido_PersonaIncompletaException() {
        Exception excepcionVacio = Assertions.assertThrows(PersonaIncompletaException.class, () -> Persona.instancia(1, "", "Juanfer", LocalDate.of(2018, 12, 9), "31313131", 1.5, 90.0));
        Exception excepcionNulo = Assertions.assertThrows(PersonaIncompletaException.class, () -> Persona.instancia(1, null, "Juanfer", LocalDate.of(2018, 12, 9), "31313131", 1.5, 90.0));
        Assertions.assertEquals("Apellido es obligatorio", excepcionNulo.getMessage());
        Assertions.assertEquals("Apellido es obligatorio", excepcionVacio.getMessage());
    }

    @Test
    public void InstanciarPersona_FaltaNombre_PersonaIncompletaException() {
        Exception excepcionVacio = Assertions.assertThrows(PersonaIncompletaException.class, () -> Persona.instancia(1, "Quintero", "", LocalDate.of(2018, 12, 9), "31313131", 1.5, 90.0));
        Exception excepcionNulo = Assertions.assertThrows(PersonaIncompletaException.class, () -> Persona.instancia(1, "Quintero", null, LocalDate.of(2018, 12, 9), "31313131", 1.5, 90.0));
        Assertions.assertEquals("Nombre es obligatorio", excepcionNulo.getMessage());
        Assertions.assertEquals("Nombre es obligatorio", excepcionVacio.getMessage());
    }

    @Test
    public void InstanciarPersona_FaltaFechaNacimiento_PersonaIncompletaException() {
        Exception excepcionNulo = Assertions.assertThrows(PersonaIncompletaException.class, () -> Persona.instancia(1, "Quintero", "Juanfer", null, "31313131", 1.5, 90.0));
        Assertions.assertEquals("FechaNacimiento es obligatorio", excepcionNulo.getMessage());
    }


}
