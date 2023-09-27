package main.java.Game.Scenes.StartScene;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.StartScene.StartButton.StartButton;
import main.java.Game.Scenes.StartScene.TitleText.TitleText;
import main.java.System.Scene.Scene;

public class StartScene extends Scene {
    public Player player;
    public StartScene(){
        super();
    }

    public void onStartup(){
        name = "startScene";
        setBackgroundColor(0,0,0);
        addEntity(new TitleText(250,100));
        addEntity(new StartButton(250,250));
    }
    public void onSwitch(){
        setPaused(false);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
    }
}
