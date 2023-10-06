package main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit.Hit;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class Missile extends Hit {

    public Missile(float xa, float ya) {
        super(xa, ya);
        setRender(new MissileRender());
        setSize(20);
        setFriction(1);
        setDifficulty(25);
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
        setXvel(getXvel()*1.005f);
        setYvel(getYvel()*1.005f);
    }
}
