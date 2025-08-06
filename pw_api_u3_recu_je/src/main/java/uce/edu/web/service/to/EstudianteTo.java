package uce.edu.web.service.to;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.controller.EstudianteController;

public class EstudianteTo {

    private Integer id;

    private String nombre;

    private String apellido;

    private String cedula;

    private LocalDateTime fechaNacimiento;

    private Map <String , String> _links = new HashMap<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Map<String, String> get_links() {
        return _links;
    }

    public void set_links(Map<String, String> _links) {
        this._links = _links;
    }

    
    public void generarUri(UriInfo info){
        URI generarLink = info.getBaseUriBuilder().path(EstudianteController.class)
        .path(EstudianteController.class, "obtenerLinkPorId").build(id);
        _links.put("mas informacion", generarLink.toString());
    }

}
