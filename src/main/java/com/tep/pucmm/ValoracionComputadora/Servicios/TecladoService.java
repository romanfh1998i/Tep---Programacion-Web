package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.Teclado;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TecladoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TecladoService {
    @Autowired
    private TecladoRepository tecladoRepository;

    public List<Teclado> obtenerTeclados(){
        return tecladoRepository.findAll();
    }

    public Teclado obtenerTeclado(Long id){
        return tecladoRepository.findOne(id);
    }

    public List<Teclado> obtenerTecladoByParte(Long id){
        return tecladoRepository.findAllByParteId(id);
    }

    public Teclado guardarTeclado(Teclado teclado){
        return tecladoRepository.save(teclado);
    }

    public void eliminarTeclado(Long id){
        tecladoRepository.delete(id);
    }

    public void eliminarTecladoPorParte(Long id){
        tecladoRepository.deleteByParteId(id);
    }
}
