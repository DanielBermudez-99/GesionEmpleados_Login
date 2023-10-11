package com.login.loginproyect.controllers;

import com.login.loginproyect.models.User.AuthService;
import com.login.loginproyect.models.User.DatosRegistroUsuario;
import com.login.loginproyect.models.User.User;
import com.login.loginproyect.models.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;


    @PostMapping
    public String registrarUsuario(@RequestBody DatosRegistroUsuario datosRegistroUsuario){
        User usuario = userRepository.save(new User(datosRegistroUsuario));
        return "Usuario Registrado";
    }

    @PostMapping("/login")
    public ResponseEntity<?> iniciarSesion(@RequestBody DatosRegistroUsuario datosRegistroUsuario) {
        User user = userRepository.findByUser(datosRegistroUsuario.user());
        if (user != null) {
            if (user.getPassword().equals(datosRegistroUsuario.password())) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
