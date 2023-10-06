package main.java.Game.Scenes.GameScene.Entities.Projectiles.LazerBomb;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

import static processing.core.PApplet.round;

public class LazerBombRender extends EntityRender {
    @Override
    public void render(Entity e) {
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        applet.fill(applet.lerpColor(applet.color(255,0,0), applet.color(255), round((float) applet.frameCount /10)%2));
        applet.ellipse(e.getX() + camX, e.getY() + camY, e.getW(), e.getH());
    }
}
