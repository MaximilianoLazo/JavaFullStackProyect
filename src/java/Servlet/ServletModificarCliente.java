/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Logica.Cliente;
import Logica.ControladoraLogica;
import static Logica.ControladoraLogica.deStringToDate;
import Logica.Habitacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maxi
 */
@WebServlet(name = "ServletModificarCliente", urlPatterns = {"/ServletModificarCliente"})
public class ServletModificarCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String dni = request.getParameter("dni");
        String direccion = request.getParameter("direccion");
        String profesion = request.getParameter("profesion");
        String fecha = request.getParameter("fecha");

        
                ControladoraLogica control = new ControladoraLogica();
                 Cliente cli = control.BuscarCliente(id);
                 cli.setId_cliente(id);
                 cli.setNombre(nombre);
                 cli.setApellido(apellido);
                 cli.setDni(dni);
                 cli.setDireccion(direccion);
                 cli.setProfesion(profesion);
                 Date fechaNacimiento = deStringToDate(fecha);
                 cli.setFecha_nacimiento(fechaNacimiento);
                 
                 control.modificarCliente(cli);
                 
                 //Actualizar lista
                 request.getSession().setAttribute("listaClientes", control.getListaClientes());
                 response.sendRedirect("listado_cliente.jsp");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        ControladoraLogica control = new ControladoraLogica();
        Cliente cli = control.BuscarCliente(id);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("cliente", cli);
        response.sendRedirect("modificar_cliente.jsp");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
