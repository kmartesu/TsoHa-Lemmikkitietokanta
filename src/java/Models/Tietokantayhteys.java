package Models;


/**
 *
 * @author Kim Martesuo
 */

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Tietokantayhteys {

    
//Haetaan context-xml-tiedostosta tietokannan yhteystiedot
//HUOM! Tämä esimerkki ei toimi sellaisenaan ilman Tomcat-palvelinta!
//private static DataSource yhteysVarasto;

    public static Connection getYhteys() throws SQLException {
        DataSource yhteysVarasto = null;
        try {
        InitialContext cxt = new InitialContext();
        yhteysVarasto = (DataSource) cxt.lookup("java:/comp/env/jdbc/tietokanta");
    } catch (NamingException ex) {
        Logger.getLogger(Tietokantayhteys.class.getName()).log(Level.SEVERE, null, ex);
    }
        System.out.println("getting connection...");
        
        return yhteysVarasto.getConnection();
    }
}
