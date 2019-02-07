package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoTeclado;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoTecladoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman on 18/10/18.
 */
@Service
@Transactional
public class TipoTecladoService {
    @Autowired
    private TipoTecladoRepository tipoTecladoRepository;

    public List<TipoTeclado> obtenerTipoTeclados(){
        return tipoTecladoRepository.findAll();
    }

    public TipoTeclado obtenerTipoTeclado(Long id){
        return tipoTecladoRepository.findOne(id);
    }


    public TipoTeclado guardarTipoTeclado(TipoTeclado tipoTeclado){
        return tipoTecladoRepository.save(tipoTeclado);
    }

    public void eliminarTipoTeclado(Long id){
        tipoTecladoRepository.delete(id);
    }
}
