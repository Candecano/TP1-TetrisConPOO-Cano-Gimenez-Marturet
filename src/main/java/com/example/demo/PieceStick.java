package com.example.demo;

public class PieceStick extends PieceBase {
    public PieceStick(int [][] piezas){
        super(piezas);
    }
 
@Override

public void rotarder(){
    int filas = piezas.length;
    int columnas = piezas[0].length;

    int[][] TraspuestaStick = new int[columnas][filas];

    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            //se invierten el orden de las filas
            //la ultima fila pasa a ser la primer columna 
            TraspuestaStick[j][filas - 1 - i] = piezas[i][j];
        }
    }

    piezas = TraspuestaStick;
}



@Override
    public void rotarizq(){
        int filas = piezas.length;
        int columnas = piezas[0].length;

        int[][] IzquierdaT = new int[columnas][filas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                //la misma operacion que rotar derecha pero ahora las columnas se cambian
                IzquierdaT[columnas - 1 - j][i] = piezas[i][j];
            }
        }

        piezas = IzquierdaT;
    }






}
