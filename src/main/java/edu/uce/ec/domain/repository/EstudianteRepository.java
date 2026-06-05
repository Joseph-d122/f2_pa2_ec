package edu.uce.ec.domain.repository;

import edu.uce.ec.domain.model.EstudianteEntity;

public interface EstudianteRepository {

    public EstudianteEntity registrarEstudiante(EstudianteEntity estudiante);

    public EstudianteEntity seleccionarPorId(Integer id);

    public void actualizarEstudiante(Integer id, EstudianteEntity estudiante);

    public void eliminarEstudiante(Integer id);
    
}
