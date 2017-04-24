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
public class Vlucht {
    private int id;
 private String code;
 private Date vertrektijd;
 private Date aankomsttijd;
 private Vliegtuig vliegtuig;
 private Luchthaven vertrekluchthaven;
 private Luchthaven aankomstluchthaven;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getVertrektijd() {
        return vertrektijd;
    }

    public void setVertrektijd(Date vertrektijd) {
        this.vertrektijd = vertrektijd;
    }

    public Date getAankomsttijd() {
        return aankomsttijd;
    }

    public void setAankomsttijd(Date aankomsttijd) {
        this.aankomsttijd = aankomsttijd;
    }

    public Vliegtuig getVliegtuig() {
        return vliegtuig;
    }

    public void setVliegtuig(Vliegtuig vliegtuig) {
        this.vliegtuig = vliegtuig;
    }

    public Luchthaven getVertrekluchthaven() {
        return vertrekluchthaven;
    }

    public void setVertrekluchthaven(Luchthaven vertrekluchthaven) {
        this.vertrekluchthaven = vertrekluchthaven;
    }

    public Luchthaven getAankomstluchthaven() {
        return aankomstluchthaven;
    }

    public void setAankomstluchthaven(Luchthaven aankomstluchthaven) {
        this.aankomstluchthaven = aankomstluchthaven;
    }
}
