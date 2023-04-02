/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.controllers;

import hack.future.dto.ConsumoDto;
import hack.future.model.Consumo;
import hack.future.service.ConsumoSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael Antonio Morales Donis
 */

@RestController
public class HuellaCarbonoController {

    @Autowired
    ConsumoSrv consumoService;

    /**
     * Se necesita registrar el consumo de combustible categorizado por
     * - combustible administrativo
     * - combustible indirecto de proveedor
     * - combustible de logística
     * También se debe segmentar según tipo de emisión
     * 
     * @param consumo
     * @return
     */
    @PostMapping("/consumo-combustible")
    public ResponseEntity<?> consumoCombustible(@RequestBody ConsumoDto consumo) {
        Consumo consumo_model = consumoService.guardarNuevoConsumo(consumo.getAnio(), consumo.getMes(), consumo.getConsumo(), consumo.getCategoria(), "combustible");
        return ResponseEntity.status(HttpStatus.OK).body(consumo_model != null ? consumo_model : "No fue posible almacenar el consumo, revise la categoría");
    }
    
    /**
     * Se necesita registrar el consumo de energía eléctrica categorizada por
     * -  consumo administrativo
     * -  consumo logístico
     * - consumo de distribución
     * También se debe segmentar según tipo de emisión
     * 
     * @param consumo
     * @return
     */
    @PostMapping("/consumo-energia")
    public ResponseEntity<?> consumoEnergia(@RequestBody ConsumoDto consumo) {
        Consumo consumo_model = consumoService.guardarNuevoConsumo(consumo.getAnio(), consumo.getMes(), consumo.getConsumo(), consumo.getCategoria(), "energia");
        return ResponseEntity.status(HttpStatus.OK).body(consumo_model != null ? consumo_model : "No fue posible almacenar el consumo, revise la categoría");
    }
    
    /**
     * Se necesita registrar el consumo de otros productos derivados del petróleo categorizada por
     * -  consumo administrativo
     * -  consumo logístico
     * -  consumo de operación
     * También se debe segmentar según tipo de emisión
     * 
     * @param consumo
     * @return
     */
    @PostMapping("/consumo-otros")
    public ResponseEntity<?> consumoOtros(@RequestBody ConsumoDto consumo) {
        Consumo consumo_model = consumoService.guardarNuevoConsumo(consumo.getAnio(), consumo.getMes(), consumo.getConsumo(), consumo.getCategoria(), consumo.getTipoConsumo());
        return ResponseEntity.status(HttpStatus.OK).body(consumo_model != null ? consumo_model : "No fue posible almacenar el consumo, revise la categoría o el tipo de consumo");
    }
    
    /**
     * Registrar número de viajes.También se debe segmentar segúntipo de emisión.
     * 
     * @param consumo
     * @return
     */
    @PostMapping("/viajes")
    public ResponseEntity<?> consumoViajes(@RequestBody ConsumoDto consumo) {
        Consumo consumo_model = consumoService.guardarNuevoConsumo(consumo.getAnio(), consumo.getMes(), consumo.getConsumo(), consumo.getCategoria(), "viajes");
        return ResponseEntity.status(HttpStatus.OK).body(consumo_model != null ? consumo_model : "No fue posible almacenar los viajes, revise la categoría");
    }
    
    /**
     * Actualizar cantidad de consumo de combustible según su categoría.
     * 
     * @param consumo
     * @return
     */
    @PutMapping("/consumo-combustible")
    public ResponseEntity<?> actualizarConsumo(@RequestBody ConsumoDto consumo) {
        Consumo consumo_model = consumoService.guardarNuevoConsumo(consumo.getAnio(), consumo.getMes(), consumo.getConsumo(), consumo.getCategoria(), "combustible");
        return ResponseEntity.status(HttpStatus.OK).body(consumo_model != null ? consumo_model : "No fue posible actualizar el consumo, revise la categoría");
    }
}
