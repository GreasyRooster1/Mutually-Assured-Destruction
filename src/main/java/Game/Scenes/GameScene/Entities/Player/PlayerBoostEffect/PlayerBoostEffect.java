package main.java.Game.Scenes.GameScene.Entities.Player.PlayerBoostEffect;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;

public class PlayerBoostEffect extends Entity {

    public PlayerBoostEffect(float xa, float ya) {
        super(xa, ya);
        setSize(10);
        setRender(new PlayerBoostEffectRender());
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        setSize(getSize()+4);
        if(getSize()>50){
            kill();
        }
    }
}
