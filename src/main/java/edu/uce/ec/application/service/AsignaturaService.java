package edu.uce.ec.application.service;

import edu.uce.ec.domain.model.Asignatura;
import edu.uce.ec.domain.repository.AsignaturaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class AsignaturaService {

    @Inject
    AsignaturaRepository repository;

    public void registrar(Asignatura asignatura) {
        repository.registrar(asignatura); 
    }

    public void actualizarAsignatura(Integer id) {
        repository.actualizarAsignatura(this.consultarAsignatura(id));
    }

    public Asignatura consultarAsignatura(Integer id) {
        return repository.consultarAsignatura(id);
    }

    public void eliminarAsignatura(Integer id) {
        repository.eliminarAsignatura(id); 
    }

    public List<Asignatura> asignaturasPorNivel(Integer nivel) {
        return repository.asignaturasPorNivel(nivel); 
    }

    public List<Asignatura> buscarAsignaturasPorNombre(String texto) {
        return repository.buscarAsignaturasPorNombre(texto); 
    }

    public Long asignaturasTotal() {
        return repository.asignaturasTotal();
    }
    
}
