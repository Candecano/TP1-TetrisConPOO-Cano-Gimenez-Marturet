package com.example.demo;

public class Board extends PieceBase{

    public int [][]	 tablero;
    public int ingresoPieza; 
    public int  columnasDisponibles; 

    int filaInicial = 0; 


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
        columnasDisponibles = tablero[0].length - this.piezas[0].length;
    
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

    public void colocarPieza(){

        int espacioLibre = 0;
        columnaInicial = 0;
        
        for (int col = 0; col < tablero[0].length; col++) {
            boolean columnaVacia = true;
            
         
            for (int fila = 0; fila < tablero.length; fila++) {
                if (tablero[fila][col] != 0) {
                    columnaVacia = false;
                    break;
                }
            }
            
            if (columnaVacia) {
                espacioLibre++;
            } else {
                espacioLibre = 0;  
            }
    
            if (espacioLibre >= this.piezas[0].length) {
                columnaInicial = col - espacioLibre + 1;
                break;
            }
        }
        
        for (int fila = 0; fila < this.piezas.length; fila++) {
            for (int col = 0; col < this.piezas[0].length; col++) {
                if (this.piezas[fila][col] != 0) {
                    tablero[fila][columnaInicial + col] = this.piezas[fila][col];
                }
            }
        }
            
}

public void eliminarFila() {
    
    for (int fila = 0; fila < this.tablero.length; fila++) {
        for (int col = 0; col < this.tablero[0].length; col++) {
            if (this.tablero[fila][col] == 1) {
                tablero[fila][col] = 0;
            }
        }
    }
}

            
        
    
//bajar pieza

public void bajarPieza() {

    if (filaInicial + piezas.length < tablero.length) {
        // Usamos un solo bucle para eliminar la pieza anterior y moverla hacia abajo
        for (int fila = 0; fila < this.piezas.length; fila++) {
            for (int col = 0; col < this.piezas[0].length; col++) {
                if (this.piezas[fila][col] != 0) {
                    
                    // Eliminar la pieza de la posición actual
                    tablero[filaInicial + fila][columnaInicial + col] = 0;
                }
            }
        }
        filaInicial++;  // Mover la pieza hacia abajo
        
        //Colocamos la pieza en la posicion siguiente
        for (int fila = 0; fila < this.piezas.length; fila++) {
            for (int col = 0; col < this.piezas[0].length; col++) {
                if (this.piezas[fila][col] != 0) {
                    if (tablero[filaInicial + fila][columnaInicial + col] >= 0 && tablero[filaInicial + fila][columnaInicial + col] < tablero.length && tablero[filaInicial + fila][columnaInicial + col] < tablero[0].length  ) {
                        tablero[filaInicial + fila][columnaInicial + col] = piezas[fila][col];
                    }
                }
    }
}

}

}

  
}








    

    


