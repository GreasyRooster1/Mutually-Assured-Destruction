package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.ClusterBomb.ClusterMiniBomb.ClusterMiniBomb;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile.Missile;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;
import static processing.core.PConstants.PI;


public class BossDesperationPhase extends BossPhase {
    private float angle =0;
    private float targetX = 100;
    private float targetY = 0;
    private float speed = 3;
    private float startAnim = 200;
    private float deadZone = 180;
    private float targetDeadZone = 30;
    private float moveSpeed = 0.017f;

    public BossDesperationPhase(){
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

        Setup.getApplet().fill(255);
        Setup.getApplet().ellipse(targetX, targetY,10,10);

        angle = degrees(atan2(targetY-250,targetX-400));
        int time = (int) map(speed,3,13,7f,1f);
        if(Setup.getApplet().frameCount%time==0) {
            int amount = 45+Setup.getApplet().frameCount%(time*2);
            float ratio = (360f / amount);
            for (int i = (int) (deadZone/ratio); i < amount; i++) {
                float dir = angle + i * (360f / amount)-deadZone/2;
                Missile missile = new Missile(400, 250);
                missile.setXvel(cos(radians(dir)) * speed);
                missile.setYvel(sin(radians(dir)) * speed);
                Setup.getSceneManager().getCurrentScene().addEntity(missile);
            }
        }
        startAnim--;
        if(startAnim>0){
            targetY = 250;
            deadZone -= (180-targetDeadZone)/200f;
            return;
        }

        float target = 250 + sin(Setup.getApplet().frameCount * moveSpeed) * 200;
        if(startAnim>-30) {
            targetY = lerp(target,250,(startAnim+30)/30);
        }else{
            targetY = target;
        }
        speed+=0.005f;
        moveSpeed+=0.00001f;
        moveSpeed = constrain(moveSpeed,0,0.0285f);
        speed = constrain(speed,0,10);

    }

}
