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
public class Bemanningslid {
    private int id;
    private Luchtvaartmaatschappij luchtvaartmaatschappij;
    private Persoon persoon;
    private Functie functie;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Luchtvaartmaatschappij getLuchtvaartmaatschappij() {
        return luchtvaartmaatschappij;
    }

    public void setLuchtvaartmaatschappij(Luchtvaartmaatschappij luchtvaartmaatschappij) {
        this.luchtvaartmaatschappij = luchtvaartmaatschappij;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public Functie getFunctie() {
        return functie;
    }

    public void setFunctie(Functie functie) {
        this.functie = functie;
    }

    public Bemanningslid(int id, Luchtvaartmaatschappij luchtvaartmaatschappij, Persoon persoon, Functie functie) {
        this.id = id;
        this.luchtvaartmaatschappij = luchtvaartmaatschappij;
        this.persoon = persoon;
        this.functie = functie;
    }

    public Bemanningslid() {
    }


    
}
