package com.example.demo;

public class Board extends PieceBase {
    //heredamos la clase PieceBase porque para Board necesitabamos la piezas que las definimos en PieceBase
    //y en esta clase nos centramos principalmente en el tablero

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
   

   

    public void ingresoPieza() {
        //cantidad de columnas disponibles en el tablero, resta de cant de columnas del tablero
        //menos cant de columnas de la pieza
        columnasDisponibles = tablero[0].length - this.piezas[0].length;
    
        // Columna del tablero en donde irá la pieza teniendo en cuenta las restricciones de la resta
         columnaInicial = (int) (Math.random() * (columnasDisponibles + 1));// mas uno por que sin eso no llega a ser un valor entero
    

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
            
            //verifica si en el tablero hay suficiente espacio para colocar la siguiente pieza inmediatamente al lado
            for (int fila = 0; fila < tablero.length; fila++) {
                if (tablero[fila][col] != 0) {
                    columnaVacia = false;
                    break;
                }
            }
            
            //es para saber cuanto espacio libre existe en el tablero
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
        
        //se coloca la pieza
        for (int fila = 0; fila < this.piezas.length; fila++) {
            for (int col = 0; col < this.piezas[0].length; col++) {
                if (this.piezas[fila][col] != 0) {
                    tablero[fila][columnaInicial + col] = this.piezas[fila][col];
                }
                else {
                   
                    tablero[fila][columnaInicial + col] = 0;
                }



            }
        }
            
}

public void bajarFILA(){
   
    for (int fila = filaInicial; fila < filaInicial + piezas.length; fila++) {
        if (fila + 1 < tablero.length) {  // verifica que no se salga del tablero
            for (int col = 0; col < tablero[0].length; col++) {
                tablero[fila + 1][col] = tablero[fila][col];  // mueve la fila para abajo
                tablero[fila][col] = 0;  //vaciar la fila actual
            }
        }
    }
    
    filaInicial++; 
    for (int fila = 0; fila < this.piezas.length; fila++) {
        for (int col = 0; col < this.piezas[0].length; col++) {
            if (this.piezas[fila][col] != 0) {
                tablero[filaInicial + fila][columnaInicial + col] = piezas[fila][col];
            }else {
                
                tablero[filaInicial + fila][columnaInicial + col] = 0; // Deja el valor como cero
            }

        }
    }
}

public void eliminarFila() {
    for (int fila = 0; fila < this.tablero.length; fila++) {
        for (int col = 0; col < this.tablero[0].length; col++) {
            //elimina todo los 1 y los intercambia por 0
            if (this.tablero[fila][col] == 1) {
                tablero[fila][col] = 0;
            }
        }
    }
}

//bajar pieza
public void bajarPieza() {
    //limpia la fila donde se encuentra la pieza
    //indica que la pieza no exceda las filas del tablero
       if (filaInicial + piezas.length < tablero.length) {
        // Usamos un solo bucle para eliminar la pieza anterior y moverla hacia abajo
        for (int fila = 0; fila < this.piezas.length; fila++) {
            for (int col = 0; col < this.piezas[0].length; col++) {
                if (this.piezas[fila][col] != 0) {
                    // Eliminar la pieza de la posición actual
                    tablero[filaInicial + fila][columnaInicial + col] = 0;
                }else {
                    tablero[filaInicial + fila][columnaInicial + col] = tablero[filaInicial + fila][columnaInicial + col];
                }
            }
        }
        //al limpiar la posicion anterior se baja a la fila inferior para colocar la pieza
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
public int lineCount() {
    int contadorLineas = 0;

    // Iterar sobre cada fila del tablero
    for (int fila = 0; fila < tablero.length; fila++) {
        for (int col = 0; col < tablero[0].length; col++) {
            if (tablero[fila][col] == 1) {
                contadorLineas++;  
                break;  
            }
        }
    }

    return contadorLineas;  

}
}







    

    


