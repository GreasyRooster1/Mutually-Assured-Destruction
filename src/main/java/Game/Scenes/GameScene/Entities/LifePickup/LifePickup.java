package main.java.Game.Scenes.GameScene.Entities.LifePickup;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class LifePickup extends Entity {
    public LifePickup(float xa, float ya) {
        super(xa, ya);
        setFriction(1);
        setSize(20);
        setRender(new LifePickupRender());
        float dir = Setup.getApplet().random(PI*2);
        setXvel(cos(dir));
        setYvel(sin(dir));
    }

    @Override
    public void everyFrame() {
        Player player = ((GameScene) Setup.getSceneManager().getSceneByName("gameScene")).player;
        float dir = atan2(player.getY()-getY(),player.getX()-getX());
        float dist = dist(getX(),getY(),player.getX(),player.getY());
        if(dist<300) {
            setXvel(cos(dir) * lerp(10,1,dist/300));
            setYvel(sin(dir) * lerp(10,1,dist/300));
        }
        if(dist(getX(),getY(),player.getX(),player.getY())<15) {
            kill();
            player.setLives(player.getLives()+1);
        }
    }
}
