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
    
    // para asegurarse que los elementos de la figura están bien colocados en la misma columna pero dif filas
    for (int fila = 0; fila < 4; fila++) {
        assertEquals(1, tablero[fila][columnaConPieza]);  
    }
}

@Test
    void insertar_pieza_rotada_en_tablero() {
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
       pist.rotarder();
   
        board1.piezas = pist.piezas;
        board1.ingresopiezarotada();

        
        int bloquesInsertados = 0;
        for (int j = 0; j < tablero[0].length; j++) {
            if (tablero[0][j] == 1) {
                bloquesInsertados++;
            }
        }
        assertEquals(4, bloquesInsertados); // Verificar que se insertaron 4 bloques
    }

    @Test
    void ingreso_de_la_pieza_square_al_tablero(){
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
                {1, 1} ,
                {1, 1} 
        };
        
        PieceSquare pSquare = new PieceSquare(piezas);

          board1.piezas= pSquare.piezas;
             board1.ingreso();
//para ver que columna tiene la pieza
        int columnaConPieza = 0;
        for (int col = 0; col < tablero[0].length; col++) {
             if (tablero[0][col] == 1) {
                 columnaConPieza = col;
                 break;
        }
    }
    
    // para asegurarse que los elementos de la figura están bien colocados en la misma columna pero dif filas
         for (int fila = 0; fila < 2; fila++) {
            assertEquals(2, tablero[fila][columnaConPieza]);  
    }

    int bloquesInsertados = 0;
    for (int j = 0; j < tablero[0].length; j++) {
        if (tablero[0][j] == 1) {
            bloquesInsertados++;
        }
    }
    assertEquals(1, bloquesInsertados); // Verificar que se insertaron 4 bloques
}



    @Test
    void ingreso_de_la_pieza_T_al_tablero(){
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
            {1, 1, 1},             
            {0, 1, 0},
      
       };
       PieceT pit = new PieceT(piezas);



        
           board1.piezas= pit.piezas;
             board1.ingreso();

        int columnaConPieza = 0;
        for (int col = 0; col < tablero[0].length; col++) {
             if (tablero[0][col] == 1) {
                 columnaConPieza = col;
                 break;
        }
    }
    
    // para asegurarse que los elementos de la figura están bien colocados
           int desplazamiento= 1;
           int columnadesplazada = columnaConPieza + desplazamiento;

            assertEquals(1, tablero[0][columnaConPieza]);
                      
            assertEquals(0,tablero[1][columnaConPieza]);
            
            assertEquals();

    
    }














}









      

