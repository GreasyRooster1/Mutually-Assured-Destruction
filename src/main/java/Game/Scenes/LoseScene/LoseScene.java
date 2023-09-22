package main.java.Game.Scenes.LoseScene;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Spawning.Spawner;
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
    }
    public void onSwitch(){
        setPaused(false);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        Setup.getApplet().textAlign(PConstants.CENTER);
        //Setup.getApplet().textSize(50);
        Setup.getApplet().fill(255);
        Setup.getApplet().text("YOU LOSE",250,250);
        Setup.getApplet().fill(0);
    }
}
