package main.java.Game.Scenes.GameScene.Entities.Projectiles.Minigun.Bullet;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile.MissileRender;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class Bullet extends Hit {

    public Bullet(float xa, float ya) {
        super(xa, ya);
        setRender(new MissileRender());
        setSize(4);
        setFriction(1);
        Player player = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player;
        float dir = atan2(player.getY()-getY(),player.getX()-getX())+Setup.getApplet().random(-0.1f,0.1f);
        setXvel(cos(dir)*7);
        setYvel(sin(dir)*7);
    }
}
