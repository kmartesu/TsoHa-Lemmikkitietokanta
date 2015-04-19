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
 * Malliluokka käyttäjille
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
    
    //Metodi joka poistaa käyttäjän kannasta
    public void poistaKayttajaKannasta() {
        try {
            System.out.println("Poistetaan kayttaja kannasta...");
            
            String sql = "DELETE FROM käyttäjä WHERE käyttäjätunnus = ?";
            Connection yhteys = Tietokantayhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            
            kysely.setString(1, this.getUsername());
            kysely.executeQuery();
            System.out.println("Kayttaja poistettu kannasta onnistuneesti.");
            
            //Sulje yhteydet
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(käyttäjä.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Metodi joka päivittää käyttäjän tiedot kannassa
    public void paivitaKayttajaKannassa() {
        
        System.out.println("Päivitetään käyttäjän tiedot kannassa...");
        try {
            String sql = "UPDATE käyttäjä SET etunimi = ?, sukunimi = ?, postinumero = ?, sähköposti = ? "
                    + "WHERE käyttäjätunnus = ? ";
            Connection yhteys = Tietokantayhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            
            kysely.setString(1, this.getEtunimi());
            kysely.setString(2, this.getSukunimi());
            kysely.setInt(3, this.getPostinumero());
            kysely.setString(4, this.getSahkoposti());
            kysely.setString(5, this.getUsername());
            
            kysely.executeQuery();
            System.out.println("Käyttäjä päivitetty onnistnuneesti.");
            
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(käyttäjä.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void lisaaKayttajaKantaan() {
        //Tällä metodilla lisätään käyttäjä kantaan.
        System.out.println("Aloitetaan käyttäjän lisääminen kantaan...");
        try {    
            String sql = "INSERT INTO käyttäjä VALUES"
                    + "(?,?,?,?,?,?,?)";
            Connection yhteys = Tietokantayhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            
            kysely.setString(1, this.getUsername());
            kysely.setString(2, this.getSalasana());
            kysely.setString(3, this.getEtunimi());
            kysely.setString(4, this.getSalasana());
            kysely.setString(5, this.getSahkoposti());
            long time = System.currentTimeMillis();
            java.sql.Timestamp aikaLeima = new java.sql.Timestamp(time);
            kysely.setTimestamp(6, aikaLeima);
            kysely.setInt(7, this.getPostinumero());
            
            kysely.executeQuery();
            System.out.println("SQL-lause suoritettu...");
            
            //Sulje yhteydet
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
            
        } catch (SQLException ex) {
            Logger.getLogger(käyttäjä.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static käyttäjä getTiettyKayttaja(String tunnus) {
        //Tällä metodilla haetaan tietyn käyttäjän tiedot kannasta pelkällä käyttäjätunnuksella
        käyttäjä tempKayttaja = new käyttäjä();
        try {
            System.out.println("Haetaan käyttäjän tiedot kannasta...");
            
            Connection yhteys = Tietokantayhteys.getYhteys();
            String sql = "select käyttäjä.etunimi, käyttäjä.sukunimi, käyttäjä.sähköposti, käyttäjä.salasana "
                    + "from käyttäjä "
                    + "where käyttäjä.käyttäjätunnus = ?";
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            
            kysely.setString(1, tunnus);
            ResultSet rs = kysely.executeQuery();
            
            while(rs.next()) {
                tempKayttaja.setEtunimi(rs.getString("etunimi"));
                tempKayttaja.setSukunimi(rs.getString("sukunimi"));
                tempKayttaja.setSähköposti(rs.getString("sähköposti"));
                tempKayttaja.setSalasana(rs.getString("salasana"));
            }
            
            
            //Sulje yhteydet
            try { rs.close(); } catch (Exception e) {}
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(käyttäjä.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tempKayttaja;
    }
    
    
    public static List<käyttäjä> getKäyttäjät() {
        //Tällä metodilla haetaan kaikki käyttäjät kannasta ja palautetaan listana
        System.out.println("Haetaan käyttäjät...");
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
    
    
    //Getterit
    public String getUsername() {
        return käyttäjätunnus;
    }
    public String getSalasana() {
        return salasana;
    }
    public String getEtunimi() {
        return etunimi;
    }
    public String getSukunimi() {
        return sukunimi;
    }
    public String getSahkoposti() {
        return sähköposti;
    }
    public int getPostinumero() {
        return postinumero;
    }
    
    //Setterit
    public void setKäyttäjätunnus(String käyttäjätunnus) {
        this.käyttäjätunnus = käyttäjätunnus;
    }
    public void setSalasana(String salasana) {
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
