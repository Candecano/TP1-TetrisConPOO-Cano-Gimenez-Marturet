package com.example.demo;

public class Tetris extends Board {
    private boolean gana;
    private int pierde; 
    private int lineCount;  

    public Tetris(int[][] tablero) {
        super(tablero);
        this.lineCount = 0;
    }

  
    public boolean getPierde() {
        obtenerlineasconUNO(); 
        return lineCount == 10; 
    }

    public boolean getGana() {
        obtenerlineasconUNO(); 
        return lineCount == 4; 
    }

    public void obtenerlineasconUNO() {
        this.lineCount = lineCount();  
    }

    public int getLineCount() {
        return lineCount;
    }

    public boolean setGana() {
        return gana;
    }

    public void setPierde(int pierde) {
        this.pierde = pierde;
    }

    
}
