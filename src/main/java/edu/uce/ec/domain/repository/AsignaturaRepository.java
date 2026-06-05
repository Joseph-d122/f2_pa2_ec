package edu.uce.ec.domain.repository;

import edu.uce.ec.domain.model.Asignatura;
import java.util.List;

public interface AsignaturaRepository {

    public void registrar(Asignatura asignatura);

    public Asignatura consultarAsignatura(Integer id);

    public void actualizarAsignatura(Asignatura asignatura);

    public void eliminarAsignatura(Integer id);

    public List<Asignatura> asignaturasPorNivel(Integer nivel);

    public List<Asignatura> buscarAsignaturasPorNombre(String texto);

    public Long asignaturasTotal();

}
