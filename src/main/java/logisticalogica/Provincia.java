/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logisticalogica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Provincia")
public class Provincia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "provinciaID")
    private Integer provinciaID;

    @Column(name = "nombre")
    private String nombre;

    public Provincia() {
    }

    public Provincia(Integer provinciaID, String nombre) {
        this.provinciaID = provinciaID;
        this.nombre = nombre;
    }

    public Integer getProvinciaID() {
        return provinciaID;
    }

    public void setProvinciaID(Integer provinciaID) {
        this.provinciaID = provinciaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
