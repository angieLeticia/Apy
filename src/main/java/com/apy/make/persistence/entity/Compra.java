package com.apy.make.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

// esta anotacion le esta diciendo a java que esta clase es la que se encarga de mapear una clase en la DB
@Entity
// el nombre que se estable hay es como esta en la base de datos
@Table(name = "compras")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Este valor hace que java genere este valor de manera automatica
    @Column(name= "id_compra")
    private Integer idCompra;

    @Column(name = "id_cliente")
    private Integer id_Cliente;

    private LocalDateTime fecha;

    @Column(name ="medio_pago")
    private  String medioPago;

    private String comentario;

    private String estado;

    @ManyToOne
    @JoinColumn(name="id_cliente",insertable = false,updatable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "compra")
    private List<ComprasProducto> comprasProductos;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(Integer id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
