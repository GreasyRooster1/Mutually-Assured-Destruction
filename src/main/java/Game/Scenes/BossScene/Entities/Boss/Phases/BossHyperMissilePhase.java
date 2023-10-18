package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.HyperMissile.HyperMissile;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile.Missile;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class BossHyperMissilePhase extends BossPhase {

     public BossHyperMissilePhase(){
        super();
        setActivationFrame(700);
    }
    @Override
    public void run(Entity e){
         if(Setup.getApplet().frameCount%20==0) {
             HyperMissile missile = new HyperMissile(500, 250 + Setup.getApplet().random(-50, 50));
             missile.onMissileCreate();
             Setup.getSceneManager().getCurrentScene().addEntity(missile);
         }
        if(Setup.getApplet().frameCount%30==0) {
            Missile missile = new Missile(500, 250 + Setup.getApplet().random(-200, 200));
            missile.onMissileCreate();
            Setup.getSceneManager().getCurrentScene().addEntity(missile);
        }
    }

}
