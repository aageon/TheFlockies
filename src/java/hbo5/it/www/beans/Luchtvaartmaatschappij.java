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
public class Luchtvaartmaatschappij {

    private int id;
    private String naam;

    public Luchtvaartmaatschappij(int id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public Luchtvaartmaatschappij() {
    }

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

}
