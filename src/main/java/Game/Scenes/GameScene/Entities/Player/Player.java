package main.java.Game.Scenes.GameScene.Entities.Player;

import com.sun.source.tree.IfTree;
import main.java.Game.Scenes.GameScene.Entities.Player.PlayerBoostEffect.PlayerBoostEffect;
import main.java.Game.Scenes.GameScene.Spawning.Spawner;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Logging.Logger;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

public class Player extends Entity {
    private float speed = 0;
    private int lives = 250;
    private final float defaultspeed = 3;
    private boolean canGetHit = false;
    private int iFrames = 0;
    public Player(float xa, float ya) {
        super(xa, ya);
        setRender(new PlayerRender());
        setSize(7);
        speed = defaultspeed;
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        if(speed>defaultspeed) {
            speed--;
        }
        if(iFrames>0){
            canGetHit=false;
            iFrames--;
        }else{
            if(speed>defaultspeed){
                canGetHit = false;
            }else{
                canGetHit = true;
            }
        }
        if(Spawner.difficulty<10) {
            if (getX() > 500) {
                setX(0);
            }
            if (getX() < 0) {
                setX(500);
            }
        }else{
            if (getX() > 500) {
                setX(500);
            }
            if (getX() < 0) {
                setX(0);
            }
        }
        if(getY()>500){
            setY(0);
        }
        if(getY()<0){
            setY(500);
        }
        if(lives<1){
            kill();
        }
        if(iFrames>=23){
            Setup.getApplet().fill(255,0,0);
            Setup.getApplet().rect(-100,-100,1000,1000);
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

    public boolean isCanGetHit() {
        return canGetHit;
    }

    public void setCanGetHit(boolean canGetHit) {
        this.canGetHit = canGetHit;
    }

    public int getLives() {
        return lives;
    }
    public int getIFrames() {
        return iFrames;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void hit() {
        lives--;
        iFrames = 30;

    }
}
