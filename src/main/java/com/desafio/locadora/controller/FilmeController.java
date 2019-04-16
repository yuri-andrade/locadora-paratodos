package com.desafio.locadora.controller;

import com.desafio.locadora.converter.FilmeToFilmeOutConverter;
import com.desafio.locadora.domain.out.FilmeOut;
import com.desafio.locadora.service.FilmeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/filme")
public class FilmeController {
    private final FilmeService filmeService;
    private final FilmeToFilmeOutConverter toFilmeOutConverter;

    @Autowired
    public FilmeController(FilmeService filmeService, FilmeToFilmeOutConverter toFilmeOutConverter) {
        this.filmeService = filmeService;
        this.toFilmeOutConverter = toFilmeOutConverter;
    }

    @ApiOperation(value = "Procura filme pelo nome", response = FilmeOut.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Filme localizado com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno"),
            @ApiResponse(code = 404, message = "Filme não encontrado para o nome informado")
    })
    @GetMapping(value = "/{nome}")
    public ResponseEntity<FilmeOut> findByNome(@PathVariable String nome) {
        FilmeOut filme = toFilmeOutConverter.convert(filmeService.findByNome(nome).get(0));
        return ResponseEntity.ok().body(filme);
    }

    @ApiOperation(value = "Exibe lista de filmes disponíveis para locação", response = FilmeOut[].class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Filmes localizados com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno"),
    })
    @GetMapping()
    public ResponseEntity<Set<FilmeOut>> findAllAvailable() {
        Set<FilmeOut> allAvailableSet = toFilmeOutConverter.convertSet(filmeService.findAllAvailable());
        return ResponseEntity.ok().body(allAvailableSet);
    }
}
