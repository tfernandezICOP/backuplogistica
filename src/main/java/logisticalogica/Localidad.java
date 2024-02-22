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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Localidad")
public class Localidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "localidadID")
    private Integer localidadID;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "provinciaID")
    private Provincia provincia;

    public Localidad(Integer localidadID, String nombre, Provincia provincia) {
        this.localidadID = localidadID;
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public Localidad() {
    }

    public Integer getLocalidadID() {
        return localidadID;
    }

    public void setLocalidadID(Integer localidadID) {
        this.localidadID = localidadID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    
}
