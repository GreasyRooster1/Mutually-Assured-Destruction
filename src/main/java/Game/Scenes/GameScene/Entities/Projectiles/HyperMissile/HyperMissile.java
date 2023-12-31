package main.java.Game.Scenes.GameScene.Entities.Projectiles.HyperMissile;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile.MissileRender;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class HyperMissile extends Hit {

    public HyperMissile(float xa, float ya) {
        super(xa, ya);
        setRender(new MissileRender());
        setSize(15);
        setFriction(1);
        setDifficulty(50);
    }

    @Override
    public void onMissileCreate() {
        super.onMissileCreate();
        Player player = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player;
        float dir = atan2(player.getY()-getY(),player.getX()-getX());
        setXvel(cos(dir));
        setYvel(sin(dir));
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        setXvel(getXvel()*1.05f);
        setYvel(getYvel()*1.05f);
    }
}
