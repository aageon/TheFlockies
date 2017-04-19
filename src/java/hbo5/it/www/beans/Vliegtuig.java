/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hbo5.it.www.beans;

/**
 *
 * @author 11400173
 */
public class Vliegtuig 
{
 private int id;
 private Vliegtuigtype vliegtuigtype_id;
 private Leasemaatschappij leesmaatschappij;
 private Luchtvaartmaatschappij luchtvaartmaatschappij;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vliegtuigtype getVliegtuigtype_id() {
        return vliegtuigtype_id;
    }

    public void setVliegtuigtype_id(Vliegtuigtype vliegtuigtype_id) {
        this.vliegtuigtype_id = vliegtuigtype_id;
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
