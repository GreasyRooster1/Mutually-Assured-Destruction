package main.java.Game.Scenes.BossScene.Entities.Boss.Body;

import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.Base.BossPhase;
import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.BossHyperMissilePhase;
import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.BossMissilePhase;
import main.java.Game.Scenes.BossScene.Entities.Boss.Phases.BossMovePhase;
import main.java.System.Entity.BaseEntity.Entity;
import processing.core.PApplet;

import static processing.core.PApplet.append;
import static processing.core.PApplet.println;

public class BossBody extends Entity {
    public int bossFrames = 0;
    public BossPhase[] bossPhases = {};
    public BossBody(float xa, float ya) {
        super(xa, ya);
        setRender(new BossBodyRender());
        setSize(400);
        registerPhases();
    }

    public void registerPhases(){
        bossPhases = (BossPhase[]) PApplet.append(bossPhases,new BossMovePhase());
        bossPhases = (BossPhase[]) PApplet.append(bossPhases,new BossMissilePhase());
        bossPhases = (BossPhase[]) PApplet.append(bossPhases,new BossHyperMissilePhase());
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        bossFrames++;
        BossPhase[] phases = {};
        for(BossPhase b:bossPhases){
            if(b.getActivationFrame()<bossFrames){
                phases = (BossPhase[]) append(phases, b);
            }
        }
        phases[phases.length-1].run(this);
    }
}
