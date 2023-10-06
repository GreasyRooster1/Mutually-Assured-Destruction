package main.java.Game.Scenes.GameScene.Entities.Player.PlayerBoostEffect;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

import static processing.core.PApplet.lerp;
import static processing.core.PApplet.min;

public class PlayerBoostEffectRender extends EntityRender {
    @Override
    public void render(Entity e) {
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        applet.fill(0,255,0,e.getLife());
        applet.ellipse(e.getX() + camX, e.getY() + camY, e.getW(), e.getH());
    }
}
