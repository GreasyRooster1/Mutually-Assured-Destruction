package main.java;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;
import main.java.System.Util.Utils;
import processing.core.PApplet;

import java.util.Arrays;

public class Main extends PApplet{
    private int[] keysDown = {};
    public void settings() {
        size(500, 500);
    }

    public void setup() {
        Setup.start(this);
    }

    public void draw() {
        Setup.execution();
    }

    public static void main(String... args) {
        PApplet.main("main.java.Main");
    }

    public void keyReleased() {
        for (Entity e : Setup.getSceneManager().getCurrentScene().entities) {
            e.onKey(key);
        }
        int[] t = {};
        for(int i :keysDown){
            if(i!=keyCode) {
                t = append(t,i);
            }
        }
        keysDown = t;
    }

    public void keyPressed() {
        for(int i :keysDown){
            if(i==keyCode) {
                return;
            }
        }
        keysDown = append(keysDown, keyCode);
    }

    public int[] getKeysDown(){
        return keysDown;
    }
}