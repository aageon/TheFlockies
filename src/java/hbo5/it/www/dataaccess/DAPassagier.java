/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.dataaccess;

import hbo5.it.www.beans.Bemanningslid;
import hbo5.it.www.beans.Functie;
import hbo5.it.www.beans.Luchthaven;
import hbo5.it.www.beans.Luchtvaartmaatschappij;
import hbo5.it.www.beans.Passagier;
import hbo5.it.www.beans.Persoon;
import hbo5.it.www.beans.Vliegtuig;
import hbo5.it.www.beans.Vliegtuigklasse;
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
public class DAPassagier {

    private Connection conn = null;

    public DAPassagier(String url, String login, String password, String driver) throws ClassNotFoundException, SQLException {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Passagier> listPassagier() {
        List<Passagier> passagiers = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * "
                    + "from PASSAGIER  p "
                    + "join vliegtuigklasse k on p.klasse_id = k.id "
                    + "join vlucht v on p.vlucht_id = v.id "
                    + "join persoon pe on p.persoon_id = pe.id "
                    + "join vliegtuig vl on v.vliegtuig_id = vl.id "
                    + "join luchthaven l on v.vertrekluchthaven_id = l.id "
                    + "join luchthaven lu on v.aankomstluchthaven_id = lu.id";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Passagier p = new Passagier();
                p.setId(rs.getInt("id"));
                p.setIngeschreven(rs.getInt("ingeschreven"));
                p.setIngecheckt(rs.getInt("ingecheckt"));
                p.setPlaats(rs.getString("plaats"));

                p.setVliegtuigklasse(new Vliegtuigklasse(rs.getInt("klasse_id"), rs.getString("naam")));
                p.setPersoon(new Persoon(rs.getInt("persoon_id"), rs.getString("familienaam"), rs.getString("voornaam"), rs.getString("straat"), rs.getString("huisnr"), rs.getString("postcode"), rs.getString("woonplaats"), rs.getString("land"), rs.getDate("geboortedatum"), rs.getString("login"), rs.getString("paswoord")));

                Vlucht vl = new Vlucht();
                vl.setId(rs.getInt("vlucht_id"));
                vl.setCode(rs.getString("code"));
                vl.setVertrektijd(rs.getDate("vertrektijd"));
                vl.setAankomsttijd(rs.getDate("aankomsttijd"));

                Vliegtuig vliegtuig = new Vliegtuig();
                vliegtuig.setId(rs.getInt("vliegtuig_id"));
                vl.setVliegtuig(vliegtuig);

                Luchthaven luchthaven = new Luchthaven();
                luchthaven.setId(rs.getInt("vertrekluchthaven_id"));
                luchthaven.setNaam(rs.getString(33));
                luchthaven.setStad(rs.getString(34));
                vl.setVertrekluchthaven(luchthaven);

                Luchthaven luchthaven2 = new Luchthaven();
                luchthaven2.setId(rs.getInt("aankomstluchthaven_id"));
                luchthaven2.setNaam(rs.getString(36));
                luchthaven2.setStad(rs.getString(37));
                vl.setAankomstluchthaven(luchthaven2);

                p.setVlucht(vl);

//                p.setVlucht(new Vlucht(rs.getInt("vlucht_id"), rs.getString("code"), rs.getDate("vertrektijd"), rs.getDate("aankomsttijd"), new Vliegtuig(rs.getInt("vliegtuig_id"), null, null, null) , new Luchthaven(rs.getInt("vertrekluchthaven_id"), rs.getString("naam"), rs.getString("stad")), new Luchthaven(rs.getInt("aankomstluchthaven_id"), rs.getString("naam"), rs.getString("stad"))));
                passagiers.add(p);
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
        return passagiers;
    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
