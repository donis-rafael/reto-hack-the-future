/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.service;

import hack.future.model.Categoria;
import hack.future.model.Consumo;
import hack.future.model.TipoConsumo;

/**
 *
 * @author Rafael Antonio Morales Donis
 */
public interface ConsumoSrv {
    public Consumo guardarNuevoConsumo(int anio, int mes, double consumo, String categoria, String tipo);
    public Consumo obtenerConsumoPorCategoriaYTipo(Categoria categoria, TipoConsumo tipo);
    public Consumo actualizarConsumo(int anio, int mes, double consumo, String categoria, String tipo);
}
