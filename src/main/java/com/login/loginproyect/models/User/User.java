package com.login.loginproyect.models.User;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String user;
    private String password;

    public User(DatosRegistroUsuario datosRegistroUsuario){
        this.user = datosRegistroUsuario.user();
        this.password = datosRegistroUsuario.password();
    }
}
