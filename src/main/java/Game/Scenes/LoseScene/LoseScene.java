package main.java.Game.Scenes.LoseScene;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Spawning.Spawner;
import main.java.Game.Scenes.LoseScene.Entities.LoseText.LoseText;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;
import processing.core.PConstants;

public class LoseScene extends Scene {
    public Player player;
    public LoseScene(){
        super();
    }

    public void onStartup(){
        name = "loseScene";
        setBackgroundColor(0,0,0);
        addEntity(new LoseText(250,250));
    }
    public void onSwitch(){
        setPaused(false);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
    }
}
