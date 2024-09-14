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
     //L left
     return new int [][]{
        {1, 1, 1},
        {0, 0, 1}
     
     };


     case 3:

     //L right
     return new int [][]{
        {1, 1, 1},
        {1, 0, 0}
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













}
