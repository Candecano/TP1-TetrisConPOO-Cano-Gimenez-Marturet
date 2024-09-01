package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TetrisTest {

        @Test
 
        void construccion_de_pieza_T(){
        //1 representa al "elemento " que forma la pieza
        int[][] piezas = {
             {0, 1, 0},
             {1, 1, 1}
        };
        PieceT pit = new PieceT(piezas);
        
        // Verifica los valores
        assertEquals(1, pit.getPiezas(0, 1));
        assertEquals(1, pit.getPiezas(1, 0));
        assertEquals(1, pit.getPiezas(1, 1));
        assertEquals(1, pit.getPiezas(1, 2));
        
        }
    
        @Test 
    
        void construccion_de_pieza_stick(){
             int[][] piezas = {
                  {1},
                  {1},
                  {1},
                  {1}
             };
             PieceStick pist = new PieceStick(piezas);
             
            
             assertEquals(1, pist.getPiezas(0, 0));
             assertEquals(1, pist.getPiezas(1, 0));
             assertEquals(1, pist.getPiezas(2, 0));
             assertEquals(1, pist.getPiezas(3, 0));
             
        }
        
        @Test
        void construccion_pieza_dog_left(){
            int[][] piezas = {
                {1,1,0},
                {0,1,1}
                
           };
           PieceDogLeft pidoglefT = new PieceDogLeft(piezas);
           
          
           assertEquals(1, pidoglefT.getPiezas(0, 0));
           assertEquals(1, pidoglefT.getPiezas(0, 1));
           assertEquals(1, pidoglefT.getPiezas(1, 1));
           assertEquals(1, pidoglefT.getPiezas(1, 2));
    
        }
        
    @Test
    
    void construccion_pieza_dog_right(){
    
        int[][] piezas = {
            {0,1,1},
            {1,1,0}
            
       };
       PieceDogRight pidogRight = new PieceDogRight(piezas);
       
      
       assertEquals(1, pidogRight.getPiezas(0, 1));
       assertEquals(1, pidogRight.getPiezas(0, 2));
       assertEquals(1, pidogRight.getPiezas(1, 0));
       assertEquals(1, pidogRight.getPiezas(1, 1));
    
    
    
    
    
    
    
    }
}
        





  



