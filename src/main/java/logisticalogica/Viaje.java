/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logisticalogica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Viaje")
public class Viaje implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "viajeID")
    private Integer viajeID;

    @ManyToOne
    @JoinColumn(name = "origenProvinciaID")
    private Provincia origen;

    @ManyToOne
    @JoinColumn(name = "destinoProvinciaID")
    private Provincia destino;

    @ManyToOne
    @JoinColumn(name = "origenLocalidadID")
    private Localidad localidadOrigen;

    @ManyToOne
    @JoinColumn(name = "destinoLocalidadID")
    private Localidad localidadDestino;

    @Temporal(TemporalType.DATE)     
    @Column(name = "fecha")
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "vehiculoID")
    private Vehiculo vehiculo;
 @Column(name = "estado")  // Nueva columna "estado"
    private String estado;
    
    public Viaje() {
                this.estado = "Activo";  // Por defecto, el cliente se establece como "Activo"

    }

    public Viaje(Integer viajeID, Provincia origen, Provincia destino, Localidad localidadOrigen, Localidad localidadDestino, Date fecha, Vehiculo vehiculo, String estado) {
        this.viajeID = viajeID;
        this.origen = origen;
        this.destino = destino;
        this.localidadOrigen = localidadOrigen;
        this.localidadDestino = localidadDestino;
        this.fecha = fecha;
        this.vehiculo = vehiculo;
        this.estado = estado;
    }

    public Integer getViajeID() {
        return viajeID;
    }

    public void setViajeID(Integer viajeID) {
        this.viajeID = viajeID;
    }

    public Provincia getOrigen() {
        return origen;
    }

    public void setOrigen(Provincia origen) {
        this.origen = origen;
    }

    public Provincia getDestino() {
        return destino;
    }

    public void setDestino(Provincia destino) {
        this.destino = destino;
    }

    public Localidad getLocalidadOrigen() {
        return localidadOrigen;
    }

    public void setLocalidadOrigen(Localidad localidadOrigen) {
        this.localidadOrigen = localidadOrigen;
    }

    public Localidad getLocalidadDestino() {
        return localidadDestino;
    }

    public void setLocalidadDestino(Localidad localidadDestino) {
        this.localidadDestino = localidadDestino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   
}