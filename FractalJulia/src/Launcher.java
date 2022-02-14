
import Presentacion.Modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alejandro Riveros
 */
public class Launcher {
    private Modelo miApp;
    public Launcher(){
        miApp=new Modelo();
        miApp.iniciar();
    }
    public static void main(String[] args) {
        new Launcher();
    }
}
