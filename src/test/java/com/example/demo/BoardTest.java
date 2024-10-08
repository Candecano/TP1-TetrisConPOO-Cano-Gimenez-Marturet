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
    board1.ingresoPieza();

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
        //creacion tablero
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
       pist.rotarder(); //[1,1,1,1]
   //se le asigna a board1 la pieza que entrará (el stick)
        board1.piezas = pist.piezas;
        board1.ingresoPieza();
//contador de bloques insertados
//cuenta los elementos "1" que se insertaron
//como quedo el stick "acostado" la pieza ocupa solo la fila 0 y diferentes columnas
        int bloquesInsertados = 0;
        for (int j = 0; j < tablero[0].length; j++) {
            if (tablero[0][j] == 1) {
                bloquesInsertados++;
            }
        }        assertEquals(4, bloquesInsertados); //para verificar que se insertaron los 4 bloques
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
             board1.ingresoPieza();
   
    // para verificar se han insertado 4 bloques
    //ahora se tienen en cuenta las filas y las columnas
    int bloquesInsertados = 0;
    for (int fila = 0; fila < tablero.length; fila++) {
        //se pone tablero[fila] para saber el ancho
        for (int col = 0; col < tablero[fila].length; col++) {
            if (tablero[fila][col] == 1) {
                bloquesInsertados++;
            }
        }
    }

    assertEquals(4, bloquesInsertados);
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
        board1.ingresoPieza();

        int columnaConPieza = 0;
        for (int col = 0; col < tablero[0].length; col++) {
             if (tablero[0][col] == 1 &&  tablero[0][col + 1] == 1 && tablero[0][col + 2] == 1) {
                 
                columnaConPieza = col;
                 break;
        }
    } 
    // primera fila (1 1 1  )
    assertEquals(1, tablero[0][columnaConPieza]);
    assertEquals(1, tablero[0][columnaConPieza + 1]);
    assertEquals(1, tablero[0][columnaConPieza + 2]);

    //  segunda fila (0 1 0)
    assertEquals(0, tablero[1][columnaConPieza]);
    assertEquals(1, tablero[1][columnaConPieza + 1]);
    assertEquals(0, tablero[1][columnaConPieza + 2]);
}
          
@Test
void ingreso_pieza_t_rotada(){
    int [][] tablero = {
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

    Board board1 = new Board(tablero);

    int[][] piezas = {
        {1, 1, 1},             
        {0, 1, 0},
    };
   
    PieceT pit = new PieceT(piezas);
    pit.rotarder();
 
    board1.piezas = pit.piezas;
    board1.ingresoPieza();
    int bloquesInsertados = 0;
    for (int fila = 0; fila < tablero.length; fila++) {
        for (int col = 0; col < tablero[fila].length; col++) {
            if (tablero[fila][col] == 1) {
                bloquesInsertados++;
            }
        }
    }

    
    assertEquals(4, bloquesInsertados);
}

@Test
void ingreso_de_la_pieza_DOGL_al_tablero(){
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
                   {1,1,0},
                   {0,1,1}
        
            };
        PieceDogLeft pidoglefT = new PieceDogLeft(piezas);

            
            
        board1.piezas= pidoglefT.piezas;
        board1.ingresoPieza();
          
    int bloquesInsertados = 0;
    for (int fila = 0; fila < tablero.length; fila++) {
        for (int col = 0; col < tablero[fila].length; col++) {
            if (tablero[fila][col] == 1) {
                bloquesInsertados++;
            }
        }
    }

    assertEquals(4, bloquesInsertados);
}

@Test
void ingreso_de_la_pieza_DOGL_rotada_al_tablero(){
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
                   {1,1,0},
                   {0,1,1}
        
            };
        PieceDogLeft pidoglefT = new PieceDogLeft(piezas);
        pidoglefT.rotarizq();

        board1.piezas= pidoglefT.piezas;
        board1.ingresoPieza();
    
    int bloquesInsertados = 0;
    for (int fila = 0; fila < tablero.length; fila++) {
        for (int col = 0; col < tablero[fila].length; col++) {
            if (tablero[fila][col] == 1) {
                bloquesInsertados++;
            }
        }
    }
    assertEquals(4, bloquesInsertados);
}

@Test
void ingresa_pieza_dog_right_a_tablero(){

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
        {0,1,1},
        {1,1,0}
        
   };
   PieceDogRight pidogRight = new PieceDogRight(piezas);

   board1.piezas= pidogRight.piezas;
   board1.ingresoPieza();

   int bloquesInsertados = 0;
   for (int fila = 0; fila < tablero.length; fila++) {
       for (int col = 0; col < tablero[fila].length; col++) {
           if (tablero[fila][col] == 1) {
               bloquesInsertados++;
           }
       }
   }

   
   assertEquals(4, bloquesInsertados);



}

