package com.example.demo;

public class PieceT extends PieceBase{
    public PieceT(int [][] piezas){
        super(piezas);
    }

    @Override
    public void rotarder(){  
    int filas = piezas.length;
    int columnas = piezas[0].length;

    int[][] rotadordepiezasT = new int[columnas][filas];

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            rotadordepiezasT[j][filas - 1 - i] = piezas[i][j];
        }
    }

    piezas = rotadordepiezasT;
    
    }
}
