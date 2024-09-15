package com.example.demo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TetrisTest {
@Test
  void se_crean_elementos_de_Tetris() {

    //se crea el tablero
    int [][] tablero={
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
  };
  Board  board1 = new Board (tablero);
     
    //se crea una pieza aleatoria
    
     PieceBase piezanueva = new PieceBase();

    int[][] piezaSeleccionada = piezanueva.PiezaAleatoria(piezanueva.PiezaRandom);
    board1.piezas = piezaSeleccionada;
    board1.ingresoPieza();

    //se crea el reloj
    Clock c1 = new Clock();

    c1.Tick();
    assertEquals(1, c1.getTick());
    
  }

  @Test
  void empieza_el_juego() {

     int [][] tablero={
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    Board  board1 = new Board (tablero);

    PieceBase piezanueva = new PieceBase();

    int[][] piezaSeleccionada = piezanueva.PiezaAleatoria(piezanueva.PiezaRandom);
    board1.piezas = piezaSeleccionada;
    board1.ingresoPieza();

    Clock c1 = new Clock();

    c1.Tick();
    assertEquals(1, c1.getTick());
    
    if (c1.getTick() == 1) {
        board1.bajarPieza();
    }

    c1.Tick();
    assertEquals(2, c1.getTick());
    if (c1.getTick() == 2) {
        board1.bajarPieza();
    }
    for (int col = 0; col < tablero[0].length; col++) {
        assertEquals(0, tablero[0][col]);
        assertEquals(0, tablero[1][col]);
    }
  }

  @Test
  void se_gana_el_juego() {

   
    int [][] tablero={
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
      {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
  };
  Board  board1 = new Board (tablero);

    int[][] piezas = {
      {1},  
      {1},
      {1},
      {1}
    };
  PieceStick pist = new PieceStick(piezas);

 

  board1.piezas= pist.piezas;
  for(int col=0; col <tablero[0].length; col++){
      board1.colocarPieza();
  }
   Clock c1 = new Clock();

  while (board1.filaInicial + board1.piezas.length < tablero.length) {
      c1.Tick();  // Avanza el tick
      board1.bajarFILA();  // Baja la pieza
  }

  for (int col = 0; col < tablero[0].length; col++) {
    assertEquals(0, board1.getTablero(4, col));
    assertEquals(0, board1.getTablero(5, col));
}

  int lineCount = board1.lineCount();
  assertEquals(4, lineCount);

  Tetris tetris = new Tetris(tablero);
  assertTrue(tetris.getGana());
}


@Test
  void se_pierde_el_juego() {

    int [][] tablero={
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
      {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1} 

  };
  Board  board1 = new Board (tablero);


  int lineCount = board1.lineCount();
  assertEquals(10, lineCount);

  Tetris tetris = new Tetris(tablero);
  assertTrue(tetris.getPierde());
  Clock c1 = new Clock();

  c1.Tick();
  assertEquals(1, c1.getTick());

  }


}