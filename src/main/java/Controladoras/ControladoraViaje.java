/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.List;
import logisticalogica.Vehiculo;
import logisticalogica.Viaje;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraViaje {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void crearviaje (Viaje viaje){
        controlpersis.crearviaje(viaje);
    }
    public void guardarViaje(Viaje viaje) {
        controlpersis.guardarViaje(viaje);
    }
    public Viaje obtenerViajePorId(int viajeID) {
        return controlpersis.obtenerViajePorId(viajeID);
    }
 public List<Viaje> obtenerViajesActivosPorVehiculo(int vehiculoID) {
     return controlpersis.obtenerViajesActivosPorVehiculo(vehiculoID);
 
 }
 
 public List<Viaje> obtenerTodosLosViajes() {
      return controlpersis.obtenerTodosLosViajes();
  }
 
   public void actualizarEstadoViaje(int idViaje, String nuevoEstado) {
    controlpersis.actualizarEstadoViaje(idViaje, nuevoEstado);
   }
   
     public List<Viaje> obtenerViajesActivos() {
         return controlpersis.obtenerViajesActivos();
             
     }
     
          public List<Viaje> obtenerViajesPorEstadoYVehiculo(String estado, int vehiculoID) {
           return controlpersis.obtenerViajesPorEstadoYVehiculo(estado, vehiculoID);
          }
}
