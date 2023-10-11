package com.login.loginproyect.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthService {
    
    @Autowired
    UserRepository userRepository;

    public boolean login(DatosRegistroUsuario datosRegistroUsuario){

        User user = userRepository.findByUser(datosRegistroUsuario.user());
        if (user == null){
            return false;
        }else{
            if (user.getPassword() == datosRegistroUsuario.password()){
                System.out.println(user.getUser());
                System.out.println(user.getPassword());
                return true;
            }else {
                return false;
            }
        }
    }
}
