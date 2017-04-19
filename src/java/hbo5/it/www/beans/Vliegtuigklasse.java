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
public class Vliegtuigklasse {

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

    public Passagier getPassagier() {
        return passagier;
    }

    public void setPassagier(Passagier passagier) {
        this.passagier = passagier;
    }
    private int id;
    private String naam;
    private Passagier passagier;
}
