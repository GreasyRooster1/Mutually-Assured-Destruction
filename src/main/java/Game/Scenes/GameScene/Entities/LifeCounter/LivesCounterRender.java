package main.java.Game.Scenes.GameScene.Entities.LifeCounter;

import main.java.Game.Scenes.GameScene.GameScene;
import main.java.Game.Scenes.GameScene.Spawning.Spawner;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Setup.Setup;
import processing.core.PApplet;
import processing.core.PConstants;

import static processing.core.PApplet.floor;

public class LivesCounterRender extends EntityRender {
    @Override
    public void render(Entity e) {
        PApplet applet = Setup.getApplet();
        applet.fill(255,0,0);
        if(((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player.getLives()<=0){return;}
        applet.ellipse(e.getX(),e.getY(),25,25);
        if(((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player.getLives()<=1){return;}
        applet.ellipse(e.getX()+30,e.getY(),25,25);
        if(((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player.getLives()<=2){return;}
        applet.ellipse(e.getX()+60,e.getY(),25,25);
    }
}
