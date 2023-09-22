package main.java.Game.Scenes.LoseScene.Entities.LoseText;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

public class LoseText extends Entity {
    public LoseText(float xa, float ya) {
        super(xa, ya);
        setRender(new LoseTextRender());
    }

    @Override
    public void onKey(char key) {
        if(key==' '){
            Setup.getSceneManager().changeScene("gameScene");
        }
    }
}
