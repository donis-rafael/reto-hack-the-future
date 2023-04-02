/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.controllers;

import hack.future.dto.ConsumoDto;
import hack.future.model.Categoria;
import hack.future.model.HuellaCarbono;
import hack.future.model.TipoConsumo;
import hack.future.service.CategoriaSrv;
import hack.future.service.HuellaCarbonoSrv;
import hack.future.service.TipoConsumoSrv;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rafael Antonio Morales Donis
 */

@RestController
public class AlmacenamientoController {

    @Autowired
    HuellaCarbonoSrv huellaCarbonoService;

    @Autowired
    CategoriaSrv categoriaService;

    @Autowired
    TipoConsumoSrv tipoConsumoService;

    /**
     * Crear Huella Carbono
     * 
     * @param huella
     * @return
     */
    @PostMapping("/crear-huella")
    public ResponseEntity<?> nuevaHuella(@RequestBody ConsumoDto huella) {
        HuellaCarbono huella_model = huellaCarbonoService.guardarNuevaHuella(new HuellaCarbono(0, huella.getAnio(), huella.getMes()));
        return ResponseEntity.status(HttpStatus.OK).body(huella_model != null ? huella_model : "No fue posible crear nueva huella");
    }
    
    /**
     * Crear Huellas Carbonos
     * 
     * @param huellas
     * @return
     */
    @PostMapping("/crear-huellas")
    public ResponseEntity<?> nuevasHuellas(@RequestBody List<ConsumoDto> huellas) {
        for(ConsumoDto huella: huellas){
        huellaCarbonoService.guardarNuevaHuella(new HuellaCarbono(0, huella.getAnio(), huella.getMes()));
        }
        return ResponseEntity.status(HttpStatus.OK).body("Almacenadas correctamente");
    }

    /**
     * Crear Categoria
     * 
     * @param categoria
     * @return
     */
    @PostMapping("/crear-categoria")
    public ResponseEntity<?> nuevaCategoria(@RequestBody ConsumoDto categoria) {
        Categoria categoria_model = categoriaService.guardarNuevaCategoria(new Categoria(categoria.getCategoria()));
        return ResponseEntity.status(HttpStatus.OK).body(categoria_model != null ? categoria_model : "No fue posible crear nueva categoria");
    }

    /**
     * Crear varias Categorias
     * 
     * @param categorias
     * @return
     */
    @PostMapping("/crear-categorias")
    public ResponseEntity<?> nuevaCategorias(@RequestBody List<ConsumoDto> categorias) {
        for(ConsumoDto categoria: categorias){
            categoriaService.guardarNuevaCategoria(new Categoria(categoria.getCategoria()));
        }
        return ResponseEntity.status(HttpStatus.OK).body("Almacenadas correctamente");
    }

    /**
     * Crear Categoria
     * 
     * @param consumo
     * @return
     */
    @PostMapping("/crear-tipo-consumo")
    public ResponseEntity<?> nuevoTipo(@RequestBody ConsumoDto consumo) {
        TipoConsumo tipo_onsumo_model = tipoConsumoService.guardarNuevoTipoConsumo(new TipoConsumo(consumo.getTipoConsumo()));
        return ResponseEntity.status(HttpStatus.OK).body(tipo_onsumo_model != null ? tipo_onsumo_model : "No fue posible crear nuevo tipo de consumop");
    }

    /**
     * Crear varias Categorias
     * 
     * @param consumos
     * @return
     */
    @PostMapping("/crear-tipos-consumos")
    public ResponseEntity<?> nuevosTipos(@RequestBody List<ConsumoDto> consumos) {
        for(ConsumoDto consumo: consumos){
            tipoConsumoService.guardarNuevoTipoConsumo(new TipoConsumo(consumo.getTipoConsumo()));
        }
        return ResponseEntity.status(HttpStatus.OK).body("Almacenados correctamente");
    }
    
}
