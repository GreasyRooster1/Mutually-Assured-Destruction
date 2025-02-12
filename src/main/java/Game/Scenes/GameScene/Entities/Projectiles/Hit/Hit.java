package main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit;

import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;
import main.java.Game.Scenes.GameScene.Entities.Player.Player;

import static processing.core.PApplet.dist;

public class Hit extends Entity {
    private int difficulty = 1;
    public Hit(float xa, float ya) {
        super(xa, ya);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        Player player = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player;
        if (dist(getX(), getY(), player.getX(), player.getY())<getW()/2+player.getW()/2&&player.isCanGetHit()) {
            player.hit();
        }
        if(dist(getX(), getY(),250,250)>600){
            kill();
        }
    }

    public void onMissileCreate(){

    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
