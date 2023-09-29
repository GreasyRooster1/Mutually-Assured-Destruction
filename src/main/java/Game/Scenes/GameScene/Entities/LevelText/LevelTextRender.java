package main.java.Game.Scenes.GameScene.Entities.LevelText;

import main.java.Game.Scenes.GameScene.Spawning.Spawner;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Setup.Setup;
import processing.core.PApplet;
import processing.core.PConstants;

import static processing.core.PApplet.floor;

public class LevelTextRender extends EntityRender {
    @Override
    public void render(Entity e) {
        PApplet applet = Setup.getApplet();
        applet.textSize(15);
        applet.fill(255);
        applet.textAlign(PConstants.LEFT);
        applet.text("Level "+floor(Spawner.difficulty),e.getX(),e.getY());
    }
}
