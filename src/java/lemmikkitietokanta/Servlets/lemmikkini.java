package lemmikkitietokanta.Servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lemmikkitietokanta.Models.käyttäjä;
import lemmikkitietokanta.Models.lemmikki;
import static lemmikkitietokanta.Models.naytaJSP.onKirjautunut;

/**
 *
 * @author Kim Martesuo
 */
public class lemmikkini extends HttpServlet {

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
        
        if(onKirjautunut(request, response)) {
            
        
        käyttäjä kirjautunut = (käyttäjä)request.getSession().getAttribute("kirjautunut");
        //if (kirjautunut != null) {
            request.setAttribute("kayttajaKirjautunut", kirjautunut.getUsername());
            List<lemmikki> lemmikit = lemmikki.getLemmikkini(kirjautunut.getUsername());
            //Mikäli käyttäjällä ei ole lemmikkejä.
            if(lemmikit.isEmpty()) {
                /*Virheviesti*/
                request.setAttribute("virheViesti", "Sinulla ei ole ainuttakaan lemmikkiä!"); 
            }
            //Asetetaan lemmikkilista näkymälle
            else {
                request.setAttribute("lemmikit", lemmikit);
            }
            
        //}
       
        /* Luodaan RequestDispatcher-olio, joka osaa näyttää Lemmikkini.jsp:n */
        RequestDispatcher dispatcher = request.getRequestDispatcher("Lemmikkini.jsp");
        /* Pyydetään dispatcher-oliota näyttämään JSP-sivunsa */
        dispatcher.forward(request, response);
        }
        else {response.sendRedirect("Index.jsp");}
        
        
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
