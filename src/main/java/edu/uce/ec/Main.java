package edu.uce.ec;

import io.quarkus.runtime.annotations.QuarkusMain;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import edu.uce.ec.application.service.AsignaturaService;
import edu.uce.ec.domain.repository.EstudianteRepository;
import edu.uce.ec.domain.model.Asignatura;
import edu.uce.ec.domain.model.EstudianteEntity;
import jakarta.inject.Inject;
import java.time.LocalDate;
import java.util.List;

@QuarkusMain
public class Main {

    public static void main(String[] args) {
        Quarkus.run(Application.class, args);
    }

    public static class Application implements QuarkusApplication {

        @Inject
        AsignaturaService asignaturaService;

        @Inject
        EstudianteRepository estudianteRepository;

        @Override
        public int run(String... args) throws Exception {
            Asignatura asignatura1 = new Asignatura();
            asignatura1.setNombre("Programacion Avanzada II");
            asignatura1.setNivel(2);
            asignatura1.setCreditos(4);

            Asignatura asignatura2 = new Asignatura();
            asignatura2.setNombre("Matematicas Discretas");
            asignatura2.setNivel(2);
            asignatura2.setCreditos(3);

            Asignatura asignatura3 = new Asignatura();
            asignatura3.setNombre("Bases de Datos");
            asignatura3.setNivel(3);
            asignatura3.setCreditos(4);

            Asignatura asignatura4 = new Asignatura();
            asignatura4.setNombre("Sistemas Operativos");
            asignatura4.setNivel(4);
            asignatura4.setCreditos(4); 

            asignatura1 = saveOrFindAsignatura(asignatura1);
            asignatura2 = saveOrFindAsignatura(asignatura2);
            asignatura3 = saveOrFindAsignatura(asignatura3);
            asignatura4 = saveOrFindAsignatura(asignatura4);
            Integer primeraId = asignatura1.getId();
            this.asignaturaService.consultarAsignatura(primeraId);
            this.asignaturaService.actualizarAsignatura(primeraId); 
            this.asignaturaService.eliminarAsignatura(primeraId);
            this.asignaturaService.asignaturasPorNivel(2);
            this.asignaturaService.buscarAsignaturasPorNombre("Avanzada");
            this.asignaturaService.asignaturasTotal();


            EstudianteEntity est = new EstudianteEntity();
            est.setNombre("Juan Jose");
            EstudianteEntity saved = this.estudianteRepository.registrarEstudiante(est);

            EstudianteEntity update = new EstudianteEntity();
            update.setNombre("Juan J. Flores");
            this.estudianteRepository.actualizarEstudiante(saved.getId(), update);
            this.estudianteRepository.eliminarEstudiante(saved.getId());

            return 0;
        }

        private Asignatura saveOrFindAsignatura(Asignatura asignatura) {
            this.asignaturaService.registrar(asignatura);
            return asignatura; 
        }
    }
}