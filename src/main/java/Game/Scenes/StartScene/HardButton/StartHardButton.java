package main.java.Game.Scenes.StartScene.HardButton;

import main.java.Game.Scenes.GameScene.Spawning.Spawner;
import main.java.System.Entity.UI.Button.Button;
import main.java.System.Setup.Setup;

public class StartHardButton extends Button {
    public StartHardButton(float xa, float ya) {
        super(xa, ya);
        setRender(new StartHardButtonRender());
        setW(100);
        setH(50);
    }

    @Override
    public void onButtonClick(int button) {
        super.onButtonClick(button);
        Spawner.hard = true;
        Setup.getSceneManager().changeScene("gameScene");
    }
}
