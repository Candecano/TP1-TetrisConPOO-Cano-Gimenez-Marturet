package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class PieceSquareTest {
@Test
void Se_crea_las_piezas_Square() {
          int[][] piezas = {    
                {1, 1} ,
                {1, 1} 
        };
        
        PieceSquare pSquare = new PieceSquare(piezas);
      
        assertEquals(1, pSquare.getPiezas(0, 0));
        assertEquals(1, pSquare.getPiezas(0, 1));
        assertEquals(1, pSquare.getPiezas(1, 0));
        assertEquals(1, pSquare.getPiezas(1, 1));
        
        }
        
        }