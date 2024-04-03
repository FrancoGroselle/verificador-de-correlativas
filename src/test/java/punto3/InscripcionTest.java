package punto3;

import punto2.domain.Alumno;
import punto2.domain.Inscripcion;
import punto2.domain.Materia;

public class InscripcionTest {
    private Alumno alumno;
    private Inscripcion inscripcion;

    @Before
    public void setUp() {
        this.alumno = new Alumno("Franco", "Groselle", "1750781");
        this.alumno.agregarMateriasAprobadas(new Materia("Algoritmos y Estructuras de Datos"));
        this.alumno.agregarMateriasAprobadas(new Materia("Paradigmas de Programación"));
        this.alumno.agregarMateriasAprobadas(new Materia("Matematica Discreta"));
        this.alumno.agregarMateriasAprobadas(new Materia("Ingenieria y Sociedad"));
        this.alumno.agregarMateriasAprobadas(new Materia("Analisis Matematica I"));

        this.inscripcion = new Inscripcion(this.alumno);
    }

    @Test
    public void testInscripcionAprobada() {
        Materia disenoDeSistemas = new Materia("Diseño de Sistemas");
        disenoDeSistemas.agregarCorrelativas(
                new Materia("Paradigmas de Programación"),
                new Materia("Algoritmos y Estructuras de Datos")
        );
        this.inscripcion.agregarMateriasaInscribir(disenoDeSistemas);
        assertTrue(this.inscripcion.aprobada());
    }

    @Test
    public void testInscripcionRechazada() {
        Materia disenoDeSistemas = new Materia("Sistemas Operativos");
        disenoDeSistemas.agregarCorrelativas(
                new Materia("Matematica Discreta"),
                new Materia("Arquitectura de Computadores")
        );
        // El alumno no tiene aprobadas todas las materias correlativas
        this.inscripcion.agregarMateriasaInscribir(disenoDeSistemas);
        assertFalse(this.inscripcion.aprobada());
    }

    @Test
    public void testTodasMateriasCorrelativasAprobadas() {
        Materia paradigmasDeProgramacion = new Materia("Paradigmas de Programación");
        paradigmasDeProgramacion.agregarCorrelativas(
                new Materia("Algoritmos y Estructuras de Datos"),
                new Materia("Matematica Discreta"));
        this.alumno.agregarMateriasAprobadas(paradigmasDeProgramacion);
        assertTrue(this.alumno.tieneCorrelativasAprobadas(paradigmasDeProgramacion));
    }

    @Test
    public void testNoTodasMateriasCorrelativasAprobadas() {
        Materia analisisDeSistemas = new Materia("Analisis de Sistemas");
        analisisDeSistemas.agregarCorrelativas(new Materia("Sistema y Organizaciones"));
        assertFalse(this.alumno.tieneCorrelativasAprobadas(analisisDeSistemas));
    }
}

