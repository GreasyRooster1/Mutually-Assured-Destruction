package main.java.Game.Scenes.WinScene;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.WinScene.Entities.WinText.WinText;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;

public class WinScene extends Scene {
    public Player player;
    public WinScene(){
        super();
        name = "winScene";
    }

    public void onStartup(){
        setBackgroundColor(0,0,0, 127);
        addEntity(new WinText(250,250));
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
