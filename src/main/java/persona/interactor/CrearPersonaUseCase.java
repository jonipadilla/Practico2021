package persona.interactor;

import persona.excepciones.PersonaYaExisteException;
import persona.modelo.Persona;
import persona.repositorio.CrearPersonaRepositorio;

public class CrearPersonaUseCase {

    private CrearPersonaRepositorio crearPersonaRepositorio;

    public CrearPersonaUseCase(CrearPersonaRepositorio crearPersonaRepositorio) {
        this.crearPersonaRepositorio = crearPersonaRepositorio;
    }

    public boolean guardarPersona(Persona nuevaPersona) {
        if (crearPersonaRepositorio.existePersonaPorDocumento(nuevaPersona.getDocumento())) {
            throw new PersonaYaExisteException();
        }
        return crearPersonaRepositorio.persistirPersona(nuevaPersona);
    }
}
