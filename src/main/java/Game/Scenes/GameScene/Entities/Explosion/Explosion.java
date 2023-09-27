package main.java.Game.Scenes.GameScene.Entities.Explosion;

import main.java.Game.Scenes.GameScene.Entities.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.Missile.MissileRender;

public class Explosion extends Hit {
    public Explosion(float xa, float ya) {
        super(xa, ya);
        setRender(new MissileRender());
        setSize(10);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        setSize(getSize()+15);
        if(getSize()>70){
            kill();
        }
    }
}
