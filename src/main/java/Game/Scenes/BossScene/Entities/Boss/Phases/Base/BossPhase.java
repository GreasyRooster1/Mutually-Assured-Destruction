package main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base;

import main.java.Game.Scenes.BossScene.Entities.Boss.Body.BossBody;

public class BossPhase {
    private float activationFrame;
    protected BossPhase(){

    }
    public void run(){

    }
    public float getActivationFrame() {
        return activationFrame;
    }

    public void setActivationFrame(float activationFrame) {
        this.activationFrame = activationFrame;
    }
}
