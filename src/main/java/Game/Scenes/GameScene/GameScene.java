package main.java.Game.Scenes.GameScene;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Spawning.Spawner;
import main.java.System.Scene.Scene;

public class GameScene extends Scene {
    public Player player;
    public GameScene(){
        super();
    }

    public void onStartup(){
        name = "gameScene";
        setBackgroundColor(0,0,0);
        player = new Player(250,250);
        addEntity(player);
    }
    public void onSwitch(){
        setPaused(false);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        Spawner.spawn();
    }
}
