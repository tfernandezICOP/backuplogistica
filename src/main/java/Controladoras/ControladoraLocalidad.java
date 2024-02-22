/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.List;
import logisticalogica.Localidad;
import logisticalogica.Provincia;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraLocalidad {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    
    public List<Localidad> obtenerTodasLasLocalidades() {
        return controlpersis.obtenerTodasLasLocalidades();
    }
        public List<Localidad> obtenerLocalidadesPorProvincia(Provincia provincia) {
        return controlpersis.obtenerLocalidadesPorProvincia(provincia);
        }
}
