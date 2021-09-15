package persona.interactor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import persona.modelo.Persona;
import persona.repositorio.ConsultarPersonaRepositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarPersonaUseCaseUnitTest {
    @Mock
    private ConsultarPersonaRepositorio consultardepersona;
    @Test
    public void ConsultarPersona_HayPersona_DevulveListaPersona(){
        when(consultardepersona.ListaDePersona()).thenReturn(Lista_Persona());
        ConsultarPersonaUseCase consultarPersonaUseCase = new ConsultarPersonaUseCase(consultardepersona);
        List<Persona> ListaPersona = consultarPersonaUseCase.consultarPersona();

        Assertions.assertNotNull(ListaPersona);
        Assertions.assertEquals(2,ListaPersona.size());
    }

    private List<Persona> Lista_Persona(){
        List<Persona> listadopersona = new ArrayList<>();
        listadopersona.add(Persona.instancia(1,"padilla","jonatan", LocalDate.of(2021,9,15),"33376040",160d,80d));

        listadopersona.add(Persona.instancia(2,"paes","juan", LocalDate.of(2021,9,15),"35376040",160d,80d));

        return listadopersona;
    }
}
