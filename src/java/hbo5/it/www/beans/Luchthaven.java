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
public class Luchthaven {

    private int id;
    private String naam;
    private String stad;

    public Luchthaven(int id, String naam, String stad) {
        this.id = id;
        this.naam = naam;
        this.stad = stad;
    }

    public Luchthaven() {
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

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

}
