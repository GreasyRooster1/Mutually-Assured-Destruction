package main.java.Game.Scenes.GameScene.Entities.HyperMissile;

import main.java.Game.Scenes.GameScene.Entities.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.Missile.MissileRender;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class HyperMissile extends Hit {

    public HyperMissile(float xa, float ya) {
        super(xa, ya);
        setRender(new MissileRender());
        setSize(15);
        setFriction(1);
        float dir = atan2(Setup.getMouseY()-getY(),Setup.getMouseX()-getX());
        setXvel(cos(dir)*2);
        setYvel(sin(dir)*2);
        setDifficulty(50);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        setXvel(getXvel()*1.05f);
        setYvel(getYvel()*1.05f);
    }
}
