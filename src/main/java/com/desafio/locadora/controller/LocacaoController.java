package com.desafio.locadora.controller;


import com.desafio.locadora.domain.out.LocacaoOut;

import com.desafio.locadora.service.LocacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/locacao")
public class LocacaoController {
    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @ApiOperation(value = "Encerra uma locação conforme o id do filme informado", response = LocacaoOut.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Locação encerrada com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno"),
            @ApiResponse(code = 404, message = "Locação em aberto com o filme de id informado não encontrada.")

    })
    @PutMapping()
    public ResponseEntity<LocacaoOut> endLocacao(@RequestParam Long idFilme) {
        LocacaoOut locacaoOut = locacaoService.endLocacao(idFilme);
        return new ResponseEntity<>(locacaoOut, HttpStatus.OK);
    }

    @ApiOperation(value = "Inicia uma locação com o filme de nome informado", response = LocacaoOut.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Locação criada com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno"),
            @ApiResponse(code = 400, message = "Filme já encontra-se alugado"),
            @ApiResponse(code = 404, message = "Filme não encontrado para o id informado")

    })
    @PostMapping()
    public ResponseEntity<LocacaoOut> startLocacao(@RequestParam String nomeFilme) {
        LocacaoOut locacaoOut = locacaoService.startLocacao(nomeFilme);
        return new ResponseEntity<>(locacaoOut, HttpStatus.CREATED);
    }
}
