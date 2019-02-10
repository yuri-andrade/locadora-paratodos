package com.desafio.locadora.controller;

import com.desafio.locadora.domain.out.FilmeOut;
import com.desafio.locadora.entity.Filme;
import com.desafio.locadora.service.FilmeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/filme")
public class FilmeController {
    private final FilmeService filmeService;

    @Autowired
    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @ApiOperation(value = "Procura filme pelo nome", response = Filme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Filme localizado com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno"),
            @ApiResponse(code = 404, message = "Filme não encontrado para o nome informado")
    })
    @GetMapping(value = "search")
    public ResponseEntity<?> searchFilmByName(@RequestParam String nome) {
        List<FilmeOut> filmeList = filmeService.findByNome(nome);
        return new ResponseEntity<>(filmeList, HttpStatus.OK);
    }

    @ApiOperation(value = "Exibe lista de filmes disponíveis para locação", response = Filme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Filmes localizados"),
            @ApiResponse(code = 500, message = "Erro interno"),
    })
    @GetMapping()
    public ResponseEntity<?> availableList() {
        List<FilmeOut> lista = filmeService.findAllAvailable();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }




}
