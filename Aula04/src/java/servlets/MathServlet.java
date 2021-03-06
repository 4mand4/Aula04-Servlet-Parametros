/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author amand
 */
@WebServlet(name = "MathServlet", urlPatterns = {"/mathservlet.html"})
public class MathServlet extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String error = null;
            int n1 = 0;
            int n2 = 0;
            int res = 0;
            int select = 0;
            try {
                String p = request.getParameter("n1");
                String r = request.getParameter("n2");
                String o = request.getParameter("operacao");
                n1 = Integer.parseInt(p);
                n2 = Integer.parseInt(r);
                select = Integer.parseInt(o);
            } catch (Exception e) {
                error = e.getMessage();
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Math Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h3><a href='index.html'>Voltar</a></h3>");
            out.println("<h2>JavaEE</h1>");
            out.println("<h2>Opera????o Aritm??tica</h1>");
            if (error != null) {
                out.println("<span style='color:red'>Erro ao tentar ler par??metros</span>");
            } else {
                if (select == 1) {
                    res = n1 + n2;
                } else if (select == 2) {
                    res = n1 - n2;
                } else if (select == 3) {
                    res = n1 * n2;
                } else {
                    res = n1 / n2;
                }
                out.println("Resultado: " + res);
            }
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
