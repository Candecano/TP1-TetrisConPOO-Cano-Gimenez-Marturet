package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

        @Test

void rotar_dogright_a_izq_y_dr(){
    int[][] piezas = {
        {0,1,1},
        {1,1,0}

   };
   PieceDogRight pidogRight = new PieceDogRight(piezas);

    assertEquals(1, pidogRight.getPiezas(0, 1));
    assertEquals(1, pidogRight.getPiezas(0, 2));
    assertEquals(1, pidogRight.getPiezas(1, 0));
    assertEquals(1, pidogRight.getPiezas(1, 1));


   //pieza perro mirando a la derecha rotada a la derecha
    pidogRight.rotarder();
      assertEquals(0, pidogRight.getPiezas(0, 1));
      assertEquals(1, pidogRight.getPiezas(0, 0));             //{1, 0}
      assertEquals(1, pidogRight.getPiezas(1, 0));             //{1, 1}
      assertEquals(1, pidogRight.getPiezas(1, 1));             //{0, 1}
      assertEquals(0, pidogRight.getPiezas(2, 0));
      assertEquals(1, pidogRight.getPiezas(2, 1));


//pieza rotada a la derecha, se rota a la derecha y vuelve a la pieza original
      pidogRight.rotarder();
      assertEquals(1, pidogRight.getPiezas(0, 1));               //{0, 1, 1}
      assertEquals(1, pidogRight.getPiezas(0, 2));               //{1, 1, 0}
      assertEquals(1, pidogRight.getPiezas(1, 0));               
      assertEquals(1, pidogRight.getPiezas(1, 1));


//lo mismo sucede rotando la pieza original a la derecha




}


}
