package com.example.demo;

public class PieceBase implements IRotable, IIngresa {
    public int[][] piezas;
    public PieceBase(){
    }
   
    public PieceBase(int[][] piezas) {
        this.piezas = piezas;
    }
  
    public int getPiezas(int fila, int columna) {
        return piezas[fila][columna];
    }
    public void setPiezas(int fila, int columna, int valor) {
        piezas[fila][columna] = valor;
    }

    @Override
    public void rotarder() {
       
    }

    @Override
    public void rotarizq(){
        
    }

    @Override
    public void ingreso(){
        
    }

    @Override
    public void ingresopiezarotada(){
        
    }
}
