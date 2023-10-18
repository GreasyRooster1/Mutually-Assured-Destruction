package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Fighter.Fighter;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Minigun.Minigun;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.println;

public class BossGunPhase extends BossPhase {

     public BossGunPhase(){
        super();
        setActivationFrame(3002);
    }
    @Override
    public void run(Entity e){
        if(Setup.getApplet().frameCount%170==0) {
            Fighter minigun = new Fighter(500, 250+Setup.getApplet().random(-100,100));
            minigun.onMissileCreate();
            Setup.getSceneManager().getCurrentScene().addEntity(minigun);
        }
    }

}
