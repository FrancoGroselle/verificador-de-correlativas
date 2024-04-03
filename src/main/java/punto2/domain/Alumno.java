package punto2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Alumno {
    private String nombre;
    private String apellido;
    private String legajo;
    private List<Materia> aprobadas;

    public Alumno(String nombre, String apellido, String legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.aprobadas = new ArrayList<>();
    }

    public void agregarMateriasAprobadas(Materia ... materias) {
        Collections.addAll(this.aprobadas, materias);
    }

    public boolean tieneCorrelativasAprobadas(Materia materia) {
        return this.aprobadas.containsAll(materia.getCorrelativas());
    }
}