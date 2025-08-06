package uce.edu.web.service.mapper;

import uce.edu.web.repository.modelo.Estudiante;
import uce.edu.web.service.to.EstudianteCompletoTo;
import uce.edu.web.service.to.EstudianteTo;

public class EstudianteMapper {

    public static EstudianteTo haciaTo(Estudiante estudiante){
        EstudianteTo pTo = new EstudianteTo();
       pTo.setId(estudiante.getId());
        pTo.setNombre(estudiante.getNombre());
       pTo.setApellido(estudiante.getApellido());
        pTo.setCedula(estudiante.getCedula());
       pTo.setFechaNacimiento(estudiante.getFechaNacimiento());
        return pTo;
    }


      public static Estudiante haciaEntidad(EstudianteTo profesorTo){
        Estudiante p= new Estudiante();
        p.setNombre(profesorTo.getNombre());
        p.setApellido(profesorTo.getApellido());
        p.setCedula(profesorTo.getCedula());
        p.setFechaNacimiento(profesorTo.getFechaNacimiento());
        return p;
    }

      public static EstudianteCompletoTo haciaCompletoTo(Estudiante profesor){
        EstudianteCompletoTo pTo = new EstudianteCompletoTo();
        pTo.setNombre(profesor.getNombre());
        pTo.setApellido(profesor.getApellido());
        pTo.setCedula(profesor.getCedula());
        pTo.setFechaNacimiento(profesor.getFechaNacimiento());
        return pTo;
    }

}
