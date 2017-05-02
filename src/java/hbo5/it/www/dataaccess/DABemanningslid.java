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
public class DABemanningslid {

    private Connection conn = null;

    public DABemanningslid(String url, String login, String password, String driver) throws ClassNotFoundException, SQLException {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bemanningslid> listBemanning() {
        List<Bemanningslid> bemanning = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * "
                    + "from bemanningslid  b "
                    + "join luchtvaartmaatschappij l on b.luchtvaartmaatschappij_id = l.id "
                    + "join persoon p on b.persoon_id = p.id "
                    + "join functie f on b.functie_id = f.id";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Bemanningslid b = new Bemanningslid();
                b.setId(rs.getInt("id"));

                b.setLuchtvaartmaatschappij(new Luchtvaartmaatschappij(rs.getInt("id"), rs.getString("naam")));
                b.setPersoon(new Persoon(rs.getInt("id"), rs.getString("familienaam"), rs.getString("voornaam"), rs.getString("straat"), rs.getString("huisnr"), rs.getString("postcode"), rs.getString("woonplaats"), rs.getString("land"), rs.getDate("geboortedatum"), rs.getString("login"), rs.getString("paswoord")));
                b.setFunctie(new Functie(rs.getInt("id"), rs.getString("naam"), rs.getString("omschrijving")));

                bemanning.add(b);
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
        return bemanning;
    }
    
    
    
    
    
    

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
