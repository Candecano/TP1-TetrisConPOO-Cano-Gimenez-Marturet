package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PieceLLTest {

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

}