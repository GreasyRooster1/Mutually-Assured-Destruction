package main.java.Game.Scenes.GameScene.Entities.Player;

import main.java.Game.Scenes.GameScene.Entities.Player.PlayerBoostEffect.PlayerBoostEffect;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

import static processing.core.PApplet.min;

public class PlayerRender extends EntityRender {
    @Override
    public void render(Entity e) {
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();

        if(((Player)e).getIFrames()>0){
            applet.fill(0,255,255);
        }else{
            applet.fill(0,255,0);
        }
        applet.ellipse(e.getX() + camX, e.getY() + camY, e.getW(), e.getH());
        Setup.getSceneManager().getCurrentScene().addEntity(new PlayerBoostEffect(e.getX(),e.getY()));
        Setup.getSceneManager().getCurrentScene().addEntity(new PlayerBoostEffect(e.getX()-e.getXvel()/2,e.getY()-e.getYvel()/2));
    }
}
