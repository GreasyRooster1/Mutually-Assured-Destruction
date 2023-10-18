package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Lazer.Lazer;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.LazerBomb.LazerBomb;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.LazerRowsEvent.LazerRowsEvent;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

public class BossSuperLazerPhase extends BossPhase {

     public BossSuperLazerPhase(){
        super();
        setActivationFrame(5000);
    }
    @Override
    public void run(Entity e){
        if(Setup.getApplet().frameCount%90==0) {
            LazerRowsEvent homingMissile = new LazerRowsEvent(500, 250 + Setup.getApplet().random(-200, 200));
            homingMissile.onMissileCreate();
            Setup.getSceneManager().getCurrentScene().addEntity(homingMissile);
        }
        if(Setup.getApplet().frameCount%50==0) {
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
