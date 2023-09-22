package main.java.Game.Scenes.LoseScene.Entities.LoseText;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Setup.Setup;
import processing.core.PApplet;
import processing.core.PConstants;

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
        applet.stroke(0);
    }
}
