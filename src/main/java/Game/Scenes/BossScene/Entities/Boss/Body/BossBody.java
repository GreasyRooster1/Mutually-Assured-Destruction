package main.java.Game.Scenes.BossScene.Entities.Boss.Body;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Missile.BossMissilePhase;
import main.java.System.Entity.BaseEntity.Entity;
import processing.core.PApplet;

public class BossBody extends Entity {
    public int bossFrames = 0;
    public BossPhase[] bossPhases = {};
    public BossBody(float xa, float ya) {
        super(xa, ya);
        setRender(new BossBodyRender());
        setSize(200);
        registerPhases();
    }

    public void registerPhases(){
        bossPhases = (BossPhase[]) PApplet.append(bossPhases,new BossMissilePhase());
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        bossFrames++;
        for(BossPhase b:bossPhases){
            if(b.getActivationFrame()>bossFrames){
                b.run();
            }
        }
    }
}
