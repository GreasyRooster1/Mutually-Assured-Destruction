package main.java.Game.Scenes.GameScene.Entities.Player;

import main.java.Game.Scenes.GameScene.Entities.Player.PlayerBoostEffect.PlayerBoostEffect;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

public class Player extends Entity {
    public float phase = 0;
    private boolean onWayUp = false;
    private float cooldown = 0;
    public Player(float xa, float ya) {
        super(xa, ya);
        setRender(new PlayerRender());
        setSize(7);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        setX(Setup.getMouseX());
        setY(Setup.getMouseY());
        if(onWayUp){
            phase +=2;
            if(phase >=20){
                onWayUp = false;
            }
        }else {
            if (phase > 0) {
                phase--;
            }
        }
        if(phase>0){
            cooldown = 20;
        }else{
            cooldown--;
        }
        setSize(7 + phase);
    }

    @Override
    public void kill() {
        super.kill();
        Setup.getSceneManager().changeScene("loseScene");
    }

    @Override
    public void onKey(char key) {
        super.onKey(key);
        if(key==' '&&cooldown<0){
            onWayUp = true;
            Setup.getSceneManager().getCurrentScene().addEntity(new PlayerBoostEffect(getX(),getY()));
        }
    }
}
