package main.java.Game.Scenes.GameScene.Entities.Projectiles.HomingMissile;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Explosion.Explosion;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit.Hit;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class HomingMissile extends Hit {
    private float fuel = 100;
    public HomingMissile(float xa, float ya) {
        super(xa, ya);
        setRender(new HomingMissileRender());
        setSize(10);
        setFriction(0.9f);
        setDifficulty(50);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        Player player = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player;
        float dir = atan2(player.getY()-getY(),player.getX()-getX());
        fuel-=1.5f;
        if(fuel>0){
            setXvel(getXvel()+cos(dir)*1.1f*(fuel/100));
            setYvel(getYvel()+sin(dir)*1.1f*(fuel/100));
        }else{
            Setup.getSceneManager().getCurrentScene().addEntity(new Explosion(getX(),getY()));
            kill();
        }
    }
}
