package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Minigun.Minigun;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.println;

public class BossGunSetupPhase extends BossPhase {

     public BossGunSetupPhase(){
        super();
        setActivationFrame(3000);
    }
    @Override
    public void run(Entity e){
        Minigun minigun = new Minigun(500, 50);
        minigun.ammo = 100;
        minigun.onMissileCreate();
        Setup.getSceneManager().getCurrentScene().addEntity(minigun);
        Minigun minigun1 = new Minigun(500, 450);
        minigun1.ammo = 100;
        minigun1.onMissileCreate();
        Setup.getSceneManager().getCurrentScene().addEntity(minigun1);
    }

}
