/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Logica.ControladoraLogica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maxi
 */
@WebServlet(name = "ServletAltaReserva", urlPatterns = {"/ServletAltaReserva"})
public class ServletAltaReserva extends HttpServlet {

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
        processRequest(request, response);
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
//        processRequest(request, response);

            String fecha_actual = request.getParameter("fecha_actual");
            String fecha_inicio = request.getParameter("fecha_inicio");
            String fecha_fin = request.getParameter("fecha_fin");
            Double monto = Double.parseDouble(request.getParameter("monto"));
            int usuario = Integer.parseInt(request.getParameter("usuarioseleccionado"));
            int habitacion = Integer.parseInt(request.getParameter("hab"));
            int cliente = Integer.parseInt(request.getParameter("cli"));
            
            request.getSession().setAttribute("fecha_actual", fecha_actual);
            request.getSession().setAttribute("fecha_inicio", fecha_inicio);
            request.getSession().setAttribute("fecha_fin", fecha_fin);
            
            request.getSession().setAttribute("monto", monto);
            request.getSession().setAttribute("cli", cliente);
            request.getSession().setAttribute("usuarioseleccionado", usuario);
            request.getSession().setAttribute("hab", habitacion);
            
            ControladoraLogica control = new ControladoraLogica();
            control.crearReserva(fecha_actual,fecha_inicio,fecha_fin,monto,cliente,habitacion,usuario);
            response.sendRedirect("Menu.jsp");
            
            
            
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
