/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.service;

import hack.future.model.TipoConsumo;

/**
 *
 * @author Rafael Antonio Morales Donis
 */
public interface TipoConsumoSrv {
    public TipoConsumo guardarNuevoTipoConsumo(TipoConsumo tipo_consumo);
    public TipoConsumo obtenerTipoConsumoPorNombre(String nombre_consumo);
}
