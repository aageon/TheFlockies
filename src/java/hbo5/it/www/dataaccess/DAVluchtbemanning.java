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
import hbo5.it.www.beans.VluchtBemanning;
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
public class DAVluchtbemanning {

    private Connection conn = null;

    public DAVluchtbemanning(String url, String login, String password, String driver) throws ClassNotFoundException, SQLException {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public List<VluchtBemanning> listVluchtBemanning() {
        List<VluchtBemanning> vluchtbemanningen = new ArrayList<>();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT * from vluchtbemanning v "
                    + "join bemanningslid b on v.bemanningslid_id = b.id "
                    + "join luchtvaartmaatschappij l on b.luchtvaartmaatschappij_id = l.id "
                    + "join persoon p on b.persoon_id = p.id "
                    + "join functie f on b.functie_id = f.id "
                    + "join vlucht vl on v.vlucht_id = vl.id "
                    + "join vliegtuig vlieg on vl.vliegtuig_id = vlieg.id "
                    + "join vliegtuigtype vtype on vlieg.VLIEGTUIGTYPE_ID = vtype.ID "
                    + "join luchtvaartmaatschappij l2 on vlieg.LUCHTVAARTMAATSCHAPPIJ_ID = l2.id "
                    + "join leasemaatschappij le on vlieg.LEASEMAATSCHAPPIJ_ID = le.ID "
                    + "join luchthaven lu on vl.vertrekluchthaven_id = lu.id "
                    + "join luchthaven lu2 on vl.aankomstluchthaven_id = lu2.id ";

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                VluchtBemanning v = new VluchtBemanning();
                v.setId(rs.getInt("id"));
                v.setTaak(rs.getString("taak"));

                Bemanningslid b = new Bemanningslid();
                b.setId(rs.getInt("bemanningslid_id"));

                Luchtvaartmaatschappij l = new Luchtvaartmaatschappij();

                l.setId(rs.getInt(9));
                l.setNaam(rs.getString(10));

                b.setLuchtvaartmaatschappij(l);

                Persoon p = new Persoon();
                p.setId(rs.getInt(11));
                p.setVoornaaam(rs.getString("voornaam"));
                p.setFamilienaam(rs.getString("familienaam"));
                p.setStraat(rs.getString("straat"));
                p.setHuisnr(rs.getString("huisnr"));
                p.setPostcode(rs.getString("postcode"));
                p.setWoonplaats(rs.getString("woonplaats"));
                p.setLand(rs.getString("land"));
                p.setGeboortedatum(rs.getDate("geboortedatum"));
                p.setLogin(rs.getString("login"));
                p.setPaswoord(rs.getString("paswoord"));

                b.setPersoon(p);

                Functie f = new Functie();
                f.setId(rs.getInt(22));
                f.setNaam(rs.getString(23));
                f.setOmschrijving(rs.getString(24));

                b.setFunctie(f);
                
                v.setBemanningslid(b);

                //einde bemanning
                Vlucht vl = new Vlucht();
                vl.setId(rs.getInt(25));
                vl.setCode(rs.getString("code"));
                vl.setVertrektijd(rs.getDate("vertrektijd"));
                vl.setAankomsttijd(rs.getDate("aankomsttijd"));

                Vliegtuig vliegtuig = new Vliegtuig();
                vliegtuig.setId(rs.getInt(29));

                Vliegtuigtype vtype = new Vliegtuigtype();
                vtype.setId(rs.getInt(36));
                vtype.setNaam(rs.getString(37));

                vliegtuig.setVliegtuigtype_id(vtype);

                Leasemaatschappij le = new Leasemaatschappij();
                le.setId(rs.getInt(40));
                le.setNaam(rs.getString(41));

                vliegtuig.setLeesmaatschappij(le);

                Luchtvaartmaatschappij l2 = new Luchtvaartmaatschappij();
                l2.setId(rs.getInt(38));
                l2.setNaam(rs.getString(39));

                vliegtuig.setLuchtvaartmaatschappij(l2);

                //einde vliegtuig
                Luchthaven vertrekl = new Luchthaven();
                vertrekl.setId(rs.getInt(42));
                vertrekl.setNaam(rs.getString(43));
                vertrekl.setStad(rs.getString(44));

                vl.setVertrekluchthaven(vertrekl);

                Luchthaven aankomstl = new Luchthaven();
                aankomstl.setId(rs.getInt(45));
                aankomstl.setNaam(rs.getString(46));
                aankomstl.setStad(rs.getString(47));

                vl.setAankomstluchthaven(aankomstl);

                v.setVlucht(vl);

                vluchtbemanningen.add(v);
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
        return vluchtbemanningen;
    }

    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}
