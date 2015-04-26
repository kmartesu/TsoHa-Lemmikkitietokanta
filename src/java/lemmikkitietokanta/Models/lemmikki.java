package lemmikkitietokanta.Models;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Malliluokka lemmikeille
 * @author Kim Martesuo
 */
public class lemmikki {

    
    
    public int lemmikkiID;
    private String nimi;
    private String vari;
    private int ika;
    private String kuvaus;
    private Image kuva;
    private String omistaja;
    private int rotuID;
    private List<String> virheet = new ArrayList<String>();
    
    public lemmikki() {}
    
    //Metodi jolla haetaan lemmikit tietyllä nimellä
    public static List<lemmikki> haeLemmikitHakusanalla(String hakusana) {
        //Ei vielä implementoitu
        return null;
    }
    
    //Metodi joka poistaa lemmikin kannasta
    public void poistaLemmikkiKannasta() {
            System.out.println("Poistetaan lemmikki kannasta...");
        try {
            String sql = "DELETE FROM lemmikki WHERE lemmikkiID = ?";
            Connection yhteys = Tietokantayhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            
            kysely.setInt(1, this.getLemmikkiID());
            kysely.executeQuery();
            System.out.println("Lemmikki poistettu onnistuneesti.");
            
            //Sulje yhteydet
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(lemmikki.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Metodi joka päivittää lemmikin tiedot kannassa
    public void paivitaLemmikkiKannassa() {
        try { 
            System.out.println("Muokataan lemmikkiä...");
            String sql = "UPDATE lemmikki SET nimi = ?, väri = ?, ikä = ?, kuvaus = ?, rotuID = ? "
                    + "WHERE lemmikkiID = ?";
            Connection yhteys = Tietokantayhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            kysely.setString(1, this.getNimi());
            kysely.setString(2, this.getVari());
            kysely.setInt(3, this.getIka());
            kysely.setString(4, this.getKuvaus());
            kysely.setInt(5, this.getRotuID());
            kysely.setInt(6, this.getLemmikkiID());
            
            kysely.executeQuery();
            System.out.println("Lemmikki muokattu onnistuneesti.");
            
            //Sulje yhteydet
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(lemmikki.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodi joka lisää lemmikin kantaan
    public void lisaaLemmikkiKantaan() {
        try { 
            System.out.println("Luodaan lemmikki...");
            String sql = "INSERT INTO lemmikki (nimi, väri, ikä, kuvaus, käyttäjätunnus, rotuID) VALUES"
                    + "(?,?,?,?,?,?) RETURNING lemmikkiID";
            
            Connection yhteys = Tietokantayhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            
            kysely.setString(1, this.getNimi());
            kysely.setString(2, this.getVari());
            kysely.setInt(3, this.getIka());
            kysely.setString(4, this.getKuvaus());
            kysely.setString(5, this.getOmistaja());
            kysely.setInt(6, this.getRotuID());
            
            ResultSet ids = kysely.executeQuery();
            System.out.println("SQL-lause suoritettu.");
            ids.next();
            this.lemmikkiID = ids.getInt(1);
            //Sulje yhteydet
            try { ids.close(); } catch (Exception e) {}
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(lemmikki.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Metodi joka palauttaa käyttänä tietyn lemmikin
    public static lemmikki getKayttajanLemmikki(käyttäjä k, String lemmikinID) {
        lemmikki L = new lemmikki();
        try {
            System.out.println("Hateaan muokattava lemmikki kannasta...");
            
            Connection yhteys = Tietokantayhteys.getYhteys();
            String sql = "select lemmikki.lemmikkiID, lemmikki.nimi, lemmikki.väri, lemmikki.ikä, lemmikki.kuvaus, lemmikki.rotuID "
                    + "from lemmikki, käyttäjä "
                    + "where käyttäjä.käyttäjätunnus = ? and lemmikki.lemmikkiID = ? and lemmikki.käyttäjätunnus = käyttäjä.käyttäjätunnus";
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            
            kysely.setString(1, k.getUsername());
            kysely.setInt(2, Integer.parseInt(lemmikinID));
            ResultSet rs = kysely.executeQuery();
            
            while(rs.next()) {
                L.setLemmikkiID(rs.getInt("lemmikkiID"));
                L.setNimi(rs.getString("nimi"));
                L.setVari(rs.getString("väri"));
                L.setIka(rs.getInt("ikä"));
                L.setKuvaus(rs.getString("kuvaus"));
                L.setKuva(null);
                L.setOmistaja(k.getUsername());
                L.setRotuID(rs.getInt("rotuID"));
            }
            
            
            //Sulje yhteydet
            try { rs.close(); } catch (Exception e) {}
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(lemmikki.class.getName()).log(Level.SEVERE, null, ex);
        }
        return L;
    }
    
    //Metodi joka palauttaa käyttäjän lemmikit
    public static List<lemmikki> getLemmikkini(String käyttäjätunnus) {
        ArrayList<lemmikki> lemmikkini = new ArrayList<lemmikki>();
        try {
            //Luodaan yhteys tietokantaan ja haetaan lemmikit SQL-lauseen avulla.
            System.out.println("haetaan kayttajan lemmikit...");
            Connection yhteys = Tietokantayhteys.getYhteys();
            String sql = "select lemmikki.lemmikkiID, lemmikki.käyttäjätunnus, lemmikki.nimi, lemmikki.väri, lemmikki.ikä, lemmikki.kuvaus, lemmikki.kuva, lemmikki.rotuID "
                    + "from lemmikki, käyttäjä "
                    + "where käyttäjä.käyttäjätunnus = "+"'"+käyttäjätunnus+"'"+" and "+"lemmikki.käyttäjätunnus = käyttäjä.käyttäjätunnus";
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet rs = kysely.executeQuery();
            System.out.println("SQL-kysely suoritettu.");
            
            //Niin kauan kun lemmikkejä on, luo lemmikki ja lisää listaan.
            while(rs.next()) {
                lemmikki l = new lemmikki();
                l.setLemmikkiID(rs.getInt("lemmikkiID"));
                l.setNimi(rs.getString("nimi"));
                l.setVari(rs.getString("väri"));
                l.setIka(rs.getInt("ikä"));
                l.setKuvaus(rs.getString("kuvaus"));
                l.setKuva(null);
                l.setOmistaja(rs.getString("käyttäjätunnus"));
                l.setRotuID(rs.getInt("rotuID"));
                
                //Lisää listaan
                lemmikkini.add(l);
            }
            
            //Sulje yhteydet
            try { rs.close(); } catch (Exception e) {}
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(lemmikki.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Lopuksi palautetaan lista lemmikeillä.
        return lemmikkini;
    }
    
    //Tarkistaa onko tiedot kelvollisia
    public boolean onkoKelvollinen() {
        if(virheet.isEmpty()) return true;
        else return false;
    }
    
    //Setters
    public void setLemmikkiID(int lemmikkiID) {
        this.lemmikkiID = lemmikkiID;
    }
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    public void setVari(String vari) {
        this.vari = vari;
    }
    public void setIka(int ika) {
            this.ika = ika;
    }
    public void setIkaString(String ika) {
        try {
            setIka(Integer.parseInt(ika));
        } catch(NumberFormatException e) {
          virheet.add("Kissan ikä tulee olla kokonaisluku.");
        }
    }
    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
    public void setKuva(Image kuva) {
        this.kuva = kuva;
    }
    public void setOmistaja(String omistaja) {
        this.omistaja = omistaja;
    }
    public void setRotuID(int rotuID) {
        this.rotuID = rotuID;
    }
    
    //Getters
    public String getNimi() {
        return nimi;
    }
    public Image getKuva() {
        return kuva;
    }
    public String getKuvaus() {
        return kuvaus;
    }
    public String getVari() {
        return vari;
    }
    public int getIka() {
        return ika;
    }
    public String getOmistaja() {
        return omistaja;
    }
    public int getRotuID() {
        return rotuID;
    }
    public List<String> getVirheet() {
        return virheet;
    }
    public int getLemmikkiID() {
        return lemmikkiID;
    }
}
