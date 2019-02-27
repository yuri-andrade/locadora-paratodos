package com.desafio.locadora.service;

import com.desafio.locadora.entity.Filme;
import com.desafio.locadora.entity.enums.LocacaoEnum;
import com.desafio.locadora.exception.ResourceNotFoundException;
import com.desafio.locadora.repository.FilmeRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FilmeServiceTest {

    @Spy
    private FilmeRepository filmeRepository;

    @Spy
    @InjectMocks
    private FilmeService filmeService;

    private Filme filme;
    private String nome = "Se7en";
    private String diretor = "David Fincher";
    private Long id = 1L;

    @Before
    public void init() {
        filme = new Filme();
        filme.setId(id);
        filme.setNome(nome);
        filme.setDiretor(diretor);
        filme.setLocado(LocacaoEnum.NAO);
    }

    @Test
    public void testFindByNome() {
        List<Filme> list = new ArrayList<>();
        list.add(filme);
        Mockito.when(filmeRepository.findByNome(nome)).thenReturn(java.util.Optional.of(list));
        List<Filme> retrivedList = filmeService.findByNome(nome);
        Assert.assertEquals(list, retrivedList);
    }

    @Test
    public void testIsAvailableTrue() {
        Boolean retrievedBool = filmeService.isAvailable(filme);
        Assert.assertEquals(true, retrievedBool);
    }

    @Test
    public void testIsAvailableFalse() {
        filme.setLocado(LocacaoEnum.SIM);
        Boolean retrievedBool = filmeService.isAvailable(filme);
        Assert.assertEquals(false, retrievedBool);
    }

    @Test
    public void testFindByIdSucess() {
        Mockito.when(filmeRepository.findById(id)).thenReturn(java.util.Optional.ofNullable(filme));
        Filme retrivedFilme = filmeService.findById(id);
        Assert.assertEquals(filme, retrivedFilme);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testFindByIdFail() {
        filmeService.findById(2L);
    }

}
