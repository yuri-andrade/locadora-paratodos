package com.desafio.locadora.controller;

import com.desafio.locadora.converter.UsuarioInToUsuarioConverter;
import com.desafio.locadora.domain.in.UsuarioIn;
import com.desafio.locadora.domain.out.UsuarioOut;
import com.desafio.locadora.service.UsuarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final UsuarioInToUsuarioConverter usuarioInToUsuarioConverter;

    public UsuarioController(UsuarioService usuarioService,
            UsuarioInToUsuarioConverter usuarioInToUsuarioConverter) {
        this.usuarioService = usuarioService;
        this.usuarioInToUsuarioConverter = usuarioInToUsuarioConverter;
    }


    @ApiOperation(value = "Cria um usuário conforme os parâmetros de entrada", response = UsuarioOut.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Usuário criado com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno"),
            @ApiResponse(code = 400, message = "E-mail já cadastrado")

    })
    @PostMapping
    public ResponseEntity<UsuarioOut> createUser(@RequestBody UsuarioIn usuarioIn) {
        UsuarioOut usuarioOut = usuarioService.save(usuarioInToUsuarioConverter.convert(usuarioIn));
        return new ResponseEntity<>(usuarioOut, HttpStatus.CREATED);
    }
}


