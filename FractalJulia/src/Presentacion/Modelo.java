/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Alejandro Riveros
 */
public class Modelo {
    private Canvas lienzo;
    private Graphics g2;
    private Graphics g;
    private int width;
    private int height;
    private Vista ventana;
    private boolean isDraw;
    private BufferedImage buffer;//Se utiliza un bufferImage para evitar el mal renderizado del dibujo
    public Modelo(){
        isDraw=false;
    }
    
    public void iniciar(){
        getVentana().setSize(1195, 800);
        getVentana().getBoton().setText("Dibujar");
        getVentana().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getVentana().setLocationRelativeTo(null);
        getVentana().setResizable(false);
        getVentana().setVisible(true);
        getVentana().getLienzo().setSize(969, 651);
        getVentana().getLabelMensaje().setText("");
    }
    public void limpiarCanvas(){
        lienzo=getVentana().getLienzo();
        buffer=new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
        g=lienzo.getGraphics();
        g2=buffer.getGraphics();
        width=lienzo.getWidth();
        height=lienzo.getHeight();
        g2.setColor(lienzo.getBackground());
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                g2.drawLine(x, y, x, y);
                g2.setColor(Color.black);
            }
        }
        g.drawImage(buffer, 0, 0, lienzo);
    }
    public void dibujarFractalMandelbrot(){
        lienzo=getVentana().getLienzo();
        buffer=new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
        g=lienzo.getGraphics();
        g2=buffer.getGraphics();
        width=lienzo.getWidth();
        height=lienzo.getHeight();
        g2.setColor(lienzo.getBackground());
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                double a=normalizar(x,0,width,-2.0,2.0);
                double b=normalizar(y,0,height,-2.0,2.0);
                double ca=a;
                double cb=b;
                int n=0;
                while(n<5000 && a*a+b*b<16){
                    double aa=a*a -b*b;
                    double bb=2*a*b;
                    a=aa+ca;
                    b=bb+cb;
                    n++;
                }
                if(n>=0 && n<750){
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(4*n%255, n%3*30, 50));
                }else if (n>=750&&n<1500) {
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(100, n*3%50, n%255));
                }else if (n>=1500&&n<2250) {
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(n*4%255, n%247, n%237));
                }else if (n>=2250&&n<3000) {
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(n%255, 77, 0));
                }else if (n>=3000&&n<3750) {
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(255, n%2*255, 3*n%255));
                }else if (n>=3750&&n<4500) {
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(4*n%255, n%3*30, 50));
                }else{
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(n%18, n%37, n%177));
                }
            }
        }
        g.drawImage(buffer, 0, 0, lienzo);
    }
    public void casoDibujo(int caso){
        switch (caso){
            case 0:
                break;
            case 1:
                dibujarFractalMandelbrot();
                break;
            default:
                dibujarFractalJulia(caso);
                break;
        }
        
    }
    public void dibujarFractalJulia(int caso){
        double newMin=-2.0;
        double newMax=2.0;
        double ca=0;
        double cb=0;
        switch(caso){
            case 2:
               newMin=-1.1;
               newMax=1.1;
               ca=0.285;
               cb=0.01;
               break;
            case 3:
                newMin=-1.5;
                newMax=1.5;
                ca=-0.70176;
                cb=-0.3842;
                break;
            case 4:
                newMin=-1.5;
                newMax=1.5;
                ca=-0.835;
                cb=-0.2321;
                break;
            case 5:
                newMin=-1.3;
                newMax=1.3;
                ca=-0.8;
                cb=0.156;
                break;
            case 6:
                newMin=-1.2;
                newMax=1.2;
                ca=-0.7269;
                cb=0.1889;
                break;
            case 7:
                newMin=-1.4;
                newMax=1.4;
                ca=-0.4;
                cb=0.6;
                break;
            case 8:
                newMin=-0.9;
                newMax=0.00000099;
                ca=-0.59;
                cb=0;
                break;
            case 9:
                newMin=-0.9;
                newMax=0.000009;
                ca=-0.621;
                cb=0;
                break;
            case 10:
                newMin=-1.5;
                newMax=1.5;
                ca=-0.8;
                cb=0;
                break;
        }
        lienzo=getVentana().getLienzo();
        buffer=new BufferedImage(lienzo.getWidth(), lienzo.getHeight(), BufferedImage.TYPE_INT_ARGB);
        g=lienzo.getGraphics();
        g2=buffer.getGraphics();
        width=lienzo.getWidth();
        height=lienzo.getHeight();
        g2.setColor(lienzo.getBackground());
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                double a=normalizar(x,0,width,newMin,newMax);
                double b=normalizar(y,0,height,newMin,newMax);
                int n=0;
                while(n<1000 && a*a+b*b<4){
                    double aa;
                    double bb;
                    if(caso==2||caso==3 || caso==4|| caso==5||caso==6|| caso==7||caso==10){
                        aa=a*a - b*b;
                        bb=2*a*b;
                    }else{
                        aa=(Math.exp((Math.pow(a, 3))-3*a*Math.pow(b, 2)))*Math.cos((3*b*Math.pow(a, 2))-Math.pow(b, 3));
                        bb=(Math.exp((Math.pow(a, 3))-3*a*Math.pow(b, 2)))*Math.sin((3*b*Math.pow(a, 2))-Math.pow(b, 3));
                    }
                    a=aa+ca;
                    b=bb+cb;
                    n++;
                }
                if(n>=0 && n<750){
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(4*n%255, n%3*30, 50));
                }else if (n>=750&&n<1500) {
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(100, n*3%50, n%255));
                }else if (n>=1500&&n<2250) {
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(n*4%255, n%247, n%237));
                }else if (n>=2250&&n<3000) {
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(n%255, 77, 0));
                }else if (n>=3000&&n<3750) {
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(255, n%2*255, 3*n%255));
                }else if (n>=3750&&n<4500) {
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(4*n%255, n%3*30, 50));
                }else{
                    g2.drawLine(x, y, x, y);
                    g2.setColor(new Color(n%18, n%37, n%177));
                }
            }
        }
        g.drawImage(buffer, 0, 0, lienzo);
    }
    public void dibujar(){
        getVentana().lblMensaje();
        if(isDraw){
            isDraw=false;
            getVentana().getBoton().setText("Dibujar");
            getVentana().getLabelMensaje().setText("");
            getVentana().encenderBotones();
            getVentana().setSize(1195 , 800);
            limpiarCanvas();
        }else{
            isDraw=true;
            getVentana().getBoton().setText("Borrar");
            getVentana().apagarBotones();
            getVentana().setSize(1195, 800);
            casoDibujo(getVentana().rbtnSeleccionado());
        }
    }
    public double normalizar(double x,double min,double max,double newMin,double newMax){
        return  (x-min)/(max-min) * (newMax-newMin)+newMin;
    }
    
    public Vista getVentana(){
        if(ventana==null){
            ventana=new Vista(this);
        }
        return ventana;
    }
    
}
