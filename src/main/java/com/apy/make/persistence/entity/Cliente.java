package com.apy.make.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity // se encarga de maperar esta clase a la base de datos DB
@Table(name="clientes")
public class Cliente {
    @Id
    private String id;
    private String nombre;
    @Column( name = "apellidos")
    private String apellido;

    @Column(name ="celular")
    private Long celular;
    @Column(name ="direccion")
    private  String direccion;

    @Column(name="correo_electronico")
    private  String correoElectronico;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
