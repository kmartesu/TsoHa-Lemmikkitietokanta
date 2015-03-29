package lemmikkitietokanta.Models;


import lemmikkitietokanta.Models.Tietokantayhteys;
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
    
    public käyttäjä() {
    }
    
    public String getUsername() {
        return käyttäjätunnus;
    }
    
    public static List<käyttäjä> getKäyttäjät() {
        System.out.println("get käyttäjät");
        ArrayList<käyttäjä> käyttäjät = new ArrayList<käyttäjä>();
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
                
                käyttäjä k = new käyttäjä();
                k.setKäyttäjätunnus(käyttäjätunnus);
                k.setEtunimi(etunimi);
                k.setSukunimi(sukunimi);
                k.setSalasana(salasana);
                k.setSähköposti(sähköposti);
                k.setPostinumero(postinumero);
                
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
    
    public static käyttäjä etsiKayttajaTunnuksilla(String kayttaja, String salasana) throws SQLException {
        String sql = "SELECT käyttäjätunnus, salasana from käyttäjä where käyttäjätunnus = ? AND salasana = ?";
        Connection yhteys = Tietokantayhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, kayttaja);
        kysely.setString(2, salasana);
        ResultSet rs = kysely.executeQuery();
        //Alustetaan muuttuja, joka sisältää löydetyn käyttäjän
        käyttäjä kirjautunut = null;

        //next-metodia on kutsuttava aina, kun käsitellään 
        //vasta kannasta saatuja ResultSet-olioita.
        //ResultSet on oletuksena ensimmäistä edeltävällä -1:llä rivillä.
        //Kun sitä kutsuu ensimmäisen kerran siirtyy se ensimmäiselle riville 0.
        //Samalla metodi myös palauttaa tiedon siitä onko seuraavaa riviä olemassa.
        if (rs.next()) { 
          //Kutsutaan sopivat tiedot vastaanottavaa konstruktoria 
          //ja asetetaan palautettava olio:
          kirjautunut = new käyttäjä();
          kirjautunut.setKäyttäjätunnus(rs.getString("käyttäjätunnus"));
          kirjautunut.setSalasana(rs.getString("salasana"));
        }

        //Jos kysely ei tuottanut tuloksia käyttäjä on nyt vielä null.

        //Suljetaan kaikki resurssit:
        try { rs.close(); } catch (Exception e) {}
        try { kysely.close(); } catch (Exception e) {}
        try { yhteys.close(); } catch (Exception e) {}

        //Käyttäjä palautetaan vasta täällä, kun resurssit on suljettu onnistuneesti.
        return kirjautunut;
    }

    public void setKäyttäjätunnus(String käyttäjätunnus) {
        System.out.println(käyttäjätunnus);
        this.käyttäjätunnus = käyttäjätunnus;
    }
    public void setSalasana(String salasana) {
        System.out.println(salasana);
        this.salasana = salasana;
    }
    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }
    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }
    public void setSähköposti(String sähköposti) {
        this.sähköposti = sähköposti;
    }
    public void setPostinumero(int postinumero) {
        this.postinumero = postinumero;
    }
}
