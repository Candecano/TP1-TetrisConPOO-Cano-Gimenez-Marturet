package com.example.demo;

public class Tetris implements IRotable {
    public int[][] piezas;
    public Tetris(){
    }
   
    public Tetris(int[][] piezas) {
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

}
