package main.java.Game.Scenes.GameScene.Entities.Hit;

import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;
import main.java.Game.Scenes.GameScene.Entities.Player.Player;

import static processing.core.PApplet.dist;

public class Hit extends Entity {

    public Hit(float xa, float ya) {
        super(xa, ya);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        Player player = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player;
        if (dist(getX(), getY(), player.getX(), player.getY())<getW()/2+player.getW()/2) {
            player.kill();
        }
    }
}
