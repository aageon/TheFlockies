/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Persoon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nickvandepaer
 */
public class DAPersoon {
    private Connection conn = null;
    public  DAPersoon(String path){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + path);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Persoon> ListPersonen(){
        List<Persoon> persoons = new ArrayList<Persoon>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "Select * from Persoon";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Persoon p = new Persoon();
                p.setFamilienaam(rs.getString("familienaam"));
                p.setVoornaaam(rs.getString("voornaam"));
                p.setId(rs.getInt("id"));
                p.setStraat(rs.getString("straat"));
                p.setHuisnr(rs.getString("huisnr"));
                p.setPostcode(rs.getString("postcode"));
                p.setWoonplaats(rs.getString("woonplaats"));
                p.setLand(rs.getString("land"));
                p.setGeboortedatum(rs.getDate("geboortedatum"));
                p.setLogin(rs.getString("login"));
                p.setPaswoord(rs.getString("paswoord"));
                
                persoons.add(p);
            }
        } catch (Exception e) {
        }
        finally{
            rs.close();
            stmt.close();
        }
        return persoons;
    }
    
    
    
}

