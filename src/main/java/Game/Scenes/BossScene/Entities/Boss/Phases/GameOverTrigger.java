package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.ClusterBomb.ClusterMiniBomb.ClusterMiniBomb;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

import static processing.core.PConstants.PI;


public class GameOverTrigger extends BossPhase {
    private int bodyY =250;

    public GameOverTrigger(){
        super();
        setActivationFrame(9200);
    }
    @Override
    public void run(Entity e){
        Setup.getSceneManager().changeScene("WinScene");
    }

}
