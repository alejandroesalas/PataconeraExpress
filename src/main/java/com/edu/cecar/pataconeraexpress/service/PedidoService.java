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
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author usuario
 */
@Path("pedidos")
public class PedidoService {
     @EJB
    private PedidoFacade  pedidoFace;
    @EJB 
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
            entity.setFechaPedido(new Date());
            entity.getDetallePedidoList().forEach((t) -> {
                t.setPedidosIdpedido(entity);
            });
              pedidoFace.create(entity);
              return Response.status(Response.Status.OK)
            .entity("Pedido registrado con exito")
            .build();
        }else{
             return Response.status(Response.Status.NOT_ACCEPTABLE)
            .entity("El pedido no es aceptable")
            .build();
        }  
    }
       @GET
    public String findAll() {
           List<Pedido> productos = pedidoFace.findAll();
           System.out.println(productos.get(0).getFechaPedido());
        return procesadorJson.toJson(productos);
//            .status(Response.Status.OK)
//            .entity(procesadorJson.toJson(procesadorJson.toJson(productos)))
//            .build();
    }
}
