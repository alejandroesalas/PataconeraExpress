/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.cecar.pataconeraexpress.Ejb;

import com.edu.cecar.pataconeraexpress.entities.Categoria;
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
       TypedQuery<Producto> productosByPrice = getEntityManager().createNamedQuery("Producto.findByPrecioProducto", Producto.class);
        return productosByPrice.setParameter("precioProducto",price).getResultList();
    }

    public Producto findByName(String nombre) {
        TypedQuery<Producto> productosByPrice = getEntityManager().createNamedQuery("Producto.findByNombreProducto", Producto.class);
        return productosByPrice.setParameter("nombreProducto",nombre).getResultList().get(0);
    }

    public List<Producto> findByCategory(String categoria) {
        // System.out.println(categoria);
          List<Producto> productos = findAll();
         List<Producto> productosByCat = new ArrayList<>();
         
         productos.stream().filter((producto) -> {
             if (producto.getCategoriasIdcategoria()!= null) {
                 return producto.getCategoriasIdcategoria().getNombreCat().equalsIgnoreCase(categoria);        
             }else
                 return false;
         }).forEachOrdered((t) -> { 
             productosByCat.add(t);
         });
         
        return productosByCat;
    }
    public List<Producto> findByCategory(int categoria) {
         //System.out.println(categoria);
          List<Producto> productos = findAll();
         // System.out.println(productos.get(0).getCategoriasIdcategoria());
         List<Producto> productosByCat = new ArrayList<>();
         productos.stream().filter((producto) -> {
             if (producto.getCategoriasIdcategoria()!= null) {
                 return producto.getCategoriasIdcategoria().getIdcategoria()==categoria;        
             }else
                 return false;
         }).forEachOrdered((t) -> { 
             productosByCat.add(t);
         });
//         productos.stream().filter((producto) -> (categoria==producto.getCategoriasIdcategoria().getIdcategoria())).forEachOrdered((producto) -> {
//             productosByCat.add(producto);
//        });
        return productosByCat;
    }
     public List<Producto> findByFeatures(String nombre,int idcategoria,double precio) {
           TypedQuery<Producto> productos = getEntityManager()
                   .createNamedQuery("Producto.findByFeatures", Producto.class);
           productos.setParameter("nombre","%"+nombre+"%");
          // productos.setParameter("desc","%"+des+"%");
           productos.setParameter("precio",precio);
           productos.setParameter("idCat",new Categoria(idcategoria));
        return productos.getResultList();
    }

    public List<Producto> findByFeatures(int idCat, double precio) {
        TypedQuery<Producto> productos = getEntityManager()
                   .createNamedQuery("Producto.findByCatAndPrice", Producto.class);
           //productos.setParameter("nombre","%"+nombre+"%");
          // productos.setParameter("desc","%"+des+"%");
           productos.setParameter("precio",precio);
           productos.setParameter("idCat",new Categoria(idCat));
                   return productos.getResultList();

    }
}
