/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.service;

import hack.future.model.Categoria;

/**
 *
 * @author Rafael Antonio Morales Donis
 */
public interface CategoriaSrv {
    public Categoria guardarNuevaCategoria(Categoria categoria);
    public Categoria obtenerCategoriaPorNombre(String nombre_cat);
}
