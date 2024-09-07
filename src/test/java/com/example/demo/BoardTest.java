package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardTest {
    @Test
    void construccion_de_tablero(){
        int [][] tablero={
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
            };
            
            Board  board1 = new Board (tablero);
            /*se verifica la cantidad de filas(10) y columnas(20)  */
            assertEquals(10, tablero.length);
            assertEquals(20, tablero[0].length);
            
            /*se verifica que la matriz este llena de 0*/ 
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    assertEquals(0, board1.getTablero(i, j));
                }
            }
              
      }


@Test
void ingreso_de_la_pieza_stick_al_tablero(){

    int [][] tablero={
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    
    Board  board1 = new Board (tablero);

    int[][] piezas = {
        {1},  
        {1},
        {1},
        {1}
   };
   PieceStick pist = new PieceStick(piezas);

board1.piezas= pist.piezas;
board1.ingreso();

int columnaConPieza = 0;
    for (int col = 0; col < tablero[0].length; col++) {
        if (tablero[0][col] == 1) {
            columnaConPieza = col;
            break;
        }
    }
    
    // Asegurarse de que la pieza esté en la misma columna a lo largo de las 4 filas
    for (int fila = 0; fila < 4; fila++) {
        assertEquals(1, tablero[fila][columnaConPieza]);  // Verificar que todas las filas tengan el valor 1 en la misma columna
    }
}




}









      

