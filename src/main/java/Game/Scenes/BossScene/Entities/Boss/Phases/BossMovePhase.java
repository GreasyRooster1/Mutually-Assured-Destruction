package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile.Missile;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

public class BossMovePhase extends BossPhase {

     public BossMovePhase(){
        super();
        setActivationFrame(6950);
    }
    @Override
    public void run(Entity e){
         e.setX(e.getX()-3);
    }

}
