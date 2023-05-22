/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rocnic.dao;

import java.io.Serializable;

/**
 *
 * @author alumno
 */
public class Periferico  implements Serializable
{

    public Periferico()
    {
    }
   
    
   private int IdPeriferico;
   private String NombrePeriferico;
   

    public int getIdPeriferico() {
        return IdPeriferico;
    }

    public void setIdPeriferico(int IdPeriferico) {
        this.IdPeriferico = IdPeriferico;
    }

    public String getNombrePeriferico() {
        return NombrePeriferico;
    }

    public void setNombrePeriferico(String NombrePeriferico) {
        this.NombrePeriferico = NombrePeriferico;
    }
}
