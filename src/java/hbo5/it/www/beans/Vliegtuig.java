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
public class Vliegtuig {

    private int id;
    private Vliegtuigtype vliegtuigtype;
    private Leasemaatschappij leesmaatschappij;
    private Luchtvaartmaatschappij luchtvaartmaatschappij;

    public Vliegtuig(int id, Vliegtuigtype vliegtuigtype, Leasemaatschappij leesmaatschappij, Luchtvaartmaatschappij luchtvaartmaatschappij) {
        this.id = id;
        this.vliegtuigtype = vliegtuigtype;
        this.leesmaatschappij = leesmaatschappij;
        this.luchtvaartmaatschappij = luchtvaartmaatschappij;
    }

    public Vliegtuig() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vliegtuigtype getVliegtuigtype() {
        return vliegtuigtype;
    }

    public void setVliegtuigtype_id(Vliegtuigtype vliegtuigtype) {
        this.vliegtuigtype = vliegtuigtype;
    }

    public Leasemaatschappij getLeesmaatschappij() {
        return leesmaatschappij;
    }

    public void setLeesmaatschappij(Leasemaatschappij leesmaatschappij) {
        this.leesmaatschappij = leesmaatschappij;
    }

    public Luchtvaartmaatschappij getLuchtvaartmaatschappij() {
        return luchtvaartmaatschappij;
    }

    public void setLuchtvaartmaatschappij(Luchtvaartmaatschappij luchtvaartmaatschappij) {
        this.luchtvaartmaatschappij = luchtvaartmaatschappij;
    }

}
