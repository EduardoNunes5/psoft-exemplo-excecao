package com.psoft.exemplo.exception.controller;


import com.psoft.exemplo.exception.dto.UsuarioRequestDTO;
import com.psoft.exemplo.exception.dto.UsuarioResponseDTO;
import com.psoft.exemplo.exception.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED) //definindo resposta como 201 caso não seja lançada exceção no service
    public UsuarioResponseDTO salvarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO){
        return this.usuarioService.salvarUsuario(usuarioRequestDTO);
    }

    // por padrão é código 200 (OK) caso não seja lançada exceção
    @GetMapping("/usuario/{id}")
    public UsuarioResponseDTO recuperarUsuario(@PathVariable("id") Long id){
        return this.usuarioService.buscaPorId(id);
    }


}
