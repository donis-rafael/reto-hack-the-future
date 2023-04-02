/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.service.Imp;

import hack.future.model.HuellaCarbono;
import hack.future.repository.HuellaCarbonoRepository;
import hack.future.service.HuellaCarbonoSrv;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rafael Antonio Morales Donis
 */
@Service
public class HuellaCarbonoService implements HuellaCarbonoSrv {

    @Autowired
    HuellaCarbonoRepository huellaCarbonoRepository;

    @Override
    public HuellaCarbono guardarNuevaHuella(HuellaCarbono huella) {
        String mes = huella.getMes() < 10 ? "0" + huella.getMes() : huella.getMes() + "";
        huella.setId(Integer.parseInt(huella.getAnio() + mes));
        return huellaCarbonoRepository.save(huella);
    }

    @Override
    public HuellaCarbono obtenerHuella(int id) {
        Optional<HuellaCarbono> huella = huellaCarbonoRepository.findById(id);
        if (huella.isPresent()) {
            return huella.get();
        }
        return null;
    }
}
