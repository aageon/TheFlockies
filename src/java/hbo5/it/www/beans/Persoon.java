/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

import java.sql.Date;

/**
 *
 * @author nickvandepaer
 */
public class Persoon {

    private int id;
    private String voornaaam;
    private String familienaam;
    private String straat;
    private String huisnr;
    private String postcode;
    private String woonplaats;
    private String land;
    private Date geboortedatum;
    private String login;
    private String paswoord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoornaaam() {
        return voornaaam;
    }

    public void setVoornaaam(String voornaaam) {
        this.voornaaam = voornaaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisnr() {
        return huisnr;
    }

    public void setHuisnr(String huisnr) {
        this.huisnr = huisnr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWoonplaats() {
        return woonplaats;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPaswoord() {
        return paswoord;
    }

    public void setPaswoord(String paswoord) {
        this.paswoord = paswoord;
    }

    public Persoon(int id, String voornaaam, String familienaam, String straat, String huisnr, String postcode, String woonplaats, String land, Date geboortedatum, String login, String paswoord) {
        this.id = id;
        this.voornaaam = voornaaam;
        this.familienaam = familienaam;
        this.straat = straat;
        this.huisnr = huisnr;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
        this.land = land;
        this.geboortedatum = geboortedatum;
        this.login = login;
        this.paswoord = paswoord;
    }

    public Persoon() {
    }

}
