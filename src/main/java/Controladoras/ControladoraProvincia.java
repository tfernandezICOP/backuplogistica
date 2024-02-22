/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.List;
import logisticalogica.Provincia;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraProvincia {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    public List<Provincia> obtenerTodasLasProvincias() {
        return controlpersis.obtenerTodasLasProvincias();
    }
}
