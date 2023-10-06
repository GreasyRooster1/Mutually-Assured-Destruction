package main.java.Game.Scenes.GameScene.Entities.Projectiles.Fighter;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

import static processing.core.PApplet.*;

public class FighterRender extends EntityRender {
    @Override
    public void render(Entity e) {
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        float dir = atan2(e.getYvel(),e.getXvel());
        float dir1 = atan2(e.getYvel(),e.getXvel())+(PI*2)/3;
        float dir2 = atan2(e.getYvel(),e.getXvel())-(PI*2)/3;
        applet.fill(127);
        applet.triangle(e.getX()+cos(dir)*e.getSize(),e.getY()+sin(dir)*e.getSize(),e.getX()+cos(dir1)*e.getSize(),e.getY()+sin(dir1)*e.getSize(),e.getX()+cos(dir2)*e.getSize(),e.getY()+sin(dir2)*e.getSize());
    }
}
