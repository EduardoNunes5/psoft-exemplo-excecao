package com.psoft.exemplo.exception.service;

import com.psoft.exemplo.exception.exception.UsuarioJaExistenteException;
import com.psoft.exemplo.exception.exception.UsuarioNaoEncontradoException;
import com.psoft.exemplo.exception.dto.UsuarioResponseDTO;
import com.psoft.exemplo.exception.dto.UsuarioRequestDTO;
import com.psoft.exemplo.exception.entity.Usuario;
import com.psoft.exemplo.exception.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioResponseDTO salvarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        verificaSeJaExiste(usuarioRequestDTO.getUsername());
        Usuario usuario = new Usuario(usuarioRequestDTO.getNome(),
                usuarioRequestDTO.getUsername(),
                usuarioRequestDTO.getPassword(),
                usuarioRequestDTO.getIdade());

        Usuario salvo = usuarioRepository.save(usuario);
        return new UsuarioResponseDTO(salvo);
    }

    public UsuarioResponseDTO buscaPorId(Long id) {
        return new UsuarioResponseDTO(retornaSeExiste(id));
    }

    private void verificaSeJaExiste(String username) {
        //caso o usuário esteja presente
        // a função lambda vai recebê-lo como argumento e então lançar a exceção
        this.usuarioRepository.findByUsername(username)
                .ifPresent((usuario) -> {
                    throw new UsuarioJaExistenteException(usuario.getNome());
                });
    }

    // se o usuário existir, ele é retornado, senão (orElseThrow) nova exceção é lançada
    public Usuario retornaSeExiste(String username){
        return this.usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(username));
    }

    public Usuario retornaSeExiste(Long id){
        return this.usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEncontradoException(id));
    }
}
