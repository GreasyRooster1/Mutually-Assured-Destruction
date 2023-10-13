package main.java.Game.Scenes.GameScene.Entities.Projectiles.Lightning;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Explosion.Explosion;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Lazer.Lazer;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Lightning.Bolt.Bolt;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;
import static processing.core.PConstants.PI;

public class Lightning extends Hit {
    private int fuse = 100;
    public Lightning(float xa, float ya) {
        super(xa, ya);
    }

    @Override
    public void onMissileCreate() {
        super.onMissileCreate();
        Player player = ((GameScene) Setup.getSceneManager().getSceneByName("gameScene")).player;
        float baseDir = atan2(player.getY()-getY(),player.getX()-getX());
        float dir = baseDir;
        float px = getX();
        float py = getY();
        for(float i=0;i<30;i++){
            for(float j=0;j<round(Setup.getApplet().random(1,3));j++) {
                Bolt bolt = new Bolt(px, py);
                dir = baseDir+Setup.getApplet().random(-1f, 1f);
                bolt.ex = px + cos(dir) * 75;
                bolt.ey = py + sin(dir) * 75;
                Setup.getSceneManager().getCurrentScene().addEntity(bolt);
            }
            px = px + cos(dir) * 75;
            py = py + sin(dir) * 75;
        }
    }
}
