package lemmikkitietokanta.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lemmikkitietokanta.Models.Rotu;
import lemmikkitietokanta.Models.käyttäjä;
import lemmikkitietokanta.Models.lemmikki;
import static lemmikkitietokanta.Models.naytaJSP.naytaJSP;
import static lemmikkitietokanta.Models.naytaJSP.onKirjautunut;

/**
 *
 * @author Kim Martesuo
 */
public class MuokkaaLemmikkia extends HttpServlet {

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
            käyttäjä k = (käyttäjä)request.getSession().getAttribute("kirjautunut");
            //request.getAttribute("lemmikki");
            System.out.println("Muokataan");
            System.out.println(request.getParameter("lemmikinID"));
            lemmikki muokattavaLemmikki = lemmikki.getKayttajanLemmikki(k, request.getParameter("lemmikinID"));
            request.setAttribute("muokattavaLemmikki", muokattavaLemmikki);
            List<Rotu> rotuLista = Rotu.getRodut();
            request.setAttribute("rodut", rotuLista);
            naytaJSP("LemmikinMuokkaus.jsp", request, response);
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