package com.example.demo;

public class Clock {
    int count=0;
    public int tick;

    public void Tick(){
        count++;
    }

	public int getTick(){
        return count;
    }
    
    public void setTick(int value){
        count = value;
    }
    



}
