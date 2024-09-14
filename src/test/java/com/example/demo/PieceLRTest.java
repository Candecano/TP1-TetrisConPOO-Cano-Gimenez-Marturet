package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PieceLRTest {
@Test
void Se_crea_las_piezas_L_right() {
        int[][] piezas = {    
                {1,0},
                {1,0},
                {1,1}
             
       };
       
        PieceLR pil = new PieceLR(piezas);

       
       assertEquals(1, pil.getPiezas(0, 0));
       assertEquals(1, pil.getPiezas(1, 0));
       assertEquals(1, pil.getPiezas(2, 0));
       assertEquals(1, pil.getPiezas(2, 1));

       
        
        }
@Test
void rota_pieza_L_der_a_izquierda() {

        //ROSAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        int[][] piezas = {    
                {1,0},
                {1,0},
                {1,1}
             
       };
       PieceLR pil = new PieceLR(piezas);
       
       assertEquals(1, pil.getPiezas(0, 0));
       assertEquals(1, pil.getPiezas(1, 0));
       assertEquals(1, pil.getPiezas(2, 0));
       assertEquals(1, pil.getPiezas(2, 1));

     
       pil.rotarizq();
       assertEquals(0, pil.getPiezas(0, 0));
       assertEquals(0, pil.getPiezas(0, 1));
       assertEquals(1, pil.getPiezas(0, 2));              //{0, 0, 1}    
       assertEquals(1, pil.getPiezas(1, 1));              //{1, 1, 1},
       assertEquals(1, pil.getPiezas(1, 0));              
       assertEquals(1, pil.getPiezas(1, 2));


       pil.rotarizq();
       assertEquals(1, pil.getPiezas(0, 0));
       assertEquals(1, pil.getPiezas(0, 1));                 //{1, 1},
       assertEquals(0, pil.getPiezas(1, 0));                 //{0, 1},
       assertEquals(1, pil.getPiezas(1, 1));                 //{0, 1}
       assertEquals(0, pil.getPiezas(2, 0));
       assertEquals(1, pil.getPiezas(2, 1));

       pil.rotarizq();
       assertEquals(1, pil.getPiezas(0, 0));
       assertEquals(1, pil.getPiezas(0, 1));               //{1, 1, 1},
       assertEquals(1, pil.getPiezas(0, 2));              // {1, 0, 0}
       assertEquals(1, pil.getPiezas(1, 0));
        
        }

@Test
void vuelta_a_la_pieza_original(){
        int[][] piezas = {    
                {0, 0, 1},
                {1, 1, 1}
              
             
       };
       PieceLR pilrotada = new PieceLR(piezas);

       assertEquals(0, pilrotada.getPiezas(0, 0));
       assertEquals(0, pilrotada.getPiezas(0, 1));
       assertEquals(1, pilrotada.getPiezas(0, 2));              //{0, 0, 1}    
       assertEquals(1, pilrotada.getPiezas(1, 1));              //{1, 1, 1},
       assertEquals(1, pilrotada.getPiezas(1, 0));              
       assertEquals(1, pilrotada.getPiezas(1, 2));
       //vuelta a la pieza l derecha original
       pilrotada.rotarder();
       assertEquals(1, pilrotada.getPiezas(0, 0));
       assertEquals(1, pilrotada.getPiezas(1, 0));
       assertEquals(1, pilrotada.getPiezas(2, 0));
       assertEquals(1, pilrotada.getPiezas(2, 1));

 

}




        
 }