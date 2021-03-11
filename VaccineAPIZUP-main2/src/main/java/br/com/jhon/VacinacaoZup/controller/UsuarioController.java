package br.com.jhon.VacinacaoZup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.jhon.VacinacaoZup.Model.UsuarioModel;
import br.com.jhon.VacinacaoZup.service.UsuarioService;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioModel> create(@Valid @RequestBody UsuarioModel usuario, UriComponentsBuilder uriBuilder){
        UsuarioModel usuarioModel =  new UsuarioModel(usuarioService.create(UsuarioModel.converter(usuario)));
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuarioModel.getId()).toUri();
        return ResponseEntity.created(uri).body(usuarioModel);
    }
}
