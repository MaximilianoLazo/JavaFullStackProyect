
package Persistencia;

import Logica.Cliente;
import Logica.Empleado;
import Logica.Habitacion;
import Logica.Reserva;
import Logica.Usuario;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    ClienteJpaController cliJPA = new ClienteJpaController();
    EmpleadoJpaController empJPA = new EmpleadoJpaController();
    HabitacionJpaController habJPA = new HabitacionJpaController();
    ReservaJpaController resJPA = new ReservaJpaController();

    public void crearHabitacion(Habitacion hab) {
        habJPA.create(hab);
        
    }

    public void crearEmpleado(Empleado emple) {
        empJPA.create(emple);
    }

    public void crearCliente(Cliente cl) {
        cliJPA.create(cl);
    }

   public List<Usuario> getUsuarios() {
        List <Usuario> listaUsuarios;
        listaUsuarios = usuJPA.findUsuarioEntities();
        
        return listaUsuarios;
    }
   
     public List<Habitacion> getHabitaciones() {
        List <Habitacion> listaHabitaciones;
        listaHabitaciones = habJPA.findHabitacionEntities();
        
        return listaHabitaciones;
    }

    public void borrarHabitacion(int id) {
        try {
            habJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    public Habitacion BuscarHabitacion(int id) {
        return habJPA.findHabitacion(id);
    }

    public void modificarHabitacion(Habitacion hab) {
        try {
            habJPA.edit(hab);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> getClientes() {
        List <Cliente> listaClientes;
        listaClientes = cliJPA.findClienteEntities();
        
        return listaClientes;
    }

    public List<Empleado> getEmpleados() {
        List <Empleado> listaEmpleados;
        listaEmpleados = empJPA.findEmpleadoEntities();
        
        return listaEmpleados;
    }

    public void borrarCliente(int id) {
        try {
            cliJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearEmpleado(Usuario usu) {
            usuJPA.create(usu);
    }

    public void crearReserva(Reserva res) {
        resJPA.create(res);
    }

    public Cliente BuscarCliente(int id) {
        return cliJPA.findCliente(id);
}

    public void modificarCliente(Cliente cli) {
        try {
            cliJPA.edit(cli);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Reserva> getReservas() {
         List <Reserva> listaReservas;
         
         listaReservas = resJPA.findReservaEntities();
        
        return listaReservas;
    }
    
}