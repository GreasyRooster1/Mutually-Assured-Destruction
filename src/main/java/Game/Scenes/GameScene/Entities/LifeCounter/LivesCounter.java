package main.java.Game.Scenes.GameScene.Entities.LifeCounter;

import main.java.System.Entity.BaseEntity.Entity;

public class LivesCounter extends Entity {
    public LivesCounter(float xa, float ya) {
        super(xa, ya);
        setRender(new LivesCounterRender());
    }
}
