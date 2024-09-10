package com.example.demo;

public class Board extends PieceBase{

    public int [][]	 tablero;
    public int ingresoPieza; 

    public Board(int[][] tablero) {
        this.tablero = tablero;
    }

     public int getTablero(int fila, int columna){
        return tablero[fila][columna];
    }
    public void setTablero(int fila, int columna, int valor){
        tablero[fila][columna] = valor;
    }

   

    public void ingresoPieza() {
        //cantidad de columnas disponibles en el tablero, resta de cant de columnas del tablero
        //menos cant de columnas de la pieza
        int columnasDisponibles = tablero[0].length - this.piezas[0].length;
    
        // Columna del tablero en donde irá la pieza teniendo en cuenta las restricciones de la resta
        int columnaInicial = (int) (Math.random() * (columnasDisponibles + 1));
    

        for (int fila = 0; fila < this.piezas.length; fila++) {
            for (int col = 0; col < this.piezas[0].length; col++) {
                // se inserta la pieza en el tablero
                if (this.piezas[fila][col] != 0) {  // se insertan los 1 de la pieza
                    tablero[fila][columnaInicial + col] = this.piezas[fila][col];
                }
            }
        }
    }


//piezas aleatorias para ingresar al tablero














}



















    

    


