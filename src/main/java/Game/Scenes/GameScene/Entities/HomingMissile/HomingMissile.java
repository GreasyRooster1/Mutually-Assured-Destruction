package main.java.Game.Scenes.GameScene.Entities.HomingMissile;

import main.java.Game.Scenes.GameScene.Entities.Explosion.Explosion;
import main.java.Game.Scenes.GameScene.Entities.Hit.Hit;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class HomingMissile extends Hit {
    private float fuel = 100;
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
        fuel-=1;
        if(fuel>0){
            setXvel(getXvel()+cos(dir)*1.2f*(fuel/100));
            setYvel(getYvel()+sin(dir)*1.2f*(fuel/100));
        }else{
            Setup.getSceneManager().getCurrentScene().addEntity(new Explosion(getX(),getY()));
            kill();
        }
    }
}
