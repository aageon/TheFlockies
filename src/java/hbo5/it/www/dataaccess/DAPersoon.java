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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nickvandepaer
 */
public class DAPersoon {
    private Connection conn = null;
    public  DAPersoon(String url, String login, String password, String driver)throws ClassNotFoundException, SQLException{
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
   
    
    
    public List<Persoon> ListPersonen(){
        List<Persoon> persoons = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM PERSOON";
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
            try {
                stmt.close();
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
        return persoons;
    }
    
    public void doUpdate(Persoon p){
        PreparedStatement stmt = null;
        try {
            String sql = "Update persoon SET voornaam = ?, " + "familienaam = ?, " + "straat = ?, " + "huisnr = ?, " +
                    "postcode = ?, " + "woonplaats = ?, " + "land = ?, " + "geboortedatum = ?, " + "login = ?, " + "paswoord = ?";
            
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, p.getVoornaaam());
            stmt.setString(2, p.getFamilienaam());
            stmt.setString(3, p.getStraat());
            stmt.setString(4, p.getHuisnr());
            stmt.setString(5, p.getPostcode());
            stmt.setString(6, p.getWoonplaats());
            stmt.setString(7, p.getLand());
            DateFormat df = new SimpleDateFormat("dd/MM/YYYY");
            stmt.setString(8, df.format(p.getGeboortedatum()));
            stmt.setString(9, p.getLogin());
            stmt.setString(10, p.getPaswoord());
            
        } catch (Exception e) {
        }
    }
    
    
    
    
        public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }  
    }
    
}
