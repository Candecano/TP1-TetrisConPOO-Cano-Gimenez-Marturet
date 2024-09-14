package com.example.demo;

public class PieceLL extends PieceBase {

    public PieceLL(int[][] piezas) {
        super(piezas);
    }

    @Override
    public void rotarizq() {
        int filas = piezas.length;
        int columnas = piezas[0].length;
    
        int[][] rotadaIzq = new int[columnas][filas];
    
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                
                rotadaIzq[columnas - 1 - j][i] = piezas[i][j];
            }
        }
    
        piezas = rotadaIzq;
    }

    @Override
    public void rotarder(){
        int filas = piezas.length;
        int columnas = piezas[0].length;

        int[][] TraspuestadogLder = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                TraspuestadogLder[j][filas - 1 - i] = piezas[i][j];
            }
        }

        piezas = TraspuestadogLder;
    }










    

}
