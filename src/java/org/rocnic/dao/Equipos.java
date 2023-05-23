/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rocnic.dao;

/**
 *
 * @author Evelyn
 */
public class Equipos {
     private int IdEquipo ;
     private int IdLaboratorio ;
     private int IdPeriferico ;
     private String NombreEquipo;

    public int getIdEquipo() {
        return IdEquipo;
    }

    public void setIdEquipo(int IdEquipo) {
        this.IdEquipo = IdEquipo;
    }

    public int getIdLaboratorio() {
        return IdLaboratorio;
    }

    public void setIdLaboratorio(int IdLaboratorio) {
        this.IdLaboratorio = IdLaboratorio;
    }

    public int getIdPeriferico() {
        return IdPeriferico;
    }

    public void setIdPeriferico(int IdPeriferico) {
        this.IdPeriferico = IdPeriferico;
    }

    public String getNombreEquipo() {
        return NombreEquipo;
    }

    public void setNombreEquipo(String NombreEquipo) {
        this.NombreEquipo = NombreEquipo;
    }
}
