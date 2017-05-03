/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
import hbo5.it.www.beans.Hangar;
import hbo5.it.www.beans.Leasemaatschappij;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Stockage;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Vliegtuigklasse;
import hbo5.it.www.beans.Vliegtuigtype;
import hbo5.it.www.beans.Vlucht;
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
public class DAStockage {

    private Connection conn = null;

    public DAStockage(String url, String login, String password, String driver) throws ClassNotFoundException, SQLException {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Stockage> listStockage() {
        List<Stockage> stockages = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * "
                    + "from Stockage  s "
                    + "join vliegtuig vl on s.vliegtuig_id = vl.id "
                    + "join Hangar h on s.hangar_id = h.id "
                    + "join vliegtuigtype v on vl.vliegtuigtype_id = v.id "
                    + "join leasemaatschappij l on vl.leasemaatschappij_id = l.id "
                    + "join luchtvaartmaatschappij lu on vl.luchtvaartmaatschappij_id = lu.id";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Stockage s = new Stockage();
                s.setId(rs.getInt("id"));
                s.setReden(rs.getString("reden"));
                s.setVandatum(rs.getDate("vandatum"));
                s.setTotdatum(rs.getDate("totdatum"));

                Vliegtuig vliegtuig = new Vliegtuig();
                vliegtuig.setId(rs.getInt("vliegtuig_id"));

                Vliegtuigtype vl = new Vliegtuigtype();
                vl.setId(rs.getInt("vliegtuigtype_id"));
                vl.setNaam(rs.getString(14));
                vliegtuig.setVliegtuigtype_id(vl);

                Leasemaatschappij l = new Leasemaatschappij();
                l.setId(rs.getInt("leasemaatschappij_id"));
                l.setNaam(rs.getString(16));
                vliegtuig.setLeesmaatschappij(l);

                Luchtvaartmaatschappij lu = new Luchtvaartmaatschappij();
                lu.setId(rs.getInt("luchtvaartmaatschappij_id"));
                lu.setNaam(rs.getString(18));
                vliegtuig.setLuchtvaartmaatschappij(lu);

                s.setVliegtuig(vliegtuig);

                Hangar h = new Hangar();
                h.setId(rs.getInt("hangar_id"));
                h.setNaam(rs.getString("naam"));
                s.setHangar(h);

                stockages.add(s);
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
        return stockages;
    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
