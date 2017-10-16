package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {

    /**
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private final String JNDI_PORTABLE_NAME_FOR_ACCOUNT_FACADE = "java:global/Client/AccountFacade";
    //@EJB
    //Account account;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
                    out.println("<head>");
                        out.println("<title>TFG 2017 Mario Segura</title>");            
                    out.println("</head>");
                out.println("<body>");
                    out.println("<h1>Distribución de Entrenamientos</h1>");
                    out.println("<div>");
                        out.println("<form action=Login method=post>");
                        //out.println("Nombre:<br>" +
//"<input type=\"text\" name=\"name\" value=><br>Contraseña:<br><input type=password name=pass><br><br>");
                        out.println("<input type=\"submit\" value=\"Login\"></form>");
                    out.println("</div>");
                    
                    out.println("<br>");
                    
                    out.println("<div>");
                        out.println("<form action=Register method=post>");
                        //out.println("Nombre:<br>" +
//"<input type=\"text\" name=\"name\" value=><br>Contraseña:<br><input type=password name=pass1>"
                                //+ "<br>Repita la Contraseña:<br><input type=password name=pass2><br><br>");
                        out.println("<input type=\"submit\" value=\"Register\"></form>");
                    out.println("</div>");
                    
                    out.println("<br>");
                    
                    out.println("<div>");
                        out.println("<form action=Training method=post>");
                            out.println("<input type=\"submit\" value=\"Entrenamientos\"></form>");
                        out.println("</form>");
                    out.println("</div>");
                    
                out.println("</body>");
            out.println("</html>");
        } catch (MalformedURLException | RemoteException ex) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
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
