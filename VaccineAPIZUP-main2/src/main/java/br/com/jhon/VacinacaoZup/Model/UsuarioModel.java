package br.com.jhon.VacinacaoZup.Model;

import org.hibernate.validator.constraints.br.CPF;

import br.com.jhon.VacinacaoZup.entity.Usuario;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @Email @NotBlank @Column(unique = true)
    private String email;
    @CPF @NotBlank @Column(unique = true)
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;

    public UsuarioModel() {}

    public UsuarioModel(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
        this.dataNascimento = usuario.getDataNascimento();
    }

    public static Usuario converter(UsuarioModel usuarioModel){
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioModel.getNome());
        usuario.setEmail(usuarioModel.getEmail());
        usuario.setCpf(usuarioModel.getCpf());
        usuario.setDataNascimento(usuarioModel.getDataNascimento());
        return usuario;
    }

    //Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }



}
