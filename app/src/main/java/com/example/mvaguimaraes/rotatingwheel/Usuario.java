package com.example.mvaguimaraes.rotatingwheel;

/**
 * Created by Mvaguimaraes on 3/9/16.
 */
public class Usuario {
    private String nome;
    private String email;
    private String password;
    private long id;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

}

