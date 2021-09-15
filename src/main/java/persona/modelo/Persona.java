package persona.modelo;

import persona.excepciones.PersonaIncompletaException;

import java.time.LocalDate;

public class Persona {

    private Integer id;
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String documento;
    private Double altura;
    private Double peso;

    private Persona(Integer id, String apellido, String nombre, LocalDate fechaNacimiento, String documento, Double altura, Double peso) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.documento = documento;
        this.altura = altura;
        this.peso = peso;
    }

    public static Persona instancia(Integer id, String apellido, String nombre, LocalDate fechaNacimiento, String documento, Double altura, Double peso) {
        if (apellido == null || apellido.isEmpty()){
            throw new PersonaIncompletaException("Apellido es obligatorio");
        }
        if (nombre == null || nombre.isEmpty()){
            throw new PersonaIncompletaException("Nombre es obligatorio");
        }
        if (fechaNacimiento==null){
            throw new PersonaIncompletaException("FechaNacimiento es obligatorio");
        }
        return new Persona(id, apellido, nombre, fechaNacimiento, documento, altura, peso);
    }

    public String getDocumento() {
        return documento;
    }
}
