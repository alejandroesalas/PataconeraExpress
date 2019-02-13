/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.cecar.pataconeraexpress.service;

import com.edu.cecar.pataconeraexpress.Ejb.CategoriaFacade;
import com.edu.cecar.pataconeraexpress.Utils.UstilJsonProccesing;
import com.edu.cecar.pataconeraexpress.entities.Categoria;
import java.util.List;
import javax.ejb.EJB;

import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("categorias")
public class CategoriaService {

//    @Context
//    private UriInfo context;
@EJB
private CategoriaFacade categoriaFacade;
 @EJB 
    private UstilJsonProccesing procesadorJson;
    /**
     * Creates a new instance of CategoriaService
     */
    public CategoriaService() {
    }

    /**
     * Retrieves representation of an instance of com.edu.cecar.pataconeraexpress.service.CategoriaService
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response findAll() {
//        List<Categoria> categorias = categoriaFacade.findAll();
//        System.out.println(procesadorJson.toJson(categorias));
//        return Response
//            .status(Response.Status.OK)
//            .entity(procesadorJson.toJson(categorias))
//            .build();
//    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findAll() {
        List<Categoria> categorias = categoriaFacade.findAll();
        //System.out.println(procesadorJson.toJson(categorias));
        return procesadorJson.toJson(categorias);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("add")
    public Response create(Categoria entity) {
        if (entity!=null) {
              categoriaFacade.create(entity);
              return Response.status(Response.Status.OK)
            .entity("Objeto creado con exito")
            .build();
        }else{
             return Response.status(Response.Status.NOT_ACCEPTABLE)
            .entity("El objeto no es aceptable")
            .build();
        }
    }
}
