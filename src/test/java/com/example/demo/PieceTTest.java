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
}
