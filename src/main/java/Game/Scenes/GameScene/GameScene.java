package main.java.Game.Scenes.GameScene;

import main.java.Game.Scenes.GameScene.Spawning.Spawner;
import main.java.System.Scene.Scene;

public class GameScene extends Scene {
    public GameScene(){
        super();
    }

    public void onStartup(){
        name = "gameScene";
        setBackgroundColor(0,0,0);
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
