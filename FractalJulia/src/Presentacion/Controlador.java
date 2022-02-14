/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener{
    private Modelo modelo;
    public Controlador(Vista aThis){
        modelo=aThis.getModelo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Dibujar")){
            modelo.dibujar();
        }else{
            modelo.dibujar();
        }
    }
    
}
