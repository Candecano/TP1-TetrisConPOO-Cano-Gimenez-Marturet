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
       int columnasDisponibles = tablero[0].length - this.piezas.length;
        int columnaInicial = (int) (Math.random() * columnasDisponibles);
        // Colocar la pieza en la fila 0 y columna aleatoria
        for (int i = 0; i < this.piezas.length; i++) {
            if (columnaInicial + i < tablero[0].length) {
                tablero[0][columnaInicial + i] = this.piezas[i][0]; 
            }
        }
    }

    

    
}

