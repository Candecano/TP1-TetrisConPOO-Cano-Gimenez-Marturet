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
        // Calcular una columna aleatoria válida dentro del rango de columnas del tablero
        int columnaInicial = (int) (Math.random() * tablero[0].length);
    
        // Insertar la pieza verticalmente en la misma columna, comenzando desde la fila 0
        for (int i = 0; i < this.piezas.length; i++) {
            tablero[i][columnaInicial] = this.piezas[i][0];  // Colocar cada bloque en una fila diferente en la misma columna
        }
    }
    




}


















    

    


