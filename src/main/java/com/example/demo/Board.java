package com.example.demo;

public class Board extends PieceBase{

    public int [][]	 tablero;

    public Board(int[][] tablero) {
        this.tablero = tablero;
    }

     public int getTablero(int fila, int columna){
        return tablero[fila][columna];
    }
    public void setTablero(int fila, int columna, int valor){
        tablero[fila][columna] = valor;
    }
    @Override
    public void ingreso() {
        //columna aleatoria dentro de las 20 columnas del tablero
        int columnaInicial = (int) (Math.random() * tablero[0].length);
    
        // se inserta la pieza desde la fila 0
        for (int i = 0; i < this.piezas.length; i++) {
            //se coloca el resto de elementos de la pieza, debajo del primer elemento
            tablero[i][columnaInicial] = this.piezas[i][0]; 
        }
    }
    




}


















    

    


