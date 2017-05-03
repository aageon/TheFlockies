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
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vliegtuig;
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
public class DAVlucht {

    private Connection conn = null;

    public DAVlucht(String url, String login, String password, String driver) throws ClassNotFoundException, SQLException {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Vlucht> listVluchten() {
        List<Vlucht> vluchten = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * from vlucht v "
                    + "join vliegtuig vl on v.vliegtuig_id = vl.id "
                    + "join luchthaven l on v.vertrekluchthaven_id = l.id "
                    + "join luchthaven l2 on v.aankomstluchthaven_id = l2.id "
                    + "join vliegtuigtype vt on vl.vliegtuigtype_id = vt.id "
                    + "join leasemaatschappij le on vl.leasemaatschappij_id = le.id "
                    + " join luchtvaartmaatschappij lu on vl.luchtvaartmaatschappij_id = lu.id";

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Vlucht v = new Vlucht();
                v.setId(rs.getInt("id"));
                v.setCode(rs.getString("code"));
                v.setVertrektijd(rs.getDate("vertrektijd"));
                v.setAankomsttijd(rs.getDate("aankomsttijd"));

                Vliegtuig vl = new Vliegtuig();

                vl.setId(rs.getInt("vliegtuig_id"));

                Vliegtuigtype vType = new Vliegtuigtype();
                vType.setId(rs.getInt(18));
                vType.setNaam(rs.getString(19));

                vl.setVliegtuigtype_id(vType);

                Leasemaatschappij l = new Leasemaatschappij();
                l.setId(rs.getInt(20));
                l.setNaam(rs.getString(21));

                vl.setLeesmaatschappij(l);

                Luchtvaartmaatschappij lu = new Luchtvaartmaatschappij();
                lu.setId(rs.getInt(22));
                lu.setNaam(rs.getString(23));

                vl.setLuchtvaartmaatschappij(lu);

                Luchthaven l1 = new Luchthaven();
                l1.setId(rs.getInt(12));
                l1.setNaam(rs.getString(13));
                l1.setStad(rs.getString(14));

                v.setVertrekluchthaven(l1);

                Luchthaven l2 = new Luchthaven();
                l2.setId(rs.getInt(15));
                l2.setNaam(rs.getString(16));
                l2.setStad(rs.getString(17));

                v.setAankomstluchthaven(l2);

                vluchten.add(v);
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
        return vluchten;
    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
