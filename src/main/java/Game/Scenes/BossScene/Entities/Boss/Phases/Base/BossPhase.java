package main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base;

import main.java.Game.Scenes.BossScene.Entities.Boss.Body.BossBody;
import main.java.System.Entity.BaseEntity.Entity;

public class BossPhase {
    private float activationFrame;
    protected BossPhase(){

    }
    public void run(Entity e){

    }
    public float getActivationFrame() {
        return activationFrame;
    }

    public void setActivationFrame(float activationFrame) {
        this.activationFrame = activationFrame;
    }
}
