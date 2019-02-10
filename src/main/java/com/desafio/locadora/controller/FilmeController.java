package com.desafio.locadora.controller;

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
        List<Filme> filmeList = filmeService.findByNome(nome);
        return new ResponseEntity<>(filmeList, HttpStatus.OK);
    }

    @ApiOperation(value = "Exibe lista de filmes disponíveis para locação", response = Filme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Filmes localizados"),
            @ApiResponse(code = 500, message = "Erro interno"),
    })
    @GetMapping(value = "list")
    public ResponseEntity<?> availableList() {
        List<Filme> lista = filmeService.findAllAvailable();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @ApiOperation(value = "Aluga o filme conforme o id", response = Filme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Filme alugado com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno"),
            @ApiResponse(code = 400, message = "Filme já encontra-se alugado"),
            @ApiResponse(code = 404, message = "Filme não encontrado para o id informado")

    })
    @PutMapping(value = "rent")
    public ResponseEntity<Filme> rentFilm(@RequestParam Long idFilme) {
        Filme filme = filmeService.rentFilm(idFilme);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna o filme conforme o id", response = Filme.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Filme retornado com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno"),
            @ApiResponse(code = 400, message = "Filme já encontra-se retornado"),
            @ApiResponse(code = 404, message = "Filme não encontrado para o id informado")

    })
    @PutMapping(value = "return")
    public ResponseEntity<Filme> returnFilm(@RequestParam Long idFilme) {
        Filme filme = filmeService.returnFilm(idFilme);
        return new ResponseEntity<>(filme, HttpStatus.OK);
    }
}
