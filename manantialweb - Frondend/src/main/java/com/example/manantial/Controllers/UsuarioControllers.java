package com.example.manantial.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.manantial.Models.UserModel;
import com.example.manantial.Services.UsuarioServicio;

@RestController
@RequestMapping("/usuarios/")
public class UsuarioControllers {
    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping
    public ArrayList<UserModel>obtenerusuarios(){
        return usuarioServicio.obtenerusuarios();
    }

    @PostMapping
    public UserModel guardardatos(@RequestBody UserModel usuario){
        return this.usuarioServicio.guardardatos(usuario);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarUser(@PathVariable("id") Long id){
        boolean ok = this.usuarioServicio.eliminar_user(id);
        if(ok){
            return "Se elimino con exito";
        }        
        else{
            return "No se elimino porque no se encontro en la base de datos";
        }
    }

    @GetMapping("/query")
    public ArrayList<UserModel>obtenerusuarioporcedula(@RequestParam("cedula")Long cedula){
        System.out.println(cedula);
        return this.usuarioServicio.obtenerporcedula(cedula);
        //http://localhost:8080/usuarios/query?cedula=72262629 para colocarlo en la URL y consultar
    }

    @GetMapping("/queryemail")
    public ArrayList<UserModel>obtenerusuarioporemail(@RequestParam("email")String email){
        return this.usuarioServicio.obtenerporemail(email);
        //http://localhost:8080/usuarios/query?cedula=72262629 para colocarlo en la URL y consultar
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel>obtenerusuarioporid(@PathVariable("id") Long id){
        return this.usuarioServicio.obtenerusuarioporId(id);
    }
}