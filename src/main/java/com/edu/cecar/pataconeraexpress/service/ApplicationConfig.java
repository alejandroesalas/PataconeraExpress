/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.cecar.pataconeraexpress.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author usuario
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();
//    resources.add(JacksonFeature.class);  //from the com.fasterxml.jackson.jaxrs.annotation Package
        //System.out.println(JacksonFeature.class);
//        resources.add(JacksonJaxbJsonProvider.class);
//        resources.add(JacksonJsonProvider.class);
//        resources.add(com.edu.cecar.pataconeraexpress.Utils.CustomJsonProvider.class);
//        resources.add(com.edu.cecar.pataconeraexpress.Utils.JacksonFeature.class);
    addRestResourceClasses(resources);
    return resources;
}
    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {

        resources.add(com.edu.cecar.pataconeraexpress.Utils.CustomJsonProvider.class);
        resources.add(com.edu.cecar.pataconeraexpress.Utils.JacksonFeature.class);
        resources.add(com.edu.cecar.pataconeraexpress.service.CategoriaService.class);
        resources.add(com.edu.cecar.pataconeraexpress.service.PedidoService.class);
        resources.add(com.edu.cecar.pataconeraexpress.service.ProductosService.class);
    }
    
}
