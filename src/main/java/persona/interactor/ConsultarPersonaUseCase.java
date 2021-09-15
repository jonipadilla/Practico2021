package persona.interactor;

import persona.modelo.Persona;
import persona.repositorio.ConsultarPersonaRepositorio;

import java.util.List;

public class ConsultarPersonaUseCase {

private ConsultarPersonaRepositorio consultarPersonaRepositorio;

public ConsultarPersonaUseCase(ConsultarPersonaRepositorio consultapersona){
    this.consultarPersonaRepositorio = consultapersona;

}

    public List<Persona> consultarPersona() {
        return consultarPersonaRepositorio.ListaDePersona();
    }
}
