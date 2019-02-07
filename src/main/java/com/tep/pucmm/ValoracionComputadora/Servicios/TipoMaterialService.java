package com.tep.pucmm.ValoracionComputadora.Servicios;

import com.tep.pucmm.ValoracionComputadora.Entidades.TipoMaterial;
import com.tep.pucmm.ValoracionComputadora.Repositorio.TipoMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roman  on 18/10/18.
 */
@Service
@Transactional
public class TipoMaterialService {
    @Autowired
    private TipoMaterialRepository tipoMaterialRepository;

    public List<TipoMaterial> obtenerTipoMaterials(){
        return tipoMaterialRepository.findAll();
    }

    public TipoMaterial obtenerTipoMaterial(Long id){
        return tipoMaterialRepository.findOne(id);
    }


    public TipoMaterial guardarTipoMaterial(TipoMaterial tipoMaterial){
        return tipoMaterialRepository.save(tipoMaterial);
    }

    public void eliminarTipoMaterial(Long id){
        tipoMaterialRepository.delete(id);
    }
}
