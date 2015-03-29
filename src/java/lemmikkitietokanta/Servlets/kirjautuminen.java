package lemmikkitietokanta.Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lemmikkitietokanta.Models.käyttäjä;
import static lemmikkitietokanta.Models.käyttäjä.etsiKayttajaTunnuksilla;
import static lemmikkitietokanta.Models.naytaJSP.asetaVirhe;
import static lemmikkitietokanta.Models.naytaJSP.naytaJSP;


/**
 *
 * @author Kim Martesuo
 */
public class kirjautuminen extends HttpServlet {

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
        
        String salasana = request.getParameter("Salasana");
        String kayttaja = request.getParameter("Kayttajatunnus");
        
        käyttäjä kirjautuja = null;
        
        try {
            /*Tarkistetaan onko tunnukset oikeat*/
            kirjautuja = käyttäjä.etsiKayttajaTunnuksilla(kayttaja, salasana);
        } catch (SQLException ex) {
            Logger.getLogger(kirjautuminen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(kirjautuja != null) {
                /*Jos oikea tunnus, ohjataan käyttäjä lemmikkitietokantaan*/
                HttpSession session = request.getSession();
                //käyttäjä sessioKayttaja = etsiKayttajaTunnuksilla(kirjautuja.getUsername(), request.getParameter("salasana"));
                //Tallennetaan istuntoon käyttäjäolio
                session.setAttribute("kirjautunut", kirjautuja);
                //response.sendRedirect("KirjautuneenEtusivu");
                naytaJSP("Etusivu.jsp", request, response);
        }
        else if(salasana == null || kayttaja == null) {
            naytaJSP("Index.jsp", request, response);
            
        }
        else if(kayttaja == null || kayttaja.equals("")) {
            asetaVirhe("Kirjautuminen epäonnistui! Et antanut käyttäjätunnusta!", request);
            naytaJSP("Index.jsp", request, response);
        }
        else if(salasana == null || salasana.equals("")) {
            asetaVirhe("Kirjautuminen epäonnistui! Et antanut salasanaa!", request);
            naytaJSP("Index.jsp", request, response);
        }
        else {
            /*Jos väärä tunnus*/
            asetaVirhe("Kirjautuminen epäonnistui! Antamasi käyttäjätunnus tai salasana on väärä.", request);
            naytaJSP("Index.jsp", request, response);
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
