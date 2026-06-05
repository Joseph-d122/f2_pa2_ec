package edu.uce.ec.infraestructure;

import edu.uce.ec.auditable.Auditable;
import edu.uce.ec.domain.model.EstudianteEntity;
import edu.uce.ec.domain.repository.EstudianteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class EstudianteRepositoryImpl implements EstudianteRepository {

    @Inject
    private EntityManager em;

    @Override
    public EstudianteEntity registrarEstudiante(EstudianteEntity estudiante) {
        this.em.persist(estudiante);
        return estudiante;
    }

    @Override
    public EstudianteEntity seleccionarPorId(Integer id) {
        return this.em.find(EstudianteEntity.class, id);
    }

    @Override
    public void actualizarEstudiante(Integer id, EstudianteEntity estudiante) {
        EstudianteEntity existing = this.seleccionarPorId(id);
        if (existing != null) {
            existing.setNombre(estudiante.getNombre());
            this.em.merge(existing);
        }
    }

    @Override
    public void eliminarEstudiante(Integer id) {
        this.em.remove(this.seleccionarPorId(id));
    }

    
}
