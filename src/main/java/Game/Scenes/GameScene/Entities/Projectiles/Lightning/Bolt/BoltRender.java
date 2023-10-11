package main.java.Game.Scenes.GameScene.Entities.Projectiles.Lightning.Bolt;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

import static processing.core.PApplet.round;

public class BoltRender extends EntityRender {
    @Override
    public void render(Entity e1) {
        Bolt e = (Bolt)e1;
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        applet.stroke(0,255,255,(e.power/100)*255);
        if(e.power>=100){
            if(round((float) Setup.getApplet().frameCount /10)%2==0) {
                applet.stroke(255);
            }
        }
        applet.strokeWeight(e.getSize());
        applet.line(e.getX() + camX, e.getY() + camY, e.getEx() + camX, e.getEy() + camY);
    }
}
