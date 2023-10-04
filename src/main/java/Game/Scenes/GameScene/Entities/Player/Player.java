package main.java.Game.Scenes.GameScene.Entities.Player;

import main.java.Game.Scenes.GameScene.Entities.Player.PlayerBoostEffect.PlayerBoostEffect;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

public class Player extends Entity {
    public Player(float xa, float ya) {
        super(xa, ya);
        setRender(new PlayerRender());
        setSize(7);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
    }

    @Override
    public void kill() {
        super.kill();
        Setup.getSceneManager().changeScene("loseScene");
    }

    @Override
    public void whileKey(char key) {
        super.onKey(key);
        if(Setup.checkKey(87)){
            setY(getY()-5);
        }
        if(Setup.checkKey(83)){
            setY(getY()+5);
        }
        if(Setup.checkKey(65)){
            setX(getX()-5);
        }
        if(Setup.checkKey(68)){
            setX(getX()+5);
        }
    }
}
