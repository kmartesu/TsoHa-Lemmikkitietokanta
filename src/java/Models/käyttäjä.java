package Models;


import Models.Tietokantayhteys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Kim Martesuo
 */
public class käyttäjä {
    private String käyttäjätunnus;
    private String salasana;
    private String etunimi;
    private String sukunimi;
    private String sähköposti;
    private int postinumero;
    
    public käyttäjä(String käyttäjätunnus,String salasana,String etunimi,String sukunimi,String sähköposti,int postinumero) {
        this.käyttäjätunnus = käyttäjätunnus;
        this.salasana = salasana;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.sähköposti = sähköposti;
        this.postinumero = postinumero;
    }
    
    public String getUsername() {
        return käyttäjätunnus;
    }
    
    public static List<käyttäjä> getKäyttäjät() {
        System.out.println("get käyttäjät");
        ArrayList<käyttäjä> käyttäjät = new ArrayList<>();
        try {
            Connection yhteys = Tietokantayhteys.getYhteys();
            String sql = "select * from käyttäjä";
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet rs = kysely.executeQuery();
            
            while(rs.next()) {
                String käyttäjätunnus = rs.getString("käyttäjätunnus");
                String etunimi = rs.getString("etunimi");
                String sukunimi = rs.getString("sukunimi");
                String salasana = rs.getString("salasana");
                String sähköposti = rs.getString("sähköposti");
                int postinumero = rs.getInt("postinumero");
                
                käyttäjä k = new käyttäjä(käyttäjätunnus, salasana, etunimi, sukunimi, sähköposti, postinumero);
                
                käyttäjät.add(k);
            }
            try { rs.close(); } catch (Exception e) {}
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(käyttäjä.class.getName()).log(Level.SEVERE, null, ex);
        }
     return käyttäjät;   
    }
}
