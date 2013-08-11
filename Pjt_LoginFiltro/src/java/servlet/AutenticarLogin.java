package servlet;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vo.User;

public class AutenticarLogin extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");
            
            UserDAO dao = new UserDAO();
            
            User us = dao.verificarUsuarioHash(usuario, senha);
            
            if(us.getNome()!=null){
                
                HttpSession session = request.getSession(true);
                session.setAttribute("PjtLoginFiltroLogin", true);
                session.setAttribute("PjtLoginFiltro_name", us.getNome());
                session.setAttribute("PjtLoginFiltro_post", us.getCargo());
                response.sendRedirect("admin/logado.jsp");
                
            } else {
                response.sendRedirect("erroSenha.jsp");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AutenticarLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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