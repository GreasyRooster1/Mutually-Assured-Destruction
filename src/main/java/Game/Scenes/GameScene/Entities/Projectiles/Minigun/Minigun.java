package main.java.Game.Scenes.GameScene.Entities.Projectiles.Minigun;

import main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Minigun.Bullet.Bullet;
import main.java.System.Setup.Setup;

public class Minigun extends Hit {
    public int ammo = 20;
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
            kill();
        }
    }
}