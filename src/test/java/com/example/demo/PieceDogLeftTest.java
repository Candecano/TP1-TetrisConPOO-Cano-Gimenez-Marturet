package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PieceDogLeftTest {
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
}
