/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.service.Imp;

import hack.future.model.Categoria;
import hack.future.repository.CategoriaRepository;
import hack.future.service.CategoriaSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Antonio Morales Donis
 */

@Service
public class CategoriaService implements CategoriaSrv{
    
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public Categoria guardarNuevaCategoria(Categoria categoria) {
        String nombre_categoria = "";
        switch (categoria.getNombre()) {
            case "administrativo":
                nombre_categoria = "ADMIN";
                break;
            case "proveedor":
                nombre_categoria = "PROV";
                break;
            case "logistica":
                nombre_categoria = "LOGIST";
                break;
            case "distribucion":
                nombre_categoria = "DIST";
                break;
            case "operacion":
                nombre_categoria = "OPERA";
                break;
            case "ventas":
                nombre_categoria = "VENTA";
                break;
            default:
                return null;
        }
        
        categoria.setNombre(nombre_categoria);
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria obtenerCategoriaPorNombre(String nombre_cat) {
        return categoriaRepository.findByNombre(nombre_cat);
    }
    
}
