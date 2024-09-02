package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class PieceDogRightTest {
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
