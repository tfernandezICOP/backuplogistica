/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.List;
import logisticalogica.Paquete;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraPaquete {
    
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public void crearpaquete (Paquete paquete){
        controlpersis.crearpaquete(paquete);
    }
    public List<Paquete> obtenerTodosLosPaquetes() {
    return controlpersis.obtenerTodosLosPaquetes();
    }
        public List<Paquete> filtrarPaquetesPorCodigo(int codigo) {
        return controlpersis.obtenerPaquetesPorCodigo(codigo);
    }

    public void actualizarEstadoPaquete(Paquete paquete) {
        controlpersis.actualizarEstadoPaquete(paquete);
    }
    public void guardarPaquete(Paquete paquete) {
        controlpersis.guardarPaquete(paquete);
    }
    public List<Paquete> filtrarPaquetesPorEstado(String estado) {
    return controlpersis.obtenerPaquetesPorEstado(estado);
    }
    
    public void actualizarFechaEntregaPaquete(Paquete paquete) {
    controlpersis.actualizarFechaentrega(paquete);
    }    
    
      public List<Paquete> obtenerPaquetesEnCaminoPorViaje(int idViaje) {
       return controlpersis.obtenerPaquetesEnCaminoPorViaje(idViaje);
      }
      public List<Paquete> obtenerPaquetesPorEstadoYViaje(int idViaje) {
          return controlpersis.obtenerPaquetesPorEstadoYViaje(idViaje);
      }
           public List<Paquete> obtenerPaquetesPorViaje(int viajeID) {
           return controlpersis.obtenerPaquetesPorViaje(viajeID);
           }
           
           public List<Paquete> obtenerPaquetesPlanificadosPorViaje(int idViaje) {
           return controlpersis.obtenerPaquetesPlanificadosPorViaje(idViaje);
           }     
}


