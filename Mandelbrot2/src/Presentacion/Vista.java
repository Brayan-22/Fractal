/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Canvas;
import javax.swing.JFrame;

/**
 *
 * @author Alejandro Riveros
 */
public class Vista extends JFrame{
    private Canvas lienzo;
    private final Modelo modelo;
    public Vista(Modelo m){
        lienzo=new Canvas();
        lienzo.setSize(1000, 1000);
        modelo=m;
        add(lienzo);
    }
    public Modelo getModelo(){
        return modelo;
    }

    public Canvas getLienzo() {
        return lienzo;
    }

    public void setLienzo(Canvas lienzo) {
        this.lienzo = lienzo;
    }
    
}
