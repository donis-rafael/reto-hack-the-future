/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.service.Imp;

import hack.future.model.Categoria;
import hack.future.model.Consumo;
import hack.future.model.HuellaCarbono;
import hack.future.model.TipoConsumo;
import hack.future.repository.ConsumoRepository;
import hack.future.service.CategoriaSrv;
import hack.future.service.ConsumoSrv;
import hack.future.service.HuellaCarbonoSrv;
import hack.future.service.TipoConsumoSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Antonio Morales Donis
 */
@Service
public class ConsumoService implements ConsumoSrv {

    @Autowired
    HuellaCarbonoSrv huellaCarbonoService;

    @Autowired
    CategoriaSrv categoriaService;

    @Autowired
    TipoConsumoSrv tipoConsumoService;

    @Autowired
    ConsumoRepository consumoRepository;

    @Override
    public Consumo obtenerConsumoPorCategoriaYTipo(Categoria categoria, TipoConsumo tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consumo guardarNuevoConsumo(int anio, int mes, double consumo, String categoria, String tipo) {
        String mes_format = mes < 10 ? "0" + mes : mes + "";
        int id = Integer.parseInt(anio + mes_format);
        HuellaCarbono huella = huellaCarbonoService.obtenerHuella(id);

        if (huella == null) {
            huella = huellaCarbonoService.guardarNuevaHuella(new HuellaCarbono(id, anio, mes));
        }

        String nombre_categoria = "";
        switch (categoria) {
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

        Categoria categoria_model = categoriaService.obtenerCategoriaPorNombre(nombre_categoria);
        if (categoria_model == null) {
            categoria_model = categoriaService.guardarNuevaCategoria(new Categoria(nombre_categoria));
        }
        System.out.println(categoria_model);

        String nombre_tipo_consumo = "";
        switch (tipo) {
            case "combustible":
                nombre_tipo_consumo = "COMBUSTIBLE";
                break;
            case "energia":
                nombre_tipo_consumo = "ENERGIA_ELECTRICA";
                break;
            case "petroleo":
                nombre_tipo_consumo = "DERIV_PETROLEO";
                break;
            case "viajes":
                nombre_tipo_consumo = "VIAJES";
                break;
            case "papel":
                nombre_tipo_consumo = "PAPEL";
                break;
            default:
                return null;
        }

        TipoConsumo tipo_consumo_model = tipoConsumoService.obtenerTipoConsumoPorNombre(nombre_tipo_consumo);
        if (tipo_consumo_model == null) {
            tipo_consumo_model = tipoConsumoService.guardarNuevoTipoConsumo(new TipoConsumo(nombre_tipo_consumo));
        }
        System.out.println(tipo_consumo_model);

        Consumo consumo_model = new Consumo(consumo, huella, categoria_model, tipo_consumo_model);
        return consumoRepository.save(consumo_model);
    }

    @Override
    public Consumo actualizarConsumo(int anio, int mes, double consumo, String categoria, String tipo) {
        String mes_format = mes < 10 ? "0" + mes : mes + "";
        int id = Integer.parseInt(anio + mes_format);
        HuellaCarbono huella = huellaCarbonoService.obtenerHuella(id);
        Consumo consumo_model;

        if (huella != null) {
            consumo_model = consumoRepository.findByHuella(huella);
            if (consumo_model == null) {
                return null;
            }
        } else {
            return null;
        }

        Categoria categoria_model;
        if (!categoria.isBlank()) {
            String nombre_categoria;
            switch (categoria) {
                case "administrativo":
                    nombre_categoria = "ADMIN";
                    break;
                case "proveedor":
                    nombre_categoria = "PROV";
                    break;
                case "logistica":
                    nombre_categoria = "LOGIST";
                    break;
                default:
                    return null;
            }

            categoria_model = categoriaService.obtenerCategoriaPorNombre(nombre_categoria);
            if (categoria_model != null) {
                consumo_model.setCategoria(categoria_model);
            }
            System.out.println(categoria_model);
        }

        TipoConsumo tipo_consumo_model;
        if (!tipo.isBlank()) {
            String nombre_tipo_consumo;
            switch (tipo) {
                case "combustible":
                    nombre_tipo_consumo = "COMBUSTIBLE";
                    break;
                default:
                    return null;
            }

            tipo_consumo_model = tipoConsumoService.obtenerTipoConsumoPorNombre(nombre_tipo_consumo);
            if (tipo_consumo_model != null) {
                consumo_model.setTipoConsumo(tipo_consumo_model);
            }
            System.out.println(tipo_consumo_model);
        }

        return consumoRepository.save(consumo_model);
    }

}
