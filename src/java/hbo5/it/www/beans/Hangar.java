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
public class Hangar {

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

    public Stockage getStockage() {
        return stockage;
    }

    public void setStockage(Stockage stockage) {
        this.stockage = stockage;
    }

    private int id;
    private String naam;
    private Stockage stockage;
    
}