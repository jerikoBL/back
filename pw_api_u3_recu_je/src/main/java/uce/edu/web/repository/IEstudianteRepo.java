package uce.edu.web.repository;

import java.util.List;

import uce.edu.web.repository.modelo.Estudiante;

public interface IEstudianteRepo {

    public List<Estudiante> seleccionarTodos();
    
    public Estudiante seleccionarPorId(Integer Id);

    public void eliminarPorId(Integer id);

    public void insertar(Estudiante estudiante);


}
