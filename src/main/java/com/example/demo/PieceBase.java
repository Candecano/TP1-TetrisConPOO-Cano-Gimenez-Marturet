package com.example.demo;
import java.util.*;

public class PieceBase implements IRotable {
   
    public int[][] piezas;
    Random random = new Random();
    int PiezaRandom = random.nextInt(7);
    int RotacionRandom= random.nextInt(2);
    
    public PieceBase() {
     
        piezas = PiezaAleatoria(PiezaRandom);
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

    // método y switch para elegir una pieza aleatoria
public int [][] PiezaAleatoria (int PiezaRandom){
       switch (PiezaRandom){
       case 0:
      //dog left
         return new int [][]{
            {1,1,0},
            {0,1,1}
            
         };

      case 1:
      //dog right
      return new int [][]{
        {0,1,1},
        {1,1,0}
        

      };

     case 2:
     //L izquierda
     return new int [][]{
        {0,1},
        {0,1},
        {1,1}
     
     };


     case 3:

     //L derecha
     return new int [][]{
        {1,0},
        {1,0},
        {1,1}
     
     };

    case 4:

    //Square
    return new int [][]{
        {1, 1} ,
        {1, 1}
    };

    case 5:
    //stick
    return new int [][]{
        {1},  
        {1},
        {1},
        {1} 
    };

    case 6:
    //t
    return new int [][]{
        {1, 1, 1},             
        {0, 1, 0},
    };
    default:
    return new int[0][0]; 
  }

}

//rotacion aleatoria
public int[][] RotacionAleatoria(int piezaRandom, int rotacionRandom) {
    int[][] pieza = PiezaAleatoria(piezaRandom); 

    switch (rotacionRandom) {
        case 0:
          
            int filasIzq = pieza.length;
            int columnasIzq = pieza[0].length;
            int[][] rotadaIzq = new int[columnasIzq][filasIzq];

            for (int i = 0; i < filasIzq; i++) {
                for (int j = 0; j < columnasIzq; j++) {
                    rotadaIzq[columnasIzq - 1 - j][i] = pieza[i][j]; 
                }
            }
            pieza = rotadaIzq;
            break;

        case 1:
          
            int filasDer = pieza.length;
            int columnasDer = pieza[0].length;
            int[][] rotadaDer = new int[columnasDer][filasDer];

            for (int i = 0; i < filasDer; i++) {
                for (int j = 0; j < columnasDer; j++) {
                    rotadaDer[j][filasDer - 1 - i] = pieza[i][j]; 
                }
            }
            pieza = rotadaDer;
            break;

        default:
            // Si no hay rotación, devolver la pieza sin cambios
            break;
    }

    return pieza;
}


}
