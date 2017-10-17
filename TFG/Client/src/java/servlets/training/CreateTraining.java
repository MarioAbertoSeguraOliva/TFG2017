package servlets.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlets.Training;
import session.TrainingFacadeLocal;

public class CreateTraining extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    TrainingFacadeLocal training;
    private final String jndi_path = "java:global/Client/TrainingFacade!session.TrainingFacadeLocal";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateTraining</title>");            
            out.println("</head>");
            out.println("<body>");
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String today = dateFormat.format(new Date());
            
            java.util.Date date;
            java.sql.Date sqlDate;
            
            if (request.getParameter("trainingDate") != null& 
                request.getParameter("training")!= null     &
                request.getParameter("recipient")!= null)   {
                try {
                    training = (TrainingFacadeLocal) InitialContext.doLookup(jndi_path);
                    entity.Training tr = new entity.Training();
                    date = new Date();
                    sqlDate = new java.sql.Date(date.getTime());
                    tr.setCoach("Manolo");
                    tr.setCreationDate(sqlDate);
                    tr.setRecipient(request.getParameter("recipient"));
                    tr.setTraining(request.getParameter("training"));
                    out.println(tr.toString());
                    training.create(tr);
                } catch (NamingException ex) {
                    Logger.getLogger(Training.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                out.println(request.getParameter("trainingDate"));
                out.println(request.getParameter("training"));
                out.println(request.getParameter("recipient"));
                out.println("FORM OK");
            }else{
                out.println("FORM NOT OK");
            }
            out.println("<div>");
            out.println("<form>");
            out.println("Fecha de Hoy:"+today+" <input type=date name=trainingDate value="+today+"/><br><br>");
            out.println("Entreno: <textarea name=training placeholder=\"Esto es un prueba de entreno piloto\"></textarea> <br><br>");
            out.println("Entrenador: Juan Ramirez<input type=text><br><br>");
            out.println("Atletas: {Grupo1}, Alex, Fran, Esteban, Melisa<input name=recipient type=text><br><br>");
            out.println("<input type=\"submit\" value=\"Enviar\"><br>");
            out.println("</form>");
            out.println("</div>");
            
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
