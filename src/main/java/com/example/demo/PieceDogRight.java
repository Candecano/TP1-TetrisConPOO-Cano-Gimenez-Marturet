package com.example.demo;

public class PieceDogRight extends PieceBase {
    public PieceDogRight(int [][] piezas){
        super(piezas);
    }

    @Override
    public void rotarder(){
        int filas = piezas.length;
        int columnas = piezas[0].length;

        int[][] TraspuestadogR = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                TraspuestadogR[j][filas - 1 - i] = piezas[i][j];
            }
        }

        piezas = TraspuestadogR;
    }
//izquierdda
    @Override
    public void rotarizq(){
        int filas = piezas.length;
        int columnas = piezas[0].length;

        int[][] TraspuestadogR = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                TraspuestadogR[columnas - 1 - j][i] = piezas[i][j];
            }
        }

        piezas = TraspuestadogR;
    }












}
