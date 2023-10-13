package main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Missile;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile.Missile;
import main.java.System.Setup.Setup;

public class BossMissilePhase extends BossPhase {

     public BossMissilePhase(){
        super();
        setActivationFrame(100);
    }
    @Override
    public void run(){
        Setup.getSceneManager().getCurrentScene().addEntity(new Missile(500,250));
    }

}