@Test
void ingresa_pieza_L_right_a_tablero(){

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

   
     //ROSAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        int[][] piezas = {    
            {1,0},
            {1,0},
            {1,1}
       };
       PieceLR pil = new PieceLR(piezas);
       board1.piezas= pil.piezas;
       board1.ingresoPieza();

    int bloquesInsertados = 0;
   for (int fila = 0; fila < tablero.length; fila++) {
       for (int col = 0; col < tablero[fila].length; col++) {
           if (tablero[fila][col] == 1) {
               bloquesInsertados++;
           }
       }
   }

   assertEquals(4, bloquesInsertados);


}

@Test
void ingresa_pieza_L_rotada_right_a_tablero(){
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

     //ROSAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        int[][] piezas = {    
            {1,0},
            {1,0},
            {1,1}
             
       };
       PieceLR pil = new PieceLR(piezas);

        pil.rotarizq();
       board1.piezas= pil.piezas;
       board1.ingresoPieza();
    int bloquesInsertados = 0;
   for (int fila = 0; fila < tablero.length; fila++) {
       for (int col = 0; col < tablero[fila].length; col++) {
           if (tablero[fila][col] == 1) {
               bloquesInsertados++;
           }
       }
   }

   assertEquals(4, bloquesInsertados);

}

@Test
void ingreso_L_left_al_tablero(){

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
        {0,1},
        {0,1},
        {1,1}
     
    };
    PieceLL pil = new PieceLL(piezas);

        board1.piezas= pil.piezas;
        board1.ingresoPieza();

        int bloquesInsertados = 0;
        for (int fila = 0; fila < tablero.length; fila++) {
            for (int col = 0; col < tablero[fila].length; col++) {
                     if (tablero[fila][col] == 1) {
        bloquesInsertados++;
                    }

                }
         }

    assertEquals(4, bloquesInsertados);
}

//pieza aleatoria se ingresa al tablero
@Test
void se_ingresa_una_pieza_aleatoria_en_tablero(){
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

    PieceBase piezanueva = new PieceBase();

    int[][] piezaSeleccionada = piezanueva.PiezaAleatoria(piezanueva.PiezaRandom);
    board1.piezas = piezaSeleccionada;
    board1.ingresoPieza();
}

//test reloj
@Test
//se crea reloj
void comprueba_tic_x_segundo(){
    Clock c1 = new Clock();

    c1.Tick();
    //se "llama" al metodo Tick que es igual a 1
    assertEquals(1, c1.getTick());
}

//sin clock
@Test
void se_ingresa_una_pieza_en_tablero_y_baja(){
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
   board1.ingresoPieza();
   board1.bajarPieza();
  
   for (int col = 0; col < tablero[0].length; col++) {
    assertEquals(0, tablero[0][col]);
}
}
  
@Test
void se_ingresa_una_pieza_aleatoria_en_tablero_y_baja(){
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

    PieceBase piezanueva = new PieceBase();

    int[][] piezaSeleccionada = piezanueva.PiezaAleatoria(piezanueva.PiezaRandom);
    board1.piezas = piezaSeleccionada;
    board1.ingresoPieza();
    board1.bajarPieza();
    
   for (int col = 0; col < tablero[0].length; col++) {
    assertEquals(0, tablero[0][col]);
}
}

@Test
void se_ingresa_una_pieza_aleatoria_en_tablero_y_baja_por_segundo(){
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
//pieza aleatoria
    PieceBase piezanueva = new PieceBase();
//se selecciona de forma aleatoria la pieza
//metodo PiezaAleatoria, que recibe como parametro PiezaRandom(numero random de 0 a 7)
//entonces se elige una pieza dentro de los diferentes numeros que da PiezaRandom
    int[][] piezaSeleccionada = piezanueva.PiezaAleatoria(piezanueva.PiezaRandom);
    //pieza que ingresara al tablero
    board1.piezas = piezaSeleccionada;
    board1.ingresoPieza();

    // se crea un objeto c1
    Clock c1 = new Clock();

    c1.Tick();
    assertEquals(1, c1.getTick());
    // se crea una condicional para que cada vez que se cree un tick se se ejecute el metodo de bajar la pieza
    //se crea un tick a la vez
    if (c1.getTick() == 1) {
        board1.bajarPieza();
    }

    //se crea el tick por segunda vez, se suma al anterior
    c1.Tick();
    assertEquals(2, c1.getTick());
    if (c1.getTick() == 2) {
        board1.bajarPieza();
    }

    // se  pregunta si hay piezas en la primera y segunda fila del tablero, lo que siginifica que la pieza bajo 2 filas
    for (int col = 0; col < tablero[0].length; col++) {
        assertEquals(0, tablero[0][col]);
        assertEquals(0, tablero[1][col]);
    } 
}

