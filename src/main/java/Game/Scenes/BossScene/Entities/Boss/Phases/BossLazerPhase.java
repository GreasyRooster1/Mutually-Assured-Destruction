package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.ClusterBomb.ClusterBomb;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.HomingMissile.HomingMissile;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Lazer.Lazer;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.LazerBomb.LazerBomb;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

public class BossLazerPhase extends BossPhase {

     public BossLazerPhase(){
        super();
        setActivationFrame(4000);
    }
    @Override
    public void run(Entity e){
        if(Setup.getApplet().frameCount%70==0) {
            LazerBomb missile = new LazerBomb(500, 250 + Setup.getApplet().random(-200, 200));
            missile.onMissileCreate();
            Setup.getSceneManager().getCurrentScene().addEntity(missile);

        }
        if(Setup.getApplet().frameCount%40==0) {
            Lazer homingMissile = new Lazer(500, 250 + Setup.getApplet().random(-200, 200));
            homingMissile.onMissileCreate();
            Setup.getSceneManager().getCurrentScene().addEntity(homingMissile);
        }
    }

}
