package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest

public class PieceStickTest {
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
void rotar_pieza_stick_a_la_derecha(){

    int[][] piezas = {
        {1},  
        {1},
        {1},
        {1}
   };
   PieceStick pist = new PieceStick(piezas);
   
pist.rotarder();

assertEquals(1, pist.getPiezas(0,0));
assertEquals(1, pist.getPiezas(0,1));
assertEquals(1, pist.getPiezas(0,2));
assertEquals(1, pist.getPiezas(0,3));

}

@Test
void rotar_pieza_stick_a_la_izquierda(){

    int[][] piezas = {
        {1},  
        {1},
        {1},
        {1}
   };
   PieceStick pist = new PieceStick(piezas);
   
pist.rotarizq();

assertEquals(1, pist.getPiezas(0,3));
assertEquals(1, pist.getPiezas(0,2));
assertEquals(1, pist.getPiezas(0,2));
assertEquals(1, pist.getPiezas(0,1));

}






}
