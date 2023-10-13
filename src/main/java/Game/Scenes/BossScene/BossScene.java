package main.java.Game.Scenes.BossScene;

import main.java.Game.Scenes.BossScene.Entities.Boss.Body.BossBody;
import main.java.Game.Scenes.GameScene.Entities.LevelText.LevelText;
import main.java.Game.Scenes.GameScene.Entities.LifeCounter.LivesCounter;
import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.Game.Scenes.GameScene.Spawning.Spawner;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;

public class BossScene extends Scene {
    public Player player;
    public BossScene(){
        super();
    }

    public void onStartup(){
        name = "bossScene";
        setBackgroundColor(0,0,0);
    }
    public void onSwitch(){
        setPaused(false);
        Entity[] e = {};
        entities = e;
        player = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player;
        player.setX(player.getX()-200);
        addEntity(player);
        getCamera().setCamX(200);
        addEntity(new LivesCounter(470,20));
        addEntity(new BossBody(500,250));
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        Setup.getApplet().noStroke();
        if(getCamera().getCamX()>0) {
            getCamera().setCamX(getCamera().getCamX() - 3);
        }else{
            getCamera().setCamX(0);
        }
    }
}
