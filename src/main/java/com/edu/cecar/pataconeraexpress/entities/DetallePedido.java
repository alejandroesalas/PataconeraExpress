/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.cecar.pataconeraexpress.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "detalle_pedido")
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d"),
    @NamedQuery(name = "DetallePedido.findByIddetallePedido", query = "SELECT d FROM DetallePedido d WHERE d.iddetallePedido = :iddetallePedido"),
    @NamedQuery(name = "DetallePedido.findByCantidad", query = "SELECT d FROM DetallePedido d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetallePedido.findByMonto", query = "SELECT d FROM DetallePedido d WHERE d.monto = :monto")})
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetalle_Pedido")
    private Integer iddetallePedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private double monto;
    @JoinColumn(name = "pedidos_idpedido", referencedColumnName = "idpedido")
    @ManyToOne(optional = false)
    private Pedido pedidosIdpedido;
    @JoinColumn(name = "produtos_idprodutos", referencedColumnName = "idprodutos")
    @ManyToOne(optional = false)
    private Producto produtosIdprodutos;

    public DetallePedido() {
    }

    public DetallePedido(Integer iddetallePedido) {
        this.iddetallePedido = iddetallePedido;
    }

    public DetallePedido(Integer iddetallePedido, int cantidad, double monto) {
        this.iddetallePedido = iddetallePedido;
        this.cantidad = cantidad;
        this.monto = monto;
    }

    public Integer getIddetallePedido() {
        return iddetallePedido;
    }

    public void setIddetallePedido(Integer iddetallePedido) {
        this.iddetallePedido = iddetallePedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Pedido getPedidosIdpedido() {
        return pedidosIdpedido;
    }

    public void setPedidosIdpedido(Pedido pedidosIdpedido) {
        this.pedidosIdpedido = pedidosIdpedido;
    }

    public Producto getProdutosIdprodutos() {
        return produtosIdprodutos;
    }

    public void setProdutosIdprodutos(Producto produtosIdprodutos) {
        this.produtosIdprodutos = produtosIdprodutos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallePedido != null ? iddetallePedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallePedido)) {
            return false;
        }
        DetallePedido other = (DetallePedido) object;
        if ((this.iddetallePedido == null && other.iddetallePedido != null) || (this.iddetallePedido != null && !this.iddetallePedido.equals(other.iddetallePedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.edu.cecar.pataconeraexpress.DetallePedido[ iddetallePedido=" + iddetallePedido + " ]";
    }
    
}
