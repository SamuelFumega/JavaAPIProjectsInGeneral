package com.agendamento.samuelFumega.SamuelFumega.models;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "automovel")
public class Automobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String name;

    private Date fabricante;

    private int estoque;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFabricante() {
        return fabricante;
    }

    public void setFabricante(Date fabricante) {
        this.fabricante = fabricante;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
