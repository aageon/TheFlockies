/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
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
public class DAHangar {
    
    private Connection conn = null;
    
    public DAHangar(String url, String login, String password, String driver) throws ClassNotFoundException, SQLException {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Hangar> listHangar() {
        List<Hangar> hangars = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * from hangar";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Hangar h = new Hangar();
                h.setId(rs.getInt("id"));
                h.setNaam(rs.getString("naam"));
                
                hangars.add(h);
            }
        } catch (Exception e) {
        } finally {
            try {
                stmt.close();
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
        }
        return hangars;
    }
    
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}