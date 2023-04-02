/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.service;

import hack.future.model.HuellaCarbono;

/**
 *
 * @author Rafael Antonio Morales Donis
 */
public interface HuellaCarbonoSrv {
    public HuellaCarbono guardarNuevaHuella(HuellaCarbono huella);
    public HuellaCarbono obtenerHuella(int id);
}
