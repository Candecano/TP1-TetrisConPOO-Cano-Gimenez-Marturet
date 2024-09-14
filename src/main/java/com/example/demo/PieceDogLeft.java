package com.example.demo;

public class PieceDogLeft extends PieceBase {
    public PieceDogLeft(int [][] piezas){
        super(piezas);
    }

    @Override
    public void rotarizq(){
        int filas = piezas.length;
        int columnas = piezas[0].length;

        int[][] TraspuestadogL = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                TraspuestadogL[columnas - 1 - j][i] = piezas[i][j];
            }
        }

        piezas = TraspuestadogL;
    }

    @Override
    public void rotarder(){
        int filas = piezas.length;
        int columnas = piezas[0].length;

        int[][] TraspuestadogL = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                TraspuestadogL[j][filas - 1 - i] = piezas[i][j];
            }
        }

        piezas = TraspuestadogL;
    }












 
}
