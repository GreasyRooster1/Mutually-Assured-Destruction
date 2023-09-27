package main.java.Game.Scenes.StartScene.StartButton;

import main.java.System.Entity.UI.Button.Button;
import main.java.System.Setup.Setup;

public class StartButton extends Button {
    public StartButton(float xa, float ya) {
        super(xa, ya);
    }

    @Override
    public void onButtonClick(int button) {
        super.onButtonClick(button);
        Setup.getSceneManager().changeScene("gameScene");
    }
}
