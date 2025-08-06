package uce.edu.web.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.repository.modelo.Estudiante;

@Transactional
@ApplicationScoped
public class EstudianteRepoImpl implements IEstudianteRepo{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Estudiante> seleccionarTodos() {
      TypedQuery myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e",Estudiante.class);
      return myQuery.getResultList();
    }

    @Override
    public Estudiante seleccionarPorId(Integer Id) {
      return this.entityManager.find(Estudiante.class, Id);
    }

    @Override
    public void eliminarPorId(Integer id) {
      this.entityManager.remove(this.seleccionarPorId(id));
    }

    @Override
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

}
