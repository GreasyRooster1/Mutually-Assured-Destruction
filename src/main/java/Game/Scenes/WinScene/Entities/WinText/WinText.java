package main.java.Game.Scenes.WinScene.Entities.WinText;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

public class WinText extends Entity {
    public WinText(float xa, float ya) {
        super(xa, ya);
        setRender(new WinTextRender());
    }

    @Override
    public void onKey(char key) {
        if(key==' '){
            Setup.getSceneManager().changeScene("startScene");
        }
    }
}
