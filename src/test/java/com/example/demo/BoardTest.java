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
        board1.ingresoPieza();

        
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
                {1, 1, 1},
                {1, 0, 0}
             
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
                {1, 1, 1},
                {1, 0, 0}
             
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
        {1, 1, 1},
        {0, 0, 1}
     
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
    board1.bajarPieza();
    board1.bajarPieza();
   
    for (int i = 0; i < tablero.length; i++) {
     for (int j = 0; j < tablero[i].length; j++) {
         System.out.print(tablero[i][j] + " ");
     }
     System.out.println();
     }   
    


}
//test reloj

@Test

void comprueba_tic_x_segundo(){
    Clock c1 = new Clock();

c1.Tick();
assertEquals(1, c1.getTick());

}

@Test
void se_ingresa_una_pieza_en_tablero_y_baja(){
    int[][] tablero = new int[10][20];
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
void se_ingresa_una_pieza_en_tablero_y_baja_L(){
    int[][] tablero = new int[10][20];
    Board  board1 = new Board (tablero);

    int[][] piezas = {    
        {1, 1, 1},
        {1, 0, 0}
     
};
PieceLR pil = new PieceLR(piezas);




   board1.piezas= pil.piezas;
   board1.ingresoPieza();
   board1.bajarPieza();
   
  for (int col = 0; col < tablero[0].length; col++) {
    assertEquals(0, tablero[0][col]);

}
}

}
