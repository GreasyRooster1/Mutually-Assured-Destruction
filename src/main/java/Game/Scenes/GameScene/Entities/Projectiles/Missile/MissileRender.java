package main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

public class MissileRender extends EntityRender {
    @Override
    public void render(Entity e) {
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        applet.fill(255,0,0);
        applet.ellipse(e.getX() + camX, e.getY() + camY, e.getW(), e.getH());
    }
}
