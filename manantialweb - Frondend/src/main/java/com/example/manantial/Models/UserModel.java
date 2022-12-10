package com.example.manantial.Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")

public class UserModel {
    public UserModel(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)

    private Long id;
    private Long cedula;
    private String nombre;
    private String email;
    private String numero_telefonico;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCedula() {
        return cedula;
    }
    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNumero_telefonico() {
        return numero_telefonico;
    }
    public void setNumero_telefonico(String numero_telefonico) {
        this.numero_telefonico = numero_telefonico;
    }    

}
