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
public class RyhmaMalli {
    
    private String ryhmaNimi;
    private String kuvaus;
    private Image kuva;
    
    public RyhmaMalli() {}
    
    public static List<RyhmaMalli> getRyhmat() {
        List<RyhmaMalli> ryhmat = new ArrayList<RyhmaMalli>();
        
        try {
            //Luodaan yhteys tietokantaan ja haetaan ryhmat SQL-lauseen avulla.
            System.out.println("haetaan ryhmat...");
            Connection yhteys = Tietokantayhteys.getYhteys();
            String sql = "select ryhmä.ryhmänimi, ryhmä.kuvaus from ryhmä";
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet rs = kysely.executeQuery();
            System.out.println("SQL-kysely suoritettu.");
            
            //Niin kauan kun ryhmiä on, luo ryhmä ja lisää listaan.
            while(rs.next()) {
                RyhmaMalli r = new RyhmaMalli();
                r.setRyhmaNimi(rs.getString("ryhmänimi"));
                r.setRyhmaKuvaus(rs.getString("kuvaus"));
                               
                //Lisää listaan
                ryhmat.add(r);
            }
            
            //Sulje yhteydet
            try { rs.close(); } catch (Exception e) {}
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(Rotu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ryhmat;
    }
    
    //Setterit ja Getterit
    public void setRyhmaNimi(String ryhmaNimi) {
        this.ryhmaNimi = ryhmaNimi;
    }
    
    public void setRyhmaKuvaus(String kuvaus) {
        this.kuvaus = kuvaus;
    }
    
    public String getRyhmaNimi() {
        return ryhmaNimi;
    }
    
    public String getKuvaus() {
        return kuvaus;
    }
}
