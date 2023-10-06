package main.java.Game.Scenes.GameScene.Entities.Player.PlayerBoostEffect;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;

public class PlayerBoostEffect extends Entity {

    public PlayerBoostEffect(float xa, float ya) {
        super(xa, ya);
        setSize(7);
        setRender(new PlayerBoostEffectRender());
        setLife(127);
        setDecay(30);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
    }
}
