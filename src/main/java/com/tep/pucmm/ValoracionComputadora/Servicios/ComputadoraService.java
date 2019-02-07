package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Computadora;
import com.tep.pucmm.ValoracionComputadora.Repositorio.ComputadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 17/10/18.
 */
@Service
@Transactional
public class ComputadoraService {

    @Autowired
    private ComputadoraRepository computadoraRepository;

    @Autowired
    private ParteService parteService;

    public List<Computadora> obtenerComputadoras(){
        return computadoraRepository.findAll();
    }
    public List<Computadora> obtenerComputadorasPorUsuario(Long id){
        return computadoraRepository.findAllByUsuario(id);
    }
    public Computadora obtenerComputadoraPorUsuario(Long id){
        return computadoraRepository.findByUsuario(id);
    }

    public Computadora obtenerComputadora(Long id){
        return computadoraRepository.findOne(id);
    }


    public Computadora guardarComputadora(Computadora computadora){
        return computadoraRepository.save(computadora);
    }

    public void eliminarComputadora(Long id){
        parteService.eliminarPartePorComputadoraId(id);
        computadoraRepository.delete(id);
    }

    public void eliminarComputadoraPorUsuario(Long id){
        List <Computadora> computadoras = computadoraRepository.findAllByUsuario(id);
        for (Computadora computadora: computadoras){
            eliminarComputadora(computadora.getId());
        }
    }
}
