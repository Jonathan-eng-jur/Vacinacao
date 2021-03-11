package br.com.jhon.VacinacaoZup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.jhon.VacinacaoZup.Model.VacinacaoModel;
import br.com.jhon.VacinacaoZup.entity.Usuario;
import br.com.jhon.VacinacaoZup.service.UsuarioService;
import br.com.jhon.VacinacaoZup.service.VacinacaoService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/vacinacao")
public class VacinacaoController {

    @Autowired
    VacinacaoService vacinacaoService;

    @Autowired
    UsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<VacinacaoModel> create(@Valid @RequestBody VacinacaoModel vacinacaoModel, 
    	UriComponentsBuilder uriBuilder){
        Usuario usuario = usuarioService.findByEmail(vacinacaoModel.getUsuarioEmail());
        VacinacaoModel vacinacao = new  VacinacaoModel(vacinacaoService.create(VacinacaoModel.converter
        (vacinacaoModel, usuario)));
        URI uri = uriBuilder.path("/vacinacao/{id}").buildAndExpand(vacinacao.getId()).toUri();
        return ResponseEntity.created(uri).body(vacinacao);
    }
}
