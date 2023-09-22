package main.java;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

public class Main extends PApplet{
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
    }
}