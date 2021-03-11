package br.com.jhon.VacinacaoZup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhon.VacinacaoZup.entity.Usuario;
import br.com.jhon.VacinacaoZup.repository.UsuarioRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findByEmail(String email) {
        Optional<Usuario> entity = Optional.ofNullable(usuarioRepository.findUsuarioByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado")));
        return entity.get();
    }

}
