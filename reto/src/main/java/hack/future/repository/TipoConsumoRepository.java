/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.repository;

import hack.future.model.TipoConsumo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rafael Antonio Morales Donis
 */

@Repository
public interface TipoConsumoRepository extends CrudRepository<TipoConsumo, Integer>{
    TipoConsumo findByNombre(String nombre);
}
