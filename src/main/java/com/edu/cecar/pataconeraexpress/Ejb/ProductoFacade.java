/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.cecar.pataconeraexpress.Ejb;

import com.edu.cecar.pataconeraexpress.entities.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author usuario
 */
@Stateless
public class ProductoFacade extends AbstractFacade<Producto> {

    @PersistenceContext(unitName = "PataconeraExpressPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
    public List<Producto> findByPrice(Double price){
       TypedQuery<Producto> productosByPrice = getEntityManager().createNamedQuery("Produto.findByPrecioProducto", Producto.class);
        return productosByPrice.setParameter("precioProducto",price).getResultList();
    }

    public List<Producto> findByName(String nombre) {
        TypedQuery<Producto> productosByPrice = getEntityManager().createNamedQuery("Produto.findByNombreProducto", Producto.class);
        return productosByPrice.setParameter("nombreProducto",nombre).getResultList();
    }

    public List<Producto> findByCategory(String categoria) {
          List<Producto> productos = findAll();
         List<Producto> productosByCat = new ArrayList<>();
         productos.stream().filter((producto) -> (producto.getCategoriasIdcategoria().getNombreCat().equals(categoria))).forEachOrdered((producto) -> {
             productosByCat.add(producto);
        });
        return productosByCat;
    }
    
}
