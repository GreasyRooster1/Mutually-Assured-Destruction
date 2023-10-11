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
    }

    @Override
    public void everyFrame() {
        Player player = ((GameScene) Setup.getSceneManager().getSceneByName("gameScene")).player;
        float dir = atan2(player.getY()-getY(),player.getX()-getX());
        if(dist(getX(),getY(),player.getX(),player.getY())<150) {
            setXvel(cos(dir) * 5f);
            setYvel(sin(dir) * 5f);
        }
        if(dist(getX(),getY(),player.getX(),player.getY())<15) {
            kill();
            player.setLives(player.getLives()+1);
        }
    }
}
