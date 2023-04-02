/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.controllers;

import hack.future.service.ConsumoSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael Antonio Morales Donis
 */

@RestController
public class OperacionesController {

    @Autowired
    ConsumoSrv consumoService;

    /**
     * Calcular el porcentaje de consumo anual de combustible por
     * categoría (en porcentaje)
     * 
     * @return
     */
    @GetMapping("/combustible-anual-categoria")
    public ResponseEntity<?> consumoCombustibleCategoria() {
        //Consumo consumo_model = consumoService.guardarNuevoConsumo(consumo.getAnio(), consumo.getMes(), consumo.getConsumo(), consumo.getCategoria(), "combustible");
        return ResponseEntity.status(HttpStatus.OK).body("Calcular el porcentaje de consumo anual de combustible por categoría (en porcentaje)");
    }

    /**
     * Calcular el promedio mensual de consumo de combustible (engalones)
     * 
     * @return
     */
    @GetMapping("/combustible-mensual-categoria")
    public ResponseEntity<?> consumoCombustible() {
        return ResponseEntity.status(HttpStatus.OK).body("Calcular el promedio mensual de consumo de combustible (engalones)");
    }

    /**
     * Calcular qué segmento es el que más impacta (en porcentaje)

     * 
     * @return
     */
    @GetMapping("/segmento-imacta")
    public ResponseEntity<?> segmentoImactante() {
        return ResponseEntity.status(HttpStatus.OK).body("Calcular qué segmento es el que más impacta (en porcentaje)");
    }

    /**
     * Calcular el promedio mensual de uso de energía eléctrica únicamente en la planta de envasado (en Kw)
     * 
     * @return
     */
    @GetMapping("/energia-mes-envasado")
    public ResponseEntity<?> promedioMesEnergia() {
        return ResponseEntity.status(HttpStatus.OK).body("Calcular el promedio mensual de uso de energía eléctrica únicamente en la planta de envasado (en Kw)");
    }

    /**
     * Comparativa de uso mensual entre energía eléctrica y uso de Combustible (en porcentaje) 
     * 
     * @return
     */
    @GetMapping("/compara-energia-combustible")
    public ResponseEntity<?> comparativaEnergiaCombustible() {
        return ResponseEntity.status(HttpStatus.OK).body("Comparativa de uso mensual entre energía eléctrica y uso de Combustible (en porcentaje)");
    }

    /**
     * Calcular promedio de uso mensual de productos derivados del petróleo
     * - Combustible
     * - Aceite
     * - Etc
     * (En porcentaje)

     * 
     * @return
     */
    @GetMapping("/mes-derivados-petroleo")
    public ResponseEntity<?> derivadosPetroleo() {
        return ResponseEntity.status(HttpStatus.OK).body("Calcular promedio de uso mensual de productos derivados del petróleo (en porcentaje)");
    }

    /**
     * Comparativa de promedio mensual de viajes equipo de ventas y equipo administrativo (En cantidad de viajes)
     * 
     * @return
     */
    @GetMapping("/compara-viajes")
    public ResponseEntity<?> comparaViajes() {
        return ResponseEntity.status(HttpStatus.OK).body("Comparativa de promedio mensual de viajes equipo de ventas y equipo administrativo (En cantidad de viajes)");
    }

    /**
     * Mostrar los datos de uso de aceites mensualmente (En galones)
     * 
     * @return
     */
    @GetMapping("/mes-aceites")
    public ResponseEntity<?> aceitesMensuales() {
        return ResponseEntity.status(HttpStatus.OK).body("Mostrar los datos de uso de aceites mensualmente (En galones)");
    }

    /**
     * Devolver mes donde hubieron menos pérdidas de refrigerantes
     * 
     * @return
     */
    @GetMapping("/minimo-refrigerantes")
    public ResponseEntity<?> menosRefrigerantas() {
        return ResponseEntity.status(HttpStatus.OK).body("Devolver mes donde hubieron menos pérdidas de refrigerantes");
    }

    /**
     * Obtener el mes que representa el uso menor vs el que representan la mayor cantidad de galones utilizados en combustible
     * 
     * @return
     */
    @GetMapping("/mayor-vs-menor-combustible")
    public ResponseEntity<?> menorMayorCombustible() {
        return ResponseEntity.status(HttpStatus.OK).body("Obtener el mes que representa el uso menor vs el que representan la mayor cantidad de galones utilizados en combustible");
    }
    
}
