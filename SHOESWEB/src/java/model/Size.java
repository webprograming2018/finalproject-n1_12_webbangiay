/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thuy Tran
 */
public class Size {
    long id;
    long name;

    public Size() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }
    
    
}
