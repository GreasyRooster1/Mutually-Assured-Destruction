package main.java.Game.Scenes.LoseScene.Entities.LoseText;

import main.java.Game.Scenes.GameScene.Spawning.Spawner;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Setup.Setup;
import processing.core.PApplet;
import processing.core.PConstants;

import static processing.core.PApplet.floor;

public class LoseTextRender extends EntityRender {
    @Override
    public void render(Entity e) {
        PApplet applet = Setup.getApplet();
        applet.textSize(50);
        applet.fill(255);
        applet.textAlign(PConstants.CENTER);
        applet.text("YOU LOSE",e.getX(),e.getY());
        applet.textSize(25);
        applet.text("PRESS SPACE TO RESTART",e.getX(),e.getY()+50);
        applet.textSize(15);
        applet.text("You got to level "+ floor(Spawner.difficulty),e.getX(),e.getY()+75);
        applet.stroke(0);
    }
}
