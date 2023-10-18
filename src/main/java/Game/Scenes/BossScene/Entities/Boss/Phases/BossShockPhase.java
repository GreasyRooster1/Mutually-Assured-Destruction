package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Lazer.Lazer;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.LazerBomb.LazerBomb;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Lightning.Lightning;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

public class BossShockPhase extends BossPhase {

     public BossShockPhase(){
        super();
        setActivationFrame(6000);
    }
    @Override
    public void run(Entity e){
        if(Setup.getApplet().frameCount%120==0) {
            Lightning missile = new Lightning(500, 250 + Setup.getApplet().random(-200, 200));
            missile.onMissileCreate();
            Setup.getSceneManager().getCurrentScene().addEntity(missile);
            Lightning missile1 = new Lightning(0, 250 + Setup.getApplet().random(-200, 200));
            missile1.onMissileCreate();
            Setup.getSceneManager().getCurrentScene().addEntity(missile1);
        }
    }

}
