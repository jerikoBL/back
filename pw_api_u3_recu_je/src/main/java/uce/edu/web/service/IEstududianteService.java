package uce.edu.web.service;

import java.util.List;

import uce.edu.web.repository.modelo.Estudiante;

public interface IEstududianteService {

    public List<Estudiante> buscarTodos();
    
    public Estudiante buscarPorId(Integer Id);

    public void borrarPorId(Integer id);

    public void guardar(Estudiante estudiante);

}
