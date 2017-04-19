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
class Stockage {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReden() {
        return reden;
    }

    public void setReden(String reden) {
        this.reden = reden;
    }

    public Date getVandatum() {
        return vandatum;
    }

    public void setVandatum(Date vandatum) {
        this.vandatum = vandatum;
    }

    public Date getTotdatum() {
        return totdatum;
    }

    public void setTotdatum(Date totdatum) {
        this.totdatum = totdatum;
    }

    public Vliegtuig getVliegtuig() {
        return vliegtuig;
    }

    public void setVliegtuig(Vliegtuig vliegtuig) {
        this.vliegtuig = vliegtuig;
    }

    public Hangar getHangar() {
        return hangar;
    }

    public void setHangar(Hangar hangar) {
        this.hangar = hangar;
    }
    private int id;
    private String reden;
    private Date vandatum;
    private Date totdatum;
    private Vliegtuig vliegtuig;
    private Hangar hangar;
}
