/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hack.future.dto;

/**
 *
 * @author Rafael Antonio Morales Donis
 */

public class ConsumoDto {
    private int anio;
    private int mes;
    private double consumo;
    private String categoria;
    private String tipoConsumo;

    @Override
    public String toString() {
        return "ConsumoDto{" + "anio=" + anio + ", mes=" + mes + ", consumo=" + consumo + ", categoria=" + categoria + ", tipoConsumo=" + tipoConsumo + '}';
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

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipoConsumo() {
        return tipoConsumo;
    }

    public void setTipoConsumo(String tipoConsumo) {
        this.tipoConsumo = tipoConsumo;
    }
}