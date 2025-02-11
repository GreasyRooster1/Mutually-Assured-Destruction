package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.ClusterBomb.ClusterBomb;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.ClusterBomb.ClusterMiniBomb.ClusterMiniBomb;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.HomingMissile.HomingMissile;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Lightning.Lightning;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile.Missile;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;
import static processing.core.PConstants.PI;


public class BossDeathPhase extends BossPhase {
    public float angle =0;
    public float targetX = 100;
    public float targetY = 0;
    public float speed = 3;
    public float startAnim = 100;
    public BossDeathPhase(){
        super();
        setActivationFrame(7000);
    }
    @Override
    public void run(Entity e){
        for (int i = 0; i < 3; i++) {
            ClusterMiniBomb bomb = new ClusterMiniBomb(400, 250);
            bomb.setDir(Setup.getApplet().random(2 * PI));
            Setup.getSceneManager().getCurrentScene().addEntity(bomb);
        }


        if(startAnim>0){
            startAnim--;
            targetY = 250;
        }else{
            targetY += sin(Setup.getApplet().frameCount/45f)*3;
            speed+=0.005f;
        }

        angle = degrees(atan2(targetY-250,targetX-400));
        if(Setup.getApplet().frameCount%7==0) {
            int amount = 45;
            for (int i = 3; i < amount; i++) {
                float dir = angle + i * (360f / amount);

                Missile missile = new Missile(400, 250);
                missile.setXvel(cos(radians(dir)) * speed);
                missile.setYvel(sin(radians(dir)) * speed);
                Setup.getSceneManager().getCurrentScene().addEntity(missile);
            }
        }

    }

}
