package main.java.Game.Scenes.StartScene.HardcoreButton;

import main.java.Game.Scenes.GameScene.GameScene;
import main.java.Game.Scenes.GameScene.Spawning.Spawner;
import main.java.System.Entity.UI.Button.Button;
import main.java.System.Setup.Setup;

public class StartHardcoreButton extends Button {
    public StartHardcoreButton(float xa, float ya) {
        super(xa, ya);
        setRender(new StartHardcoreButtonRender());
        setW(100);
        setH(50);
    }

    @Override
    public void onButtonClick(int button) {
        super.onButtonClick(button);
        Spawner.hard = true;
        Setup.getSceneManager().changeScene("gameScene");
        ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player.setLives(1);
    }
}
