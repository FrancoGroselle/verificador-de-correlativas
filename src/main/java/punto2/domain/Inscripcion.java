package punto2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inscripcion {
    private static int contador = 0;
    private Integer id;
    private Alumno alumno;
    private List<Materia> materiasaInscribir;

    public Inscripcion(Alumno alumno) {
        this.id = ++contador;
        this.alumno = alumno;
        this.materiasaInscribir = new ArrayList<>();
    }

    public void agregarMateriasaInscribir(Materia ... materias) {
        Collections.addAll(this.materiasaInscribir, materias);
    }

    public boolean aprobada() {
        for(Materia materia : materiasaInscribir) {
            if(!this.alumno.tieneCorrelativasAprobadas(materia)) {
                return false;
            }
        }
        return true;
    }
}