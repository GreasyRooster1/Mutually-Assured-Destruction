package main.java.Game.Scenes.GameScene.Entities.Missile;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Setup.Setup;

public class MissileRender extends EntityRender {
    @Override
    public void render(Entity e) {
        Setup.getApplet().fill(255,0,0);
        super.render(e);
    }
}
