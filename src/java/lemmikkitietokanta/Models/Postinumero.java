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
public class Postinumero {
    
    private int numero;
    private String alueenNimi;
    private String postinumero;
    
    public Postinumero() {}
    
    public static List<Postinumero> getPostinumerot() {
        List<Postinumero> numerot = new ArrayList<Postinumero>();
        
        try {
            //Luodaan yhteys tietokantaan ja haetaan postinumerot SQL-lauseen avulla.
            System.out.println("haetaan postinumerot...");
            Connection yhteys = Tietokantayhteys.getYhteys();
            String sql = "select postinumero, alueen_nimi from postinumero";
            PreparedStatement kysely = yhteys.prepareStatement(sql);
            ResultSet rs = kysely.executeQuery();
            System.out.println("SQL-kysely suoritettu.");
            
            //Niin kauan kun postinumeroita on, luo postinumero ja lisää listaan.
            while(rs.next()) {
                Postinumero tempPostinumero = new Postinumero();
                tempPostinumero.setPostinumero(rs.getInt("postinumero"));
                tempPostinumero.setAlueenNimi(rs.getString("alueen_nimi"));
                tempPostinumero.setPostinumero(rs.getInt("postinumero"));
                //Lisää listaan
                numerot.add(tempPostinumero);
            }
            
            //Sulje yhteydet
            try { rs.close(); } catch (Exception e) {}
            try { kysely.close(); } catch (Exception e) {}
            try { yhteys.close(); } catch (Exception e) {}
        } catch (SQLException ex) {
            Logger.getLogger(Rotu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numerot;
    }
    
    public void setPostinumero(int postinumero) {
        this.numero = postinumero;
    }
    public void setAlueenNimi(String alueenNimi) {
        this.alueenNimi = alueenNimi;
    }
    public int getNumero() {
        return numero;
    }
    public String getAlueenNimi() {
        return alueenNimi;
    }
    public String getPostinumero() {
        return postinumero;
    }
}
