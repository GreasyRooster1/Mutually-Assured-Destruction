package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.BossScene;
import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.ClusterBomb.ClusterMiniBomb.ClusterMiniBomb;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile.Missile;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;
import static processing.core.PConstants.PI;


public class BossDeathPhase extends BossPhase {
    private int bodyY =250;
    private float delta = 0;

    public BossDeathPhase(){
        super();
        setActivationFrame(9000);
    }
    @Override
    public void run(Entity e){
        for (int i = 0; i < 7; i++) {
            ClusterMiniBomb bomb = new ClusterMiniBomb(500+delta, 250);
            bomb.setDir(Setup.getApplet().random(2 * PI));
            Setup.getSceneManager().getCurrentScene().addEntity(bomb);
        }
        e.setX(e.getX()+0.5f);
        delta+=0.5f;
        e.setY(250+Setup.getApplet().random(-6,6));
    }

}
