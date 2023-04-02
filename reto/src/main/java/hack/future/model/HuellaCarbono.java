/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rafael Antonio Morales Donis
 */

@Entity
@Table(name = "huella_carbono")
public class HuellaCarbono {

    @Id
    @Column(name = "anio_mes")
    private int id;
    private int anio;
    private int mes;

    public HuellaCarbono() {
    }

    public HuellaCarbono(int id, int anio, int mes) {
        this.id = id;
        this.anio = anio;
        this.mes = mes;
    }

    @Override
    public String toString() {
        return "HuellaCarbono{" + "id=" + id + ", anio=" + anio + ", mes=" + mes + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
}