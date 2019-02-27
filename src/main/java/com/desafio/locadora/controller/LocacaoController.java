package com.desafio.locadora.controller;

import com.desafio.locadora.converter.LocacaoToLocacaoOutConverter;
import com.desafio.locadora.domain.in.LocacaoIn;
import com.desafio.locadora.domain.out.LocacaoOut;
import com.desafio.locadora.service.LocacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/locacao")
public class LocacaoController {
    private final LocacaoService locacaoService;
    private final LocacaoToLocacaoOutConverter locacaoToLocacaoOutConverter;

    public LocacaoController(LocacaoService locacaoService, LocacaoToLocacaoOutConverter locacaoToLocacaoOutConverter) {
        this.locacaoService = locacaoService;
        this.locacaoToLocacaoOutConverter = locacaoToLocacaoOutConverter;
    }

    @ApiOperation(value = "Encerra uma locação conforme o id do filme informado", response = LocacaoOut.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Locação encerrada com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno"),
            @ApiResponse(code = 404, message = "Locação em aberto com o filme de id informado não encontrada.")

    })
    @PutMapping()
    public ResponseEntity<LocacaoOut> endLocacao(@RequestBody LocacaoIn locacaoIn) {
        LocacaoOut locacaoOut = locacaoToLocacaoOutConverter.convert(locacaoService.endLocacao(locacaoIn));
        return new ResponseEntity<>(locacaoOut, HttpStatus.OK);
    }

    @ApiOperation(value = "Inicia uma locação com o filme de nome informado", response = LocacaoOut.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Locação criada com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno"),
            @ApiResponse(code = 404, message = "Filme não encontrado para o id informado")

    })
    @PostMapping()
    public ResponseEntity<LocacaoOut> startLocacao(@RequestBody LocacaoIn locacaoIn) {
        LocacaoOut locacaoOut = locacaoToLocacaoOutConverter.convert(locacaoService
                .startLocacao(locacaoIn));
        return new ResponseEntity<>(locacaoOut, HttpStatus.CREATED);
    }
}
