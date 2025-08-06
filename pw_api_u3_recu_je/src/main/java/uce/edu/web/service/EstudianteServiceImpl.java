package uce.edu.web.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.repository.IEstudianteRepo;
import uce.edu.web.repository.modelo.Estudiante;

@ApplicationScoped
public class EstudianteServiceImpl implements IEstududianteService {

    @Inject
    private IEstudianteRepo estudianteRepo;

    @Override
    public List<Estudiante> buscarTodos() {
        return this.estudianteRepo.seleccionarTodos();
    }

    @Override
    public Estudiante buscarPorId(Integer Id) {
       return this.estudianteRepo.seleccionarPorId(Id);
    }

    @Override
    public void borrarPorId(Integer id) {
       this.estudianteRepo.eliminarPorId(id);
    }

    @Override
    public void guardar(Estudiante estudiante) {
        this.estudianteRepo.insertar(estudiante);
    }

}
