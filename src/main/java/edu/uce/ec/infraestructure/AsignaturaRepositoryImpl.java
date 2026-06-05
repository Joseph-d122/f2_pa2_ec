package edu.uce.ec.infraestructure;

import edu.uce.ec.domain.model.Asignatura;
import edu.uce.ec.domain.repository.AsignaturaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class AsignaturaRepositoryImpl implements AsignaturaRepository {

    @Inject
    EntityManager em;

    @Override
    public void registrar(Asignatura asignatura) {
       this.em.persist(asignatura);
    }


    @Override
    public Asignatura consultarAsignatura(Integer id) {
        return this.em.find(Asignatura.class, id);
    }

    @Override
    public void actualizarAsignatura(Asignatura asignatura) {
        this.em.merge(asignatura);
    }

    @Override
    public void eliminarAsignatura(Integer id) {
        this.em.remove(this.consultarAsignatura(id));
    }

    @Override
    public List<Asignatura> asignaturasPorNivel(Integer nivel) {
        TypedQuery<Asignatura> miQuery = this.em.createNamedQuery("Asignatura.findNivel", Asignatura.class);
        miQuery.setParameter("nivel", nivel);
        return miQuery.getResultList();
    }

    @Override
    public List<Asignatura> buscarAsignaturasPorNombre(String texto) {
        TypedQuery<Asignatura> miQuery = this.em.createNamedQuery("Asignatura.findNombre", Asignatura.class);
        miQuery.setParameter("texto", "%" + texto + "%");
        return miQuery.getResultList();
    }

    @Override
    public Long asignaturasTotal() {
        TypedQuery<Long> miQuery = this.em.createNamedQuery("Asignatura.countAll", Long.class);
        return miQuery.getSingleResult();
    }
}
