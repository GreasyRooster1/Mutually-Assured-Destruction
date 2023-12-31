package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.ClusterBomb.ClusterBomb;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.HomingMissile.HomingMissile;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.HyperMissile.HyperMissile;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile.Missile;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.println;

public class BossBombPhase extends BossPhase {

     public BossBombPhase(){
        super();
        setActivationFrame(2000);
    }
    @Override
    public void run(Entity e){
        if(Setup.getApplet().frameCount%100==0) {
            ClusterBomb missile = new ClusterBomb(500, 250 + Setup.getApplet().random(-200, 200));
            missile.onMissileCreate();
            Setup.getSceneManager().getCurrentScene().addEntity(missile);

        }
        if(Setup.getApplet().frameCount%20==0) {
            HomingMissile homingMissile = new HomingMissile(500, 250 + Setup.getApplet().random(-200, 200));
            homingMissile.onMissileCreate();
            Setup.getSceneManager().getCurrentScene().addEntity(homingMissile);
        }
    }

}
