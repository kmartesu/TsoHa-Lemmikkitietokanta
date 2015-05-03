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
    private String rotu;
    private List<String> virheet = new ArrayList<String>();
    
    public lemmikki() {}
    
    
    //Metodi joka luo listan lemmikkejä result setistä
    public static ArrayList<lemmikki> luoLemmikit(ResultSet rs) {
        ArrayList<lemmikki> lemmikkiLista = new ArrayList<lemmikki>();
        try {
            while(rs.next()) {
                lemmikki l = new lemmikki();
                l.setNimi(rs.getString("nimi"));
                l.setIka(rs.getInt("ikä"));
                l.setVari(rs.getString("väri"));
                l.setKuvaus(rs.getString("kuvaus"));
                l.setOmistaja(rs.getString("käyttäjätunnus"));
                l.setRotu(rs.getString("rotunimi"));
               
                //Lisätään uusi lemmikki listaan
                lemmikkiLista.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(lemmikki.class.getName()).log(Level.SEVERE, null, ex);
        }
        //palautetaan lista lemmikeillä
        return lemmikkiLista;
    }
    
    public static List<lemmikki> haeLemmikkiRodulla(String rotu) {
        System.out.println("Haetaan lemmikki kannasta rodulla...");
        ArrayList<lemmikki> lemmikitRodulla = new ArrayList<lemmikki>();
        
        try {
            String rotuHakusana = rotu+"%";
            if(!(rotu.length() == 1)) {
                rotuHakusana = rotu.substring(1);
                rotuHakusana = "_"+rotuHakusana+"%";
            }
            String sql = "SELECT lemmikki.nimi, lemmikki.väri, lemmikki.ikä, lemmikki.kuvaus, lemmikki.käyttäjätunnus, rotu.nimi as rotunimi"
                    + " FROM lemmikki, käyttäjä, rotu WHERE lemmikki.käyttäjätunnus = käyttäjä.käyttäjätunnus and rotu.rotuID = lemmikki.rotuID and rotu.nimi SIMILAR TO ?;";
            Connection yhteys = Tietokantayhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            
            kysely.setString(1, rotuHakusana);
            ResultSet rs = kysely.executeQuery();
            lemmikitRodulla = luoLemmikit(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(lemmikki.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lemmikitRodulla;
    }
    
    //Metodi jolla haetaan lemmikit tietyllä postinumerolla
    public static List<lemmikki> haeLemmikitPostinumerolla(String postinumero) {
        System.out.println("Haetaan lemmikki kannasta postinumerolla...");
        ArrayList<lemmikki> lemmikitPostinumerolla = new ArrayList<lemmikki>();
        
        try {
            int postiNumero = Integer.parseInt(postinumero);
            String sql = "SELECT lemmikki.nimi, lemmikki.väri, lemmikki.ikä, lemmikki.kuvaus, lemmikki.käyttäjätunnus, rotu.nimi as rotunimi"
                    + " FROM lemmikki, käyttäjä, rotu WHERE lemmikki.käyttäjätunnus = käyttäjä.käyttäjätunnus and käyttäjä.postinumero = ? and rotu.rotuID = lemmikki.rotuID;";
            Connection yhteys = Tietokantayhteys.getYhteys();
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            
            kysely.setInt(1, postiNumero);
            ResultSet rs = kysely.executeQuery();
            lemmikitPostinumerolla = luoLemmikit(rs);
            
            //Sulje yhteydet
            try { rs.close(); } catch (Exception e) {}
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(lemmikki.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException e) {
            System.out.println("Hakusana ei ole postinumero.");
        }
        return lemmikitPostinumerolla;
    }
    
    //Metodi jolla haetaan lemmikit tietyllä nimellä
    public static List<lemmikki> haeLemmikitHakusanalla(String hakusana) {
        System.out.println("Haetaan lemmikki kannasta hakusanalla...");
        ArrayList<lemmikki> lemmikitHaulla = new ArrayList<lemmikki>();
        
        try {
            //Tarkistetaan onko hakusana 1 merkin mittainen.
            String valmisHakusana = hakusana+"%";
            if(!(hakusana.length() == 1)) {
                valmisHakusana = hakusana.substring(1);
                valmisHakusana = "_"+valmisHakusana+"%";
            }
            
            String sql = "SELECT lemmikki.nimi, lemmikki.väri, lemmikki.ikä, lemmikki.kuvaus, lemmikki.käyttäjätunnus, rotu.nimi as rotunimi FROM lemmikki, rotu WHERE lemmikki.nimi SIMILAR TO ?"
                    + " and rotu.rotuID = lemmikki.rotuID;";
            Connection yhteys = Tietokantayhteys.getYhteys();  
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            
            kysely.setString(1, valmisHakusana);
            ResultSet rs = kysely.executeQuery();
            
            lemmikitHaulla = luoLemmikit(rs);
            //Sulje yhteydet
            try { rs.close(); } catch (Exception e) {}
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(lemmikki.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lemmikitHaulla;
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
            String sql = "select lemmikki.lemmikkiID, lemmikki.nimi, lemmikki.väri, lemmikki.ikä, lemmikki.kuvaus, rotu.rotuID as rotunimi "
                    + "from lemmikki, rotu "
                    + "where lemmikki.lemmikkiID = ? and rotu.rotuID = lemmikki.rotuID;";
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            int lemmikkiID = Integer.parseInt(lemmikinID);
            
            //kysely.setString(1, k.getUsername());
            kysely.setInt(1, lemmikkiID);
            System.out.println(lemmikkiID);
            System.out.println(sql);
            ResultSet rs = kysely.executeQuery();
            
            while(rs.next()) {
                L.setLemmikkiID(rs.getInt("lemmikkiID"));
                L.setNimi(rs.getString("nimi"));
                L.setVari(rs.getString("väri"));
                L.setIka(rs.getInt("ikä"));
                L.setKuvaus(rs.getString("kuvaus"));
                L.setKuva(null);
                L.setOmistaja(k.getUsername());
                L.setRotu(rs.getString("rotunimi"));
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
            String sql = "select lemmikki.lemmikkiID, lemmikki.käyttäjätunnus, lemmikki.nimi, lemmikki.väri, lemmikki.ikä, lemmikki.kuvaus, lemmikki.kuva, rotu.nimi as rotunimi "
                    + "from lemmikki, käyttäjä, rotu "
                    + "where käyttäjä.käyttäjätunnus = "+"'"+käyttäjätunnus+"'"+" and "+"lemmikki.käyttäjätunnus = käyttäjä.käyttäjätunnus and rotu.rotuID = lemmikki.rotuID";
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet rs = kysely.executeQuery();
            System.out.println("SQL-kysely suoritettu.");
            //Ei voida käyttää luolemmikit metodia, koska tässä tarvitaan lemmikin ID:tä
            while(rs.next()) {
                lemmikki l = new lemmikki();
                l.setNimi(rs.getString("nimi"));
                l.setIka(rs.getInt("ikä"));
                l.setVari(rs.getString("väri"));
                l.setKuvaus(rs.getString("kuvaus"));
                l.setOmistaja(rs.getString("käyttäjätunnus"));
                l.setRotu(rs.getString("rotunimi"));
                l.setLemmikkiID(rs.getInt("lemmikkiID"));
                
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
    public void setRotu(String rotu) {
        this.rotu = rotu;
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
    public String getRotu() {
        return rotu;
    }
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
