/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Rafael Antonio Morales Donis
 */
@Entity
@Table(name = "consumo")
public class Consumo {

    @Id
    @Column(name = "id_consumo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double consumo;
    
    @ManyToOne
    @JoinColumn(name = "huella", unique=true)
    private HuellaCarbono huella;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
    
    @ManyToOne
    @JoinColumn(name = "id_t_consumo")
    private TipoConsumo tipoConsumo;

    public Consumo() {
    }

    public Consumo(double consumo, HuellaCarbono huella, Categoria categoria, TipoConsumo tipoConsumo) {
        this.consumo = consumo;
        this.huella = huella;
        this.categoria = categoria;
        this.tipoConsumo = tipoConsumo;
    }

    @Override
    public String toString() {
        return "Consumo{" + "id=" + id + ", consumo=" + consumo + ", huella=" + huella + ", categoria=" + categoria + ", tipoConsumo=" + tipoConsumo + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public HuellaCarbono getHuella() {
        return huella;
    }

    public void setHuella(HuellaCarbono huella) {
        this.huella = huella;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoConsumo getTipoConsumo() {
        return tipoConsumo;
    }

    public void setTipoConsumo(TipoConsumo tipoConsumo) {
        this.tipoConsumo = tipoConsumo;
    }
}
