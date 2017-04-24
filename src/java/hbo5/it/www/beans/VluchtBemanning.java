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
public class VluchtBemanning {
    private int id;
    private String taak;
    private Bemanningslid bemanningslid;
    private Vlucht vlucht;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaak() {
        return taak;
    }

    public void setTaak(String taak) {
        this.taak = taak;
    }

    public Bemanningslid getBemanningslid() {
        return bemanningslid;
    }

    public void setBemanningslid(Bemanningslid bemanningslid) {
        this.bemanningslid = bemanningslid;
    }

    public Vlucht getVlucht() {
        return vlucht;
    }

    public void setVlucht(Vlucht vlucht) {
        this.vlucht = vlucht;
    }
}
