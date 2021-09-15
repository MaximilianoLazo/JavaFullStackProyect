/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ControladoraPersistencia;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Maxi
 */
public class ControladoraLogica {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    private List <Usuario> listaUsuarios;
    private List <Habitacion> listaHabitaciones;
    private List <Cliente> listaClientes;
    private List <Reserva> listaReservas;
    
    
     public static synchronized java.util.Date deStringToDate(String fecha) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy"); //formato guión
        Date fechaEnviar = null;
        try {
            fechaEnviar = df.parse(fecha);
            return fechaEnviar;
        } catch (ParseException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public void crearHabitacion(String nombre, int piso, Double precio, String categoria) {
        Habitacion hab = new Habitacion();
        hab.setNombre(nombre);
        hab.setPiso(piso);
        hab.setPrecio(precio);
        hab.setTematica(categoria);
        
        
        controlPersis.crearHabitacion(hab);
    }

    public void crearEmpleado(String nombre, String apellido, String dni, String direccion, String cargo, String fecha, String usuario, String contra) {
        Empleado emple = new Empleado();
        emple.setApellido(apellido);
        emple.setNombre(nombre);
        emple.setDni(dni);
        emple.setDire(direccion);
        emple.setCargo(cargo);
        Date fechaNacimiento = deStringToDate(fecha);
        emple.setFecha_nacimiento(fechaNacimiento);
        Usuario usu = new Usuario();
        usu.setUsuario(usuario);
        usu.setContra(contra);
        usu.setEmp(emple);
        
        
        
        controlPersis.crearEmpleado(usu);
    }

    public void crearCliente(String nombre, String apellido, String dni, String direccion, String profesion, String fecha) {
        Cliente cl = new Cliente();
        cl.setNombre(nombre);
        cl.setApellido(apellido);
        cl.setDni(dni);
        cl.setDireccion(direccion);
        cl.setProfesion(profesion);
        Date fechaNacimiento = deStringToDate(fecha);
        cl.setFecha_nacimiento(fechaNacimiento);
        
        controlPersis.crearCliente(cl);
    }

    public boolean comprobarIngreso(String usuario, String password) {
        
        boolean siONo = false;
        
        listaUsuarios = controlPersis.getUsuarios();
        
        for (Usuario usu : listaUsuarios) {
            if (usu.getUsuario().equals(usuario) && usu.getContra().equals(password)) {
                siONo= true;
                return siONo;
            }
        }
        return siONo;
    }

     public List <Usuario> getListaUsuarios(){
        
    
        return controlPersis.getUsuarios();
    }
     public List <Reserva> getListaReservas(){
        
    
        return controlPersis.getReservas();
    }
       public List <Cliente> getListaClientes(){
        
    
        return controlPersis.getClientes();
    }
     public List <Empleado> getListaEmpleados(){
        
    
        return controlPersis.getEmpleados();
    }
     public List <Habitacion> getListaHabitacion(){
        
        return controlPersis.getHabitaciones();
    }

    public void borrarHabitacion(int id) {
        controlPersis.borrarHabitacion(id);
    }

    public Habitacion BuscarHabitacion(int id) {
        
       return controlPersis.BuscarHabitacion(id);
//       https://www.youtube.com/watch?v=oRLF2edX_gk
    }

    public void modificarHabitacion(Habitacion hab) {
        controlPersis.modificarHabitacion(hab);
    }

    public void borrarCliente(int id) {
        
        controlPersis.borrarCliente(id);
    }

    public void crearReserva(String fecha_actual, String fecha_inicio, String fecha_fin, Double monto, int id_cliente, int id_habitacion, int id_usuario) {
        Reserva res = new Reserva();
        
        Date fechaActual = deStringToDate(fecha_actual);
        res.setFechaActual(fechaActual);
        Date fechaInicio = deStringToDate(fecha_inicio);
        res.setFecha_inicio(fechaInicio);
        Date fechaFin = deStringToDate(fecha_fin);
        res.setFecha_fin(fechaFin);
        res.setMonto(monto);
        res.setId_cliente(id_cliente);
        res.setId_habitacion(id_habitacion);
        res.setId_usuario(id_usuario);
        
        controlPersis.crearReserva(res);
    }

    public Cliente BuscarCliente(int id) {
        return controlPersis.BuscarCliente(id);
    }

    public void modificarCliente(Cliente cli) {
        controlPersis.modificarCliente(cli);
    }

    
}