package com.example.demo;

public class PieceLR extends PieceBase {

    public PieceLR(int[][] piezas) {
        super(piezas);
    }

   
    @Override
    public void rotarizq(){
        int filas = piezas.length;
        int columnas = piezas[0].length;

        int[][] TraspuestaL = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                TraspuestaL[j][filas - 1 - i] = piezas[i][j];
            }
        }

        piezas = TraspuestaL;
    }

}
