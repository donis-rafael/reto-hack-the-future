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
import javax.persistence.Table;

/**
 *
 * @author Rafael Antonio Morales Donis
 */

@Entity
@Table(name = "tipo_consumo")
public class TipoConsumo {
    
    @Id
    @Column(name = "id_t_consumo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    public TipoConsumo() {
    }

    public TipoConsumo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoConsumo{" + "id=" + id + ", nombre=" + nombre + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
