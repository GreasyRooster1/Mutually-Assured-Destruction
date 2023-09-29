package main.java.Game.Scenes.LoseScene;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.LoseScene.Entities.LoseText.LoseText;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;

public class LoseScene extends Scene {
    public Player player;
    public LoseScene(){
        super();
        name = "loseScene";
    }

    public void onStartup(){
        setBackgroundColor(0,0,0, 127);
        addEntity(new LoseText(250,250));
    }
    public void onSwitch(){
        setPaused(false);
        setBackgroundScene("gameScene");
        Setup.getSceneManager().getSceneByName("gameScene").setPaused(true);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
    }
}
