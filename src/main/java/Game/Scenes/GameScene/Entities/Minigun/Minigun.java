package main.java.Game.Scenes.GameScene.Entities.Minigun;

import main.java.Game.Scenes.GameScene.Entities.Explosion.Explosion;
import main.java.Game.Scenes.GameScene.Entities.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.Minigun.Bullet.Bullet;
import main.java.Game.Scenes.GameScene.Entities.Missile.MissileRender;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class Minigun extends Hit {
    private int ammo = 20;
    public Minigun(float xa, float ya) {
        super(xa, ya);
        setRender(new MinigunRender());
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        if(Setup.getApplet().frameCount%9==0) {
            Setup.getSceneManager().getCurrentScene().addEntity(new Bullet(getX(), getY()));
            ammo--;
        }
        if(ammo<=0){

        }
    }
}