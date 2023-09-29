package main.java.Game.Scenes.GameScene.Entities.LevelText;

import main.java.Game.Scenes.LoseScene.Entities.LoseText.LoseTextRender;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Setup.Setup;

public class LevelText extends Entity {
    public LevelText(float xa, float ya) {
        super(xa, ya);
        setRender(new LevelTextRender());
    }
}
