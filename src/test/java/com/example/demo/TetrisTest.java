package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TetrisTest {

@Test
void Se_crea_las_piezas_Scuare() {
          int[][] piezas = {    
                {1, 1} ,
                {1, 1} 
        };
        PieceScuare pScuare = new PieceScuare(piezas);
      
        assertEquals(1, pScuare.getPiezas(0, 0));
        assertEquals(1, pScuare.getPiezas(0, 1));
        assertEquals(1, pScuare.getPiezas(1, 0));
        assertEquals(1, pScuare.getPiezas(1, 1));
        
        }
@Test
void Se_crea_las_piezas_L_left() {
        int[][] piezas = {    
             {1, 0, 0},
             {1, 0, 0},
             {1, 1, 0}
        };
        PieceLL pil = new PieceLL(piezas);
        
        assertEquals(1, pil.getPiezas(0, 0));
        assertEquals(1, pil.getPiezas(1, 0));
        assertEquals(1, pil.getPiezas(2, 0));
        assertEquals(1, pil.getPiezas(2, 1));
           
           }
@Test
void Se_crea_las_piezas_L_right() {
        int[][] piezas = {    
                {0, 0, 1},
                {0, 0, 1},
                {0, 1, 1}
        };
        PieceLL pil = new PieceLL(piezas);
        
        assertEquals(1, pil.getPiezas(0, 2));
        assertEquals(1, pil.getPiezas(1, 2));
        assertEquals(1, pil.getPiezas(2, 1));
        assertEquals(1, pil.getPiezas(2, 2));
        
        }
                  

}
        





  



