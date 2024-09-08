package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest

public class PieceTTest {
    @Test
 
                void construccion_de_pieza_T(){
                //1 representa al "elemento " que forma la pieza
                int[][] piezas = {
                     {1, 1, 1},             
                     {0, 1, 0},
               
                };
                PieceT pit = new PieceT(piezas);
                
                // Verifica los valores
                assertEquals(1, pit.getPiezas(0, 0));
                assertEquals(1, pit.getPiezas(0, 1));
                assertEquals(1, pit.getPiezas(0, 2));
                assertEquals(1, pit.getPiezas(1, 1));
                
                }


     @Test
 
                void rotacion_pieza_der_T(){
                    
                    
              //1 representa al "elemento " que forma la pieza
              int[][] piezas = {
                   {1, 1, 1},             
                   {0, 1, 0},
              };
              PieceT pit = new PieceT(piezas);
              
              // se rota la pieza hacia la derecha 
              assertEquals(1, pit.getPiezas(0, 0));
              assertEquals(1, pit.getPiezas(0, 1));
              assertEquals(1, pit.getPiezas(0, 2));
              assertEquals(1, pit.getPiezas(1, 1));

              pit.rotarder();
              assertEquals(1, pit.getPiezas(0, 1));
              assertEquals(0, pit.getPiezas(0, 0));       //{0, 1}
              assertEquals(1, pit.getPiezas(1, 0));       //{1, 1}
              assertEquals(1, pit.getPiezas(1, 1));       //{0, 1}
              assertEquals(0, pit.getPiezas(2, 0));
              assertEquals(1, pit.getPiezas(2, 1));

              pit.rotarder();
              assertEquals(1, pit.getPiezas(0, 1));
              assertEquals(0, pit.getPiezas(0, 0));
              assertEquals(0, pit.getPiezas(0, 2));        //{0, 1, 0}
              assertEquals(1, pit.getPiezas(1, 0));        //{1, 1, 1}
              assertEquals(1, pit.getPiezas(1, 1));       
              assertEquals(1, pit.getPiezas(1, 2));

              pit.rotarder();
              assertEquals(0, pit.getPiezas(0, 1));
              assertEquals(1, pit.getPiezas(0, 0));
              assertEquals(1, pit.getPiezas(1, 0));          //{1, 0}
              assertEquals(1, pit.getPiezas(1, 1));          //{1, 1}
              assertEquals(1, pit.getPiezas(2, 0));          //{1, 0}
              assertEquals(0, pit.getPiezas(2, 1));

                         



                }

                
}
