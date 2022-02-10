/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Alejandro Riveros
 */
public class Modelo {
    private int width;
    private int height;
    private double nReal;
    private double nImag;
    private Vista ventana;
    private Canvas lienzo;
    private Graphics g;
    public Modelo(){
    }
    public void iniciar() {
        getVentana().setDefaultCloseOperation(2);
        getVentana().setResizable(false);
        getVentana().setSize(1000,1000);
        getVentana().setLocationRelativeTo(null);
        getVentana().setVisible(true);
        dibujarMandelbrot();
    }
    public Vista getVentana() {
        if (ventana == null) {
            ventana = new Vista(this);
        }
        return ventana;
    }

    private void dibujarMandelbrot() {
        lienzo=getVentana().getLienzo();
        g=lienzo.getGraphics();
        width=lienzo.getWidth();
        height=lienzo.getHeight();
        for(int xc=0;xc<width;xc++){
            for(int yc=0;yc<height;yc++){
                nReal=(xc-width/2.0)*4.0/(width);//Al cambiar las constantes por las que se multiplican, se puede hacer un zoom de la imagen
                nImag=(yc-height/2.0)*4.0/(height);//Al cambiar las constantes por las que se multiplican, se puede hacer un zoom de la imagen
                double x=0;
                double y=0;
                int iteraciones=0;
                while((iteraciones<5000)&&((x*x+y*y)<4)){//entre mas iteraciones mas preciso es el dibujo
                    double xTemp=(x*x)-(y*y)+nReal;
                    y=2.0*x*y+nImag;
                    x=xTemp;
                    iteraciones++;
                }
                if(iteraciones>=0 && iteraciones<750){
                    g.drawLine(xc, yc, xc, yc);
                    g.setColor(new Color(4*iteraciones%255, iteraciones%3*30, 50));
                }else if (iteraciones>=750&&iteraciones<1500) {
                    g.drawLine(xc, yc, xc, yc);
                    g.setColor(new Color(100, iteraciones*3%50, iteraciones%255));
                }else if (iteraciones>=1500&&iteraciones<2250) {
                    g.drawLine(xc, yc, xc, yc);
                    g.setColor(new Color(iteraciones*4%255, iteraciones%247, iteraciones%237));
                }else if (iteraciones>=2250&&iteraciones<3000) {
                    g.drawLine(xc, yc, xc, yc);
                    g.setColor(new Color(iteraciones%255, 77, 0));
                }else if (iteraciones>=3000&&iteraciones<3750) {
                    g.drawLine(xc, yc, xc, yc);
                    g.setColor(new Color(255, iteraciones%2*255, 3*iteraciones%255));
                }else if (iteraciones>=3750&&iteraciones<4500) {
                    g.drawLine(xc, yc, xc, yc);
                    g.setColor(new Color(4*iteraciones%255, iteraciones%3*30, 50));
                }else{
                    g.drawLine(xc, yc, xc, yc);
                    g.setColor(new Color(iteraciones%18, iteraciones%37, iteraciones%177));
                }
            }
        }
    }
}
