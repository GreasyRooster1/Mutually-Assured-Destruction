package main.java.Game.Scenes.GameScene.Entities.Projectiles.Fighter;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Minigun.Bullet.Bullet;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class Fighter extends Hit {
    public Fighter(float xa, float ya) {
        super(xa, ya);
        setRender(new FighterRender());
        Player player = ((GameScene) Setup.getSceneManager().getSceneByName("gameScene")).player;
        float dir = atan2(player.getY()-getY(),player.getX()-getX());
        setXvel(cos(dir)*5);
        setYvel(sin(dir)*5);
        setSize(10);
        setFriction(1);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        if(Setup.getApplet().frameCount%7==0) {
            Setup.getSceneManager().getCurrentScene().addEntity(new Bullet(getX(), getY()));
        }
    }
}
