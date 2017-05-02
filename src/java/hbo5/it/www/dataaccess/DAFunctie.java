/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
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
public class DAFunctie {
    
    private Connection conn = null;
    
    public DAFunctie(String url, String login, String password, String driver) throws ClassNotFoundException, SQLException {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Functie> listFuncties() {
        List<Functie> functies = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * from FUNCTIE";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Functie f = new Functie();
                f.setId(rs.getInt("id"));
                f.setNaam(rs.getString("naam"));
                f.setOmschrijving(rs.getString("omschrijving"));
                
                functies.add(f);
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
        return functies;
    }
    
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
