package br.com.jhon.VacinacaoZup.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.jhon.VacinacaoZup.entity.Usuario;
import br.com.jhon.VacinacaoZup.entity.Vacinacao;

import java.time.LocalDate;

public class VacinacaoModel{
    private Long id;
    @NotBlank
    private String nomeVacina;
    @NotBlank @Email
    private String usuarioEmail;
    @NotNull
    private LocalDate dataAplicacao;

    public VacinacaoModel() {
    }

    public VacinacaoModel(Vacinacao vacinacao) {
        this.id = vacinacao.getId();
        this.nomeVacina = vacinacao.getNomeVacina();
        this.usuarioEmail = vacinacao.getUsuario().getEmail();
        this.dataAplicacao = vacinacao.getDataAplicacao();
    }

    public static Vacinacao converter(VacinacaoModel vacinacaoModel, Usuario usuario){
        Vacinacao vacinacao = new Vacinacao();
        vacinacao.setNomeVacina(vacinacaoModel.getNomeVacina());
        vacinacao.setUsuario(usuario);
        vacinacao.setDataAplicacao(vacinacaoModel.getDataAplicacao());
        return vacinacao;
    }

    //Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
}
