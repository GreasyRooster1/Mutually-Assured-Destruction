package main.java.Game.Scenes.GameScene;

import main.java.Game.Scenes.GameScene.Entities.LevelText.LevelText;
import main.java.Game.Scenes.GameScene.Entities.LifeCounter.LivesCounter;
import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Spawning.Spawner;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;

public class GameScene extends Scene {
    public Player player;
    public GameScene(){
        super();
    }

    public void onStartup(){
        name = "gameScene";
        setBackgroundColor(0,0,0);
    }
    public void onSwitch(){
        setPaused(false);
        Entity[] e = {};
        entities = e;
        player = new Player(250,250);
        addEntity(player);
        Spawner.reset();
        addEntity(new LevelText(0,15));
        addEntity(new LivesCounter(470,20));

    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        Spawner.spawn();
        Setup.getApplet().noStroke();
        if(Setup.checkKey(8)||Setup.checkKey(80)||Setup.checkKey(27)){
            Setup.getSceneManager().changeScene("startScene");
        }
    }
}
