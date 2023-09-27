package main.java.Game.Scenes.GameScene.Entities.Missile;

import main.java.Game.Scenes.GameScene.Entities.Hit.Hit;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityOutlineRender;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class Missile extends Hit {

    public Missile(float xa, float ya) {
        super(xa, ya);
        setRender(new MissileRender());
        setSize(20);
        setFriction(1);
        float dir = atan2(Setup.getMouseY()-getY(),Setup.getMouseX()-getX());
        setXvel(cos(dir));
        setYvel(sin(dir));
        setDifficulty(25);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        setXvel(getXvel()*1.005f);
        setYvel(getYvel()*1.005f);
    }
}
