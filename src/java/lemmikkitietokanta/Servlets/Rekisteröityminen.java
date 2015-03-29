package lemmikkitietokanta.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static lemmikkitietokanta.Models.naytaJSP.asetaVirhe;
import static lemmikkitietokanta.Models.naytaJSP.naytaJSP;

/**
 *
 * @author Kim Martesuo
 */
public class Rekisteröityminen extends HttpServlet {

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
        
        String kayttajatunnus = request.getParameter("kayttajatunnus");
        String etunimi = request.getParameter("etunimi");
        String sukunimi = request.getParameter("sukunimi");
        String sahkoposti = request.getParameter("sahkoposti");
        int postinumero = request.getIntHeader("postinumero");
        String salasana = request.getParameter("salasana");
        String varmistaSalasana = request.getParameter("varmistaSalasana");
        
        if(!salasana.equals(varmistaSalasana)) {
            asetaVirhe("Salasanat eivät täsmää!", request);
            naytaJSP("Rekisteroidy.jsp", request, response);
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
