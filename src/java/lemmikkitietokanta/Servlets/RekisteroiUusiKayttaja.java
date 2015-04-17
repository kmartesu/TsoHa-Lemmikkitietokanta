package lemmikkitietokanta.Servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lemmikkitietokanta.Models.käyttäjä;
import static lemmikkitietokanta.Models.naytaJSP.naytaJSP;

/**
 *
 * @author Kim Martesuo
 */
public class RekisteroiUusiKayttaja extends HttpServlet {

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
        
            //Luodaan uusi käyttäjä
            käyttäjä uusiKayttaja = new käyttäjä();
            boolean epakelpoTunnus = false;
            List<käyttäjä> kaikkiKayttajat = käyttäjä.getKäyttäjät();
            System.out.println("Tarkistetaan onko kayttajatunnus jo olemassa...");
            for(käyttäjä k:kaikkiKayttajat) {
                if((k.getUsername()).trim().equals((request.getParameter("kayttajatunnus")).trim())) {
                    System.out.println("Kayttajatunnus on jo kaytossa.");
                    epakelpoTunnus = true;
                    break;
                }
            }
            if(!epakelpoTunnus) {
                System.out.println("Kayttajatunnus kelpaa.");
                //Asetetaan käyttäjän arvot
                uusiKayttaja.setKäyttäjätunnus(request.getParameter("kayttajatunnus"));
                uusiKayttaja.setEtunimi(request.getParameter("etunimi"));
                uusiKayttaja.setSukunimi(request.getParameter("sukunimi"));
                uusiKayttaja.setSähköposti(request.getParameter("sahkoposti"));
                uusiKayttaja.setPostinumero(Integer.parseInt(request.getParameter("postinumero")));

                //Salasanan varmistus
                String salasana = request.getParameter("salasana");
                String salasanaVarmistus = request.getParameter("varmistaSalasana");

                //Jos salasanat vastaavat, luo käyttäjä
                if(salasana.equals(salasanaVarmistus)) {
                    uusiKayttaja.setSalasana(salasana);
                    uusiKayttaja.lisaaKayttajaKantaan();
                    request.setAttribute("kayttajaLuotu", "Käyttäjä luotu onnistuneesti!");

                    //Ei voida käyttää näytäJSP metodia, koska kukaan ei ole vielä kirjautunut sisään.
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp"); 
                    dispatcher.forward(request, response);
                }
                //Muuten lähetä takaisin sivulle
                else {
                    request.setAttribute("salasanatEiTasmaa", "Salasanat eivät täsmää!");
                    naytaJSP("Rekisteroidy.jsp", request, response);
                }
            }
            else {
                request.setAttribute("kayttajatunnusEiVapaa", "Käyttäjätunnus on jo käytössä! Valitse toinen.");
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
