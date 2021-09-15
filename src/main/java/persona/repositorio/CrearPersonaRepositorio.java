package persona.repositorio;

import persona.modelo.Persona;

public interface CrearPersonaRepositorio {

    boolean existePersonaPorDocumento(String documento);

    boolean persistirPersona(Persona nuevaPersona);
}
