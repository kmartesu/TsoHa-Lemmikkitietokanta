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
 *
 * @author Kim Martesuo
 */
public class lemmikki {
    
    private int lemmikkiID;
    private String nimi;
    private String vari;
    private int ika;
    private String kuvaus;
    private Image kuva;
    private String omistaja;
    private int rotuID;
    
    public lemmikki(int lemmikkiID, String nimi, String vari, int ika, String kuvaus, Image kuva, String omistaja, int rotuID) {
        this.lemmikkiID = lemmikkiID;
        this.nimi = nimi;
        this.vari = vari;
        this.ika = ika;
        this.kuvaus = kuvaus;
        this.kuva = kuva;
        this.omistaja = omistaja;
        this.rotuID = rotuID;
    }
    
    public static List<lemmikki> getLemmikkini(String käyttäjätunnus) {
        ArrayList<lemmikki> lemmikkini = new ArrayList<lemmikki>();
        try {
            //Luodaan yhteys tietokantaan ja haetaan lemmikit SQL-lauseen avulla.
            System.out.println("haetaan käyttäjän lemmikit...");
            Connection yhteys = Tietokantayhteys.getYhteys();
            String sql = "select lemmikki.lemmikkiID, lemmikki.käyttäjätunnus, lemmikki.nimi, lemmikki.väri, lemmikki.ikä, lemmikki.kuvaus, lemmikki.kuva "
                    + "from lemmikki, käyttäjä "
                    + "where lemmikki.käyttäjätunnus = käyttäjä."+käyttäjätunnus;
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet rs = kysely.executeQuery();
            
            //Niin kauan kun lemmikkejä on, luo lemmikki ja lisää listaan.
            while(rs.next()) {
                int lemmikkiID = rs.getInt("lemmikkiID");
                String nimi = rs.getString("nimi");
                String vari = rs.getString("väri");
                int ika = rs.getInt("ikä");
                String kuvaus = rs.getString("kuvaus");
                Image kuva = null;
                String omistaja = rs.getString("käyttäjätunnus");
                int rotuID = rs.getInt("rotuID");
                
                //Lisää listaan
                lemmikki l = new lemmikki(lemmikkiID, nimi, vari, ika, kuvaus, kuva, omistaja, rotuID);
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
    
}
