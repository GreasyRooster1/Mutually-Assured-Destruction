package main.java.Game.Scenes.GameScene.Entities.Missile;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityOutlineRender;

public class Missile extends Entity {

    public Missile(float xa, float ya) {
        super(xa, ya);
        setRender(new MissileRender());
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        setXvel(getXvel()*1.1f);
        setYvel(getYvel()*1.1f);
    }
}
