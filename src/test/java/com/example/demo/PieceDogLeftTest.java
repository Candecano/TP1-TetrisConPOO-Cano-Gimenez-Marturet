package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
  @Test
  void rotar_dogleft_a_izq_(){
    int[][] piezas = {
      {1,1,0},
      {0,1,1}
      
 };
      PieceDogLeft pidoglefT = new PieceDogLeft(piezas);
      
      assertEquals(1, pidoglefT.getPiezas(0, 0));
      assertEquals(1, pidoglefT.getPiezas(0, 1));
      assertEquals(1, pidoglefT.getPiezas(1, 1));
      assertEquals(1, pidoglefT.getPiezas(1, 2));

      //se rota la pieza perro izq a la izq

     pidoglefT.rotarizq();
      assertEquals(1, pidoglefT.getPiezas(0, 1));
      assertEquals(0, pidoglefT.getPiezas(0, 0));
      assertEquals(1, pidoglefT.getPiezas(1, 0));
      assertEquals(1, pidoglefT.getPiezas(1, 1));
      assertEquals(1, pidoglefT.getPiezas(2, 0));
      assertEquals(0, pidoglefT.getPiezas(2, 1));
      
//se vuelve a rotar la pieza a la izq y vuelve a su forma original
      pidoglefT.rotarizq();
      assertEquals(1, pidoglefT.getPiezas(0, 0));
      assertEquals(1, pidoglefT.getPiezas(0, 1));
      assertEquals(1, pidoglefT.getPiezas(1, 1));
      assertEquals(1, pidoglefT.getPiezas(1, 2));


  }













                
}
