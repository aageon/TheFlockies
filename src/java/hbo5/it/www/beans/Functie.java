/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

/**
 *
 * @author nickvandepaer
 */
public class Functie {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public Bemanningslid getBemanningslid() {
        return bemanningslid;
    }

    public void setBemanningslid(Bemanningslid bemanningslid) {
        this.bemanningslid = bemanningslid;
    }

    private int id;
    private String naam;
    private String omschrijving;
    private Bemanningslid bemanningslid;
}
