package uce.edu.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.UriInfo;
import uce.edu.web.service.IEstududianteService;
import uce.edu.web.service.mapper.EstudianteMapper;
import uce.edu.web.service.to.EstudianteCompletoTo;
import uce.edu.web.service.to.EstudianteTo;

@Path("/estudiantes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstudianteController {

    @Inject
    private IEstududianteService iEstududianteService;

    @GET
    @Path("")
    public Response buscarTodos(@Context UriInfo info) {
        List<EstudianteTo> lista = this.iEstududianteService.buscarTodos().stream().
        map(EstudianteMapper::haciaTo).peek(p -> p.generarUri(info)).collect(Collectors.toList());
        return Response.status(Status.OK).
        entity(lista).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Integer Id, @Context UriInfo info) {
           EstudianteTo pTo = EstudianteMapper.haciaTo(this.iEstududianteService.buscarPorId(Id));
            pTo.generarUri(info);
           return Response.status(Status.OK).entity(pTo).build();
    }

    @DELETE
    @Path("/{id}") 
    public void borrarPorId(@PathParam("id") Integer id) {
        this.iEstududianteService.borrarPorId(id);
    }

    @POST
    @Path("")
    public void guardar(@RequestBody EstudianteTo profesorTo) {
        this.iEstududianteService.guardar(EstudianteMapper.haciaEntidad(profesorTo));
    }

    @GET
    @Path("/{id}/completo")
    public EstudianteCompletoTo obtenerLinkPorId(@PathParam("id") Integer id){
        return EstudianteMapper.haciaCompletoTo(this.iEstududianteService.buscarPorId(id));
    }

}
