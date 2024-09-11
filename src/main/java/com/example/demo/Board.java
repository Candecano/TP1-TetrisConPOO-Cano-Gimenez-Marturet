package com.example.demo;

public class Board extends PieceBase{

    public int [][]	 tablero;
    public int ingresoPieza; 

     // Columna inicial
      // Fila para manejar la posición de la pieza
     int columnaInicial;
 

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
         columnaInicial = (int) (Math.random() * (columnasDisponibles + 1));
    

        for (int fila = 0; fila < this.piezas.length; fila++) {
            for (int col = 0; col < this.piezas[0].length; col++) {
                // se inserta la pieza en el tablero
                if (this.piezas[fila][col] != 0) {  // se insertan los 1 de la pieza
                    tablero[fila][columnaInicial + col] = this.piezas[fila][col];
                }
            }
        }
    }




//bajar pieza

public void bajarPieza() {
   int fila = 0; 
    if (fila + this.piezas.length >= tablero.length) {
        return; 
    }

  
    for (int f = 0; f < this.piezas.length; f++) {
        for (int col = 0; col < this.piezas[0].length; col++) {
            if (this.tablero[fila + f][columnaInicial + col] == 1) {
                this.tablero[fila + f][columnaInicial + col] = 0;
            }
        }
    }

    fila++; 
   
    for (int f = 0; f < this.piezas.length; f++) {
        for (int col = 0; col < this.piezas[0].length; col++) {
            if (this.piezas[f][col] == 1) {
                tablero[fila + f][columnaInicial + col] = 1;
            }
        }
    }
}
}







    

    


