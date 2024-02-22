/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import java.util.List;
import logisticalogica.RolUsuario;
import logisticalogica.Usuario;
import logisticapersistencia.ControladoraPersistencia;

/**
 *
 * @author ULTRA
 */
public class ControladoraRolUsuario {
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
   
    public List<RolUsuario> obtenerTodosLosRoles() {
        return controlpersis.obtenerTodosLosRoles();
    }
}
    