@Test
void se_ingresa_una_perroizq_en_tablero_y_baja_por_segundo_y_gira(){
    
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
                   {1,1,0},
                   {0,1,1}
        
            };
        PieceDogLeft pidoglefT = new PieceDogLeft(piezas);
        pidoglefT.rotarizq();

        board1.piezas= pidoglefT.piezas;
        board1.ingresoPieza();
        Clock c1 = new Clock();
        //baja la pieza rotada una posicion hacia abajo
        c1.Tick(); 
        if (c1.getTick() == 1) {
        board1.bajarPieza();
        }
        for (int col = 0; col < tablero[0].length; col++) {
            assertEquals(0, tablero[0][col]);
        }

}
//no se pueden ingresar más piezas a la primera linea
@Test
void no_se_puede_ingresar_mas_piezas(){
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

    board1.piezas= pist.piezas;
    board1.colocarPieza();
    board1.colocarPieza();
    board1.colocarPieza();
    board1.colocarPieza();
    board1.colocarPieza();
   
    
    for (int col = 0; col < tablero[0].length; col++) {
        assertEquals(1, board1.getTablero(0, col));
    }
   

 
}
   
@Test
void si_se_llena_de_1_la_primera_fila_desaparece(){

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
    board1.colocarPieza();
    board1.colocarPieza();
    board1.colocarPieza();
    board1.colocarPieza();
    board1.colocarPieza();

    board1.eliminarFila();
    //fila 0 se recorre para asegurarse de que esté vacia
    for (int col = 0; col < tablero[0].length; col++) {
        assertEquals(0, board1.getTablero(0, col));
    }
}

@Test
void se_llena_2_lineas(){

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
    //se colocan las piezas teniendo en cuenta el ancho que va quedando del tablero
    for(int col=0; col <tablero[0].length; col++){
        board1.colocarPieza();
    }
    
    for (int col = 0; col < tablero[0].length; col++) {
        assertEquals(1, board1.getTablero(0, col));
        assertEquals(1, board1.getTablero(1, col));
    }
}

@Test
void se_baja_toda_una_linea(){
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

    board1.piezas= pist.piezas;
    for(int col=0; col <tablero.length; col++){
        board1.colocarPieza();
    }
     Clock c1 = new Clock();

    while (board1.filaInicial + board1.piezas.length < tablero.length) {
        c1.Tick();  // Avanza el tick
        board1.bajarFILA();  // Baja la fila
    }

    for (int col = 0; col < tablero[0].length; col++) {
        assertEquals(1, board1.getTablero(9, col));
    }
    
}

@Test 
void ingresa_pieza_aleatoria_con_rot_aleatoria(){
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
    PieceBase piezanueva = new PieceBase();

     int piezaRandom = piezanueva.PiezaRandom;
    int rotacionRandom = piezanueva.RotacionRandom;
    int[][] piezaRotada = piezanueva.RotacionAleatoria(piezaRandom, rotacionRandom);

    board1.piezas = piezaRotada;
    board1.ingresoPieza();

 int bloquesInsertados = 0;
    for (int fila = 0; fila < tablero.length; fila++) {
        //se pone tablero[fila] para saber el ancho
        for (int col = 0; col < tablero[fila].length; col++) {
            if (tablero[fila][col] == 1) {
                bloquesInsertados++;
            }

       
        }
}
    assertEquals(4, bloquesInsertados);

}

//para mejorar cobertura
@Test
void se_prueba_case0_rotacion_pieza_aleatoria_izq(){
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

    PieceBase piezanueva = new PieceBase();

    int piezaRandom = piezanueva.PiezaRandom;
    int rotacionRandom = 0; //case
    int[][] piezaRotada = piezanueva.RotacionAleatoria(piezaRandom, rotacionRandom);

    board1.piezas = piezaRotada;
    board1.ingresoPieza();

    //contar si hay 1 en tablero
    //si hay cuatro 1 quiere decir que se ingreso una pieza

    int bloquesInsertados = 0;
    for (int fila = 0; fila < tablero.length; fila++) {
        for (int col = 0; col < tablero[fila].length; col++) {
            if (tablero[fila][col] == 1) {
                bloquesInsertados++;
        }
    }
    }

    assertEquals(4, bloquesInsertados);

}

@Test
void se_prueba_case1_rotacion_pieza_aleatoria_(){
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

    PieceBase piezanueva = new PieceBase();

    int piezaRandom = piezanueva.PiezaRandom;
    int rotacionRandom = 1; //case
    int[][] piezaRotada = piezanueva.RotacionAleatoria(piezaRandom, rotacionRandom);

    board1.piezas = piezaRotada;
    board1.ingresoPieza();

    int bloquesInsertados = 0;
    for (int fila = 0; fila < tablero.length; fila++) {
        for (int col = 0; col < tablero[fila].length; col++) {
            if (tablero[fila][col] == 1) {
                bloquesInsertados++;
            }
        }
    }
 
    
    assertEquals(4, bloquesInsertados);





}












   
}

