package main.java.Game.Scenes.GameScene.Entities.Player;

import main.java.Game.Scenes.GameScene.Entities.Player.PlayerBoostEffect.PlayerBoostEffect;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

public class Player extends Entity {
    private float speed = 0;
    private float defaultspeed = 3;
    public Player(float xa, float ya) {
        super(xa, ya);
        setRender(new PlayerRender());
        setSize(7);
        speed = defaultspeed;
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        if(speed>defaultspeed){
            speed--;
        }
        if(getX()>500){
            setX(0);
        }
        if(getX()<0){
            setX(500);
        }
        if(getY()>500){
            setY(0);
        }
        if(getY()<0){
            setY(500);
        }
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
            setY(getY()-speed);
        }
        if(Setup.checkKey(83)){
            setY(getY()+speed);
        }
        if(Setup.checkKey(65)){
            setX(getX()-speed);
        }
        if(Setup.checkKey(68)){
            setX(getX()+speed);
        }
    }

    @Override
    public void onKey(char key) {
        if(key==' '&&speed==defaultspeed){
            speed = 12;
        }
    }
}
