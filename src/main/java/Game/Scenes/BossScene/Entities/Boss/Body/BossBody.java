package main.java.Game.Scenes.BossScene.Entities.Boss.Body;

import main.java.System.Entity.BaseEntity.Entity;

public class BossBody extends Entity {

    public BossBody(float xa, float ya) {
        super(xa, ya);
        setRender(new BossBodyRender());
        setSize(200);
    }

}
