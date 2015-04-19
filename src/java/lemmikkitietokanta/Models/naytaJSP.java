package lemmikkitietokanta.Models;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Tämä luokka sisältää muutaman staattisen metodin
 * @author Kim Martesuo
 */
public class naytaJSP extends HttpServlet{
    
    public naytaJSP() {}
    
    //Metodi joka asettaa seuraavan sivun näytettäväksi
    public static void naytaJSP(String sivu, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        response.setContentType("text/html;charset=UTF-8");
        
        
        käyttäjä kirjautunut = (käyttäjä)request.getSession().getAttribute("kirjautunut");
        
        if (kirjautunut != null) {
            request.setAttribute("kayttajaKirjautunut", kirjautunut.getUsername());
        }
        
        /* Luodaan RequestDispatcher-olio, joka osaa näyttää Index.jsp:n */
        RequestDispatcher dispatcher = request.getRequestDispatcher(sivu);
        /* Pyydetään dispatcher-oliota näyttämään JSP-sivunsa */
        dispatcher.forward(request, response);
        
        
    }
    
    //Asettaa virheilmoituksia sivulle
    public static void asetaVirhe(String virheViesti, HttpServletRequest request) {
        request.setAttribute("virheViesti", virheViesti);  
    }
    
    //Metodi joka tarkistaa onko käyttäjä kirjautunut
    public static boolean onKirjautunut(HttpServletRequest request, HttpServletResponse response) {
        käyttäjä k = (käyttäjä)request.getSession().getAttribute("kirjautunut");
        if(k == null) {return false;}
        else {return true;}
    }
}