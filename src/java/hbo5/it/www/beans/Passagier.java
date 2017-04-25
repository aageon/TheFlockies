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
public class Passagier {

    private int id;
    private int ingeschreven;
    private int ingecheckt;
    private Vliegtuigklasse vliegtuigklasse;
    private String plaats;
    private Vlucht vlucht;
    private Persoon persoon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIngeschreven() {
        return ingeschreven;
    }

    public void setIngeschreven(int ingeschreven) {
        this.ingeschreven = ingeschreven;
    }

    public int getIngecheckt() {
        return ingecheckt;
    }

    public void setIngecheckt(int ingecheckt) {
        this.ingecheckt = ingecheckt;
    }

    public Vliegtuigklasse getVliegtuigklasse() {
        return vliegtuigklasse;
    }

    public void setVliegtuigklasse(Vliegtuigklasse vliegtuigklasse) {
        this.vliegtuigklasse = vliegtuigklasse;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public Vlucht getVlucht() {
        return vlucht;
    }

    public void setVlucht(Vlucht vlucht) {
        this.vlucht = vlucht;
    }

    public Persoon getPersoon() {
        return persoon;
    }

    public void setPersoon(Persoon persoon) {
        this.persoon = persoon;
    }

    public Passagier(int id, int ingeschreven, int ingecheckt, Vliegtuigklasse vliegtuigklasse, String plaats, Vlucht vlucht, Persoon persoon) {
        this.id = id;
        this.ingeschreven = ingeschreven;
        this.ingecheckt = ingecheckt;
        this.vliegtuigklasse = vliegtuigklasse;
        this.plaats = plaats;
        this.vlucht = vlucht;
        this.persoon = persoon;
    }

    public Passagier() {
    }

}
