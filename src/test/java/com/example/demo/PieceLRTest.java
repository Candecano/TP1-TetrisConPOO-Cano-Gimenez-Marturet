package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class PieceLRTest {
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