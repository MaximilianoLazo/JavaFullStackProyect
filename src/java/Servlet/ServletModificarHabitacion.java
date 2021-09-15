/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Logica.ControladoraLogica;
import Logica.Empleado;
import Logica.Habitacion;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletModificarHabitacion", urlPatterns = {"/ServletModificarHabitacion"})
public class ServletModificarHabitacion extends HttpServlet {

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
        int piso = Integer.parseInt(request.getParameter("piso"));
        Double precio = Double.parseDouble(request.getParameter("precio"));
        String categoria = request.getParameter("categoria");
        
                ControladoraLogica control = new ControladoraLogica();
                 Habitacion hab = control.BuscarHabitacion(id);
                 hab.setId_habitacion(id);
                 hab.setNombre(nombre);
                 hab.setTematica(categoria);
                 hab.setPrecio(precio);
                 hab.setPiso(piso);
                 
                 control.modificarHabitacion(hab);
                 
                 //Actualizar lista
                 request.getSession().setAttribute("listaHabitaciones", control.getListaHabitacion());
                 response.sendRedirect("listado_habitaciones.jsp");
                 
                 
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

        int id = Integer.parseInt(request.getParameter("id"));
        
        ControladoraLogica control = new ControladoraLogica();
        Habitacion habi = control.BuscarHabitacion(id);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("habitacion", habi);
        response.sendRedirect("modificar_habitacion.jsp");
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
