/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.cecar.pataconeraexpress.service;

import com.edu.cecar.pataconeraexpress.Ejb.PedidoFacade;
import com.edu.cecar.pataconeraexpress.Ejb.ProductoFacade;
import com.edu.cecar.pataconeraexpress.Utils.UstilJsonProccesing;
import com.edu.cecar.pataconeraexpress.entities.Pedido;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("pedidos")
public class PedidoService {
     @Inject
    private PedidoFacade  pedidoFace;
    @Inject 
    private UstilJsonProccesing procesadorJson;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PedidoService
     */
    public PedidoService() {
    }
    
    @POST
    @Path("create")
    @Consumes("application/json")
    public Response create(Pedido entity) {
        if (entity!=null) {         
              pedidoFace.create(entity);
              return Response.status(Response.Status.OK)
            .entity("Producto creado con exito")
            .build();
        }else{
             return Response.status(Response.Status.NOT_ACCEPTABLE)
            .entity("El producto no es aceptable")
            .build();
        }  
    }
}
