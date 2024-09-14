package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PieceLLTest {

  @Test
  void Se_crea_las_piezas_L_left() {

     //AMARILLO
             int[][] piezas = {    
                  {0,1},
                  {0,1},
                  {1,1}
               
         };
         PieceLL pil = new PieceLL(piezas);
         
         assertEquals(1, pil.getPiezas(0, 1));
         assertEquals(1, pil.getPiezas(1, 1));
         assertEquals(1, pil.getPiezas(2, 1));
         assertEquals(1, pil.getPiezas(2, 0));
          
           
        

        }

        @Test
  void rotacion_de_la_pieza_L_left_izq_y_der() {
             int[][] piezas = {    
                {0,1},
                {0,1},
                {1,1}
               
         };
         PieceLL pil = new PieceLL(piezas);

         assertEquals(1, pil.getPiezas(0, 1));
         assertEquals(1, pil.getPiezas(1, 1));
         assertEquals(1, pil.getPiezas(2, 1));
         assertEquals(1, pil.getPiezas(2, 0));

         pil.rotarizq();
         
         assertEquals(1, pil.getPiezas(0, 0));//(1,1,1)
         assertEquals(1, pil.getPiezas(0, 1));//(0,0,1)
         assertEquals(1, pil.getPiezas(0, 2));
         assertEquals(1, pil.getPiezas(1, 2));
          
        pil.rotarder();
         assertEquals(0, pil.getPiezas(0, 0));
         assertEquals(1, pil.getPiezas(0, 1));
         assertEquals(0, pil.getPiezas(1, 0));           //{0, 1}
         assertEquals(1, pil.getPiezas(1, 1));           //{0, 1}
         assertEquals(1, pil.getPiezas(2, 1));           //{1, 1}
         assertEquals(1, pil.getPiezas(2, 0));
         

         pil.rotarder();
         assertEquals(1, pil.getPiezas(0, 0));
         assertEquals(0, pil.getPiezas(0, 1));           //{1, 0, 0}
         assertEquals(0, pil.getPiezas(0, 2));           //{1, 1, 1}
         assertEquals(1, pil.getPiezas(1, 0));
         assertEquals(1, pil.getPiezas(1, 1));
         assertEquals(1, pil.getPiezas(1, 2));

         pil.rotarder();
         assertEquals(1, pil.getPiezas(0, 0));
         assertEquals(1, pil.getPiezas(0, 1));
         assertEquals(1, pil.getPiezas(1, 0));            //{1, 1}
         assertEquals(0, pil.getPiezas(1, 1));            //{1, 0}
         assertEquals(1, pil.getPiezas(2, 0));            //{1, 0}
         assertEquals(0, pil.getPiezas(2, 1));

         
        }

        
       

}