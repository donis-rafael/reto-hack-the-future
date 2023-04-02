/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.service.Imp;

import hack.future.model.TipoConsumo;
import hack.future.repository.TipoConsumoRepository;
import hack.future.service.TipoConsumoSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Antonio Morales Donis
 */

@Service
public class TipoConsumoService implements TipoConsumoSrv{
    
    @Autowired
    TipoConsumoRepository tipoConsumoRepository;

    @Override
    public TipoConsumo guardarNuevoTipoConsumo(TipoConsumo tipo_consumo) {
        return tipoConsumoRepository.save(tipo_consumo);
    }

    @Override
    public TipoConsumo obtenerTipoConsumoPorNombre(String nombre_consumo) {
        return tipoConsumoRepository.findByNombre(nombre_consumo);
    }
    
}
