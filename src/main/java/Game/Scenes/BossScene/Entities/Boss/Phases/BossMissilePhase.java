package main.java.Game.Scenes.BossScene.Entities.Boss.Phases;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile.Missile;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;
import static processing.core.PApplet.sin;

public class BossMissilePhase extends BossPhase {

     public BossMissilePhase(){
        super();
        setActivationFrame(50);
    }
    @Override
    public void run(Entity e){
         if(Setup.getApplet().frameCount%20==0) {
             Missile missile = new Missile(500, 250+Setup.getApplet().random(-100,100));
             Player player = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player;
             float dir = atan2(player.getY()-missile.getY(),player.getX()-missile.getX())+Setup.getApplet().random(-1,1);
             missile.setXvel(cos(dir));
             missile.setYvel(sin(dir));
             Setup.getSceneManager().getCurrentScene().addEntity(missile);
         }
    }

}
