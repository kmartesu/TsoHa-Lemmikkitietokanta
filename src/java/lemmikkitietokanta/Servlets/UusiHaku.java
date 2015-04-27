package lemmikkitietokanta.Servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lemmikkitietokanta.Models.lemmikki;
import static lemmikkitietokanta.Models.naytaJSP.onKirjautunut;

/**
 *
 * @author Kim Martesuo
 */
public class UusiHaku extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //Tällä servletillä haetaan tulokset hakusanoilla lemmikkiluokan kautta
    //ja lähetetään parametreina tulos-sivulle
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if(onKirjautunut(request, response)) {
            
            String hakusana = request.getParameter("hakusana").trim();
            
            if(hakusana.length() == 0) {
                request.setAttribute("virheViesti", "Haku ei tuottanut yhtään tulosta. Tarkista hakusana!");
            }
            else {
                List<lemmikki> lemmikkiHakuNimella = lemmikki.haeLemmikitHakusanalla(hakusana);
                List<lemmikki> lemmikkiHakuPostinumerolla = lemmikki.haeLemmikitPostinumerolla(hakusana);
                List<lemmikki> lemmikkiHakuRodulla = lemmikki.haeLemmikkiRodulla(hakusana);
                
                //Mikäli ei saatu yhtään tulosta
                if(lemmikkiHakuNimella.isEmpty() && lemmikkiHakuPostinumerolla.isEmpty() && lemmikkiHakuRodulla.isEmpty()) {
                    request.setAttribute("virheViesti", "Haku ei tuottanaut yhtään tulosta!");
                }
                else {
                    //IF-ehtolauseita, mikäli tulokset ovat tyhjiä, esim. postinumerohaku ei tuota tulosta, mutta nimihaku tuottaa
                    if(!lemmikkiHakuNimella.isEmpty()) {
                        request.setAttribute("lemmikitHaullaViesti", "Lemmikit nimellä:");
                        request.setAttribute("lemmikitHaulla", lemmikkiHakuNimella);
                    }
                    if(!lemmikkiHakuPostinumerolla.isEmpty()) {
                        request.setAttribute("lemmikitPostinumeroHaullaViesti", "Lemmikit postinumerohaulla:");
                        request.setAttribute("lemmikitPostinumeroHaulla", lemmikkiHakuPostinumerolla);
                    }
                    if(!lemmikkiHakuRodulla.isEmpty()) {
                        request.setAttribute("lemmikitRotuHaullaViesti", "Lemmikit rotuhaulla:");
                        request.setAttribute("lemmikitRotuHaulla", lemmikkiHakuRodulla);
                    }
                }
            }
            
            /* Luodaan RequestDispatcher-olio, joka osaa näyttää Lemmikkini.jsp:n */
            RequestDispatcher dispatcher = request.getRequestDispatcher("Haku.jsp");
            /* Pyydetään dispatcher-oliota näyttämään JSP-sivunsa */
            dispatcher.forward(request, response);
        }
        else {response.sendRedirect("Index.jsp");}
    }
    
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
