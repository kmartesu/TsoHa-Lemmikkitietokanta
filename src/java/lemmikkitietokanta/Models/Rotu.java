package lemmikkitietokanta.Models;

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
public class Rotu {
    private int rotuID;
    private String nimi;
    private String kuvaus;
    
    public Rotu() {}
    
    public static List<Rotu> getRodut() {
        List<Rotu> rodut = new ArrayList<Rotu>();
        
        try {
            //Luodaan yhteys tietokantaan ja haetaan rodut SQL-lauseen avulla.
            System.out.println("haetaan rodut...");
            Connection yhteys = Tietokantayhteys.getYhteys();
            String sql = "select rotu.rotuID, rotu.nimi, rotu.kuvaus from rotu";
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet rs = kysely.executeQuery();
            System.out.println("SQL-kysely suoritettu.");
            
            //Niin kauan kun rotuja on, luo rotu ja lisää listaan.
            while(rs.next()) {
                Rotu r = new Rotu();
                r.setRotuID(rs.getInt("rotuID"));
                r.setNimi(rs.getString("nimi"));
                r.setKuvaus(rs.getString("kuvaus"));
                
                //Lisää listaan
                rodut.add(r);
            }
            
            //Sulje yhteydet
            try { rs.close(); } catch (Exception e) {}
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(Rotu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rodut;
    }
    
    //Setters
    public void setRotuID(int rotuID) {
        this.rotuID = rotuID;
    }
    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    public void setKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
    
    //Getters
    public int getRotuID() {
        return rotuID;
    }
    public String getNimi() {
        return nimi;
    }
    public String getKuvaus() {
        return kuvaus;
    }
}
