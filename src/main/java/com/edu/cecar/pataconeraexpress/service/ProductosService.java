/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.cecar.pataconeraexpress.service;

import com.edu.cecar.pataconeraexpress.Ejb.ProductoFacade;
import com.edu.cecar.pataconeraexpress.Utils.UstilJsonProccesing;
import com.edu.cecar.pataconeraexpress.entities.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("productos")
 @Consumes("application/json")
@Produces("application/json")
public class ProductosService {
    @EJB
    private ProductoFacade  productoFacade;
    @EJB 
    private UstilJsonProccesing procesadorJson;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProductosResource
     */
    public ProductosService() {
    }
    
    @POST
    @Path("create")
    @Consumes("application/json")
    public Response create(Producto entity) {
        if (entity!=null) {
              productoFacade.create(entity);
              return Response.status(Response.Status.OK)
            .entity("Objeto creado con exito")
            .build();
        }else{
             return Response.status(Response.Status.NOT_ACCEPTABLE)
            .entity("El objeto no es aceptable")
            .build();
        }
       
    }
     @GET
     @Produces("application/json")
     @Path("{id}")
    public String find(@PathParam("id") Integer id) {
         Producto p = productoFacade.find(id);
         
//         Response respuesta; 
         if (p!=null) {
            // System.out.println(p);
//              respuesta = Response
//            .status(Response.Status.OK)
//            .entity(procesadorJson.toJson(p))
//            .build();
                return procesadorJson.toJson(p);
         }else{
//             respuesta = Response
//            .status(Response.Status.NOT_FOUND)
//            .entity("")
//            .build();
                return "";
         }
//    return respuesta;
    }
    
    @GET
    public String findAll() {
        List<Producto> productos = productoFacade.findAll();
        return procesadorJson.toJson(productos);
//            .status(Response.Status.OK)
//            .entity(procesadorJson.toJson(procesadorJson.toJson(productos)))
//            .build();
    }
       @GET
    @Path("precio/{price}")
    public String findByPrice(@PathParam("price")Double price){
       List<Producto> productosByPrice = productoFacade.findByPrice(price);
        return procesadorJson.toJson(productosByPrice);
//            .status(Response.Status.OK)
//            .entity(procesadorJson.toJson(procesadorJson.toJson(productosByPrice)))
//            .build();
    }
    @GET
    @Path("nombre/{nombre}")
    public String findByName(@PathParam("nombre")String nombre){
        List<Producto> productosByName = productoFacade.findByName(nombre);
        return procesadorJson.toJson(productosByName);
//            .status(Response.Status.OK)
//            .entity(procesadorJson.toJson(procesadorJson.toJson(productosByName)))
//            .build();
    }
     @GET
    @Path("categoria/{cat}")
    public String findByCategory(@PathParam("cat")String categoria){
         System.out.println(categoria);
        List<Producto> productos = productoFacade.findByCategory(categoria);
       
       return  procesadorJson.toJson(productos);
//            .status(Response.Status.OK)
//            .entity(procesadorJson.toJson(procesadorJson.toJson(productos)))
//            .build();
    }
     
    @PUT
    @Path("edit/{id}")
    public void edit(@PathParam("id") Integer id, Producto entity) {
        productoFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        productoFacade.remove(productoFacade.find(id));
    }
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(productoFacade.count());
    }
   
}
