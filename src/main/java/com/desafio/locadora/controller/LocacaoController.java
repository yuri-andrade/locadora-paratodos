package com.desafio.locadora.controller;


import com.desafio.locadora.domain.out.FilmeOut;
import com.desafio.locadora.service.LocacaoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/locacao")
public class LocacaoController {
    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @ApiOperation(value = "Aluga o filme conforme o id", response = FilmeOut.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Filme alugado com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno"),
            @ApiResponse(code = 400, message = "Filme já encontra-se alugado"),
            @ApiResponse(code = 404, message = "Filme não encontrado para o id informado")

    })
    @PostMapping()
    public ResponseEntity<FilmeOut> rentFilm(@RequestParam Long idFilme) {
        FilmeOut filmeOut = locacaoService.rentFilm(idFilme);
        return new ResponseEntity<>(filmeOut, HttpStatus.OK);
    }

    @ApiOperation(value = "Retorna o filme conforme o id", response = FilmeOut.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Filme retornado com sucesso"),
            @ApiResponse(code = 500, message = "Erro interno"),
            @ApiResponse(code = 404, message = "Locação em aberto com o filme de id informado não encontrada.")

    })
    @PutMapping()
    public ResponseEntity<FilmeOut> returnFilm(@RequestParam Long idFilme) {
        FilmeOut filmeOut = locacaoService.returnFilm(idFilme);
        return new ResponseEntity<>(filmeOut, HttpStatus.OK);
    }
}
