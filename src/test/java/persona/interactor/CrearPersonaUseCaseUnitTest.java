package persona.interactor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import persona.excepciones.PersonaYaExisteException;
import persona.modelo.Persona;
import persona.repositorio.CrearPersonaRepositorio;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CrearPersonaUseCaseUnitTest {

    @Mock
    CrearPersonaRepositorio crearPersonaRepositorio;

    @Test
    public void guardarPersona_personaNoExiste_GuardaCorrectamente() {
        //Arrange
        Persona nuevaPersona = Persona.instancia(1,
                "Martinez",
                "Pity",
                LocalDate.of(2018, 12, 9),
                "123",
                1.9,
                90.0);
        when(crearPersonaRepositorio.existePersonaPorDocumento("123")).thenReturn(false);
        when(crearPersonaRepositorio.persistirPersona(nuevaPersona)).thenReturn(true);

        CrearPersonaUseCase crearPersonaUseCase = new CrearPersonaUseCase(crearPersonaRepositorio);
        //Act
        boolean resultado = crearPersonaUseCase.guardarPersona(nuevaPersona);

        //Assert
        Assertions.assertTrue(resultado);
    }

    @Test
    public void guardarPersona_personaYaExiste_PersonaYaExisteException() {
        //Arrange
        Persona nuevaPersona = Persona.instancia(1,
                "Martinez",
                "Pity",
                LocalDate.of(2018, 12, 9),
                "123",
                1.9,
                90.0);
        when(crearPersonaRepositorio.existePersonaPorDocumento("123")).thenReturn(true);
        verify(crearPersonaRepositorio, never()).persistirPersona(nuevaPersona);

        CrearPersonaUseCase crearPersonaUseCase = new CrearPersonaUseCase(crearPersonaRepositorio);

        //Assert
        Assertions.assertThrows(PersonaYaExisteException.class, () -> crearPersonaUseCase.guardarPersona(nuevaPersona));
    }

    @Test
    public void guardarPersona_personaNoExisteYErrorEnBase_DevuelveFalso() {
        //Arrange
        Persona nuevaPersona = Persona.instancia(1,
                "Martinez",
                "Pity",
                LocalDate.of(2018, 12, 9),
                "123",
                1.9,
                90.0);
        when(crearPersonaRepositorio.existePersonaPorDocumento("123")).thenReturn(false);
        when(crearPersonaRepositorio.persistirPersona(nuevaPersona)).thenReturn(false);

        CrearPersonaUseCase crearPersonaUseCase = new CrearPersonaUseCase(crearPersonaRepositorio);
        boolean resultado = crearPersonaUseCase.guardarPersona(nuevaPersona);

        //Assert
        Assertions.assertFalse(resultado);
    }

}
