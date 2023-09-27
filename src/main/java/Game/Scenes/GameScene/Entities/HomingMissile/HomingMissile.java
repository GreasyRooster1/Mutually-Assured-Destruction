package main.java.Game.Scenes.GameScene.Entities.HomingMissile;

import main.java.Game.Scenes.GameScene.Entities.Hit.Hit;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class HomingMissile extends Hit {

    public HomingMissile(float xa, float ya) {
        super(xa, ya);
        setRender(new HomingMissileRender());
        setSize(13);
        setFriction(0.9f);
        setDifficulty(50);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        float dir = atan2(Setup.getMouseY()-getY(),Setup.getMouseX()-getX());
        setXvel(getXvel()+cos(dir)*1.2f);
        setYvel(getYvel()+sin(dir)*1.2f);
    }
}
