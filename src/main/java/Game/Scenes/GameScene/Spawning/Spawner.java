package main.java.Game.Scenes.GameScene.Spawning;

import main.java.Game.Scenes.GameScene.Entities.ClusterBomb.ClusterBomb;
import main.java.Game.Scenes.GameScene.Entities.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.HomingMissile.HomingMissile;
import main.java.Game.Scenes.GameScene.Entities.HyperMissile.HyperMissile;
import main.java.Game.Scenes.GameScene.Entities.Minigun.Minigun;
import main.java.Game.Scenes.GameScene.Entities.Missile.Missile;
import main.java.System.Logging.Logger;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

import static processing.core.PApplet.*;

public class Spawner {
    private static float difficulty = 1;
    private static int lastSpawnFrame = 0;
    public static void spawn(){
        if(Setup.getApplet().frameCount%ceil(20-20*(difficulty/20))!=0){
            return;
        }
        if(Setup.getApplet().frameCount%100==0){
            difficulty+=0.2;
        }

        PApplet applet = Setup.getApplet();
        spawns(applet);
        if(applet.frameCount-lastSpawnFrame>100){
            addProjectile(new Missile(0,0));
        }
    }

    private static void spawns(PApplet applet){
        if(round(applet.random(0,25))==1){
            addProjectile(new Missile(0,0));
        }

        if(round(applet.random(0,40))==1){
            addProjectile(new ClusterBomb(0,0));
        }

        if(difficulty<2) {return;}

        if (round(applet.random(0, 150)) == 1) {
            addProjectile(new HyperMissile(0,0));
        }

        if(difficulty<3) {return;}

        if (round(applet.random(0, 120)) == 1) {
            addProjectile(new HomingMissile(0,0));
        }

        if(difficulty<4) {return;}

        if (round(applet.random(0, 200)) == 1) {
            addProjectile(new Minigun(0,0));
        }
    }

    private static void addProjectile(Hit hit){
        if(round(Setup.getApplet().random(0,1))==1) {
            hit.setX(round(Setup.getApplet().random(0,1))*500);
            hit.setY(Setup.getApplet().random(0,500));
        }else{
           hit.setX(Setup.getApplet().random(0, 500));
           hit.setY(round(Setup.getApplet().random(0, 1)) * 500);
        }
        hit.onMissileCreate();
        Setup.getSceneManager().getCurrentScene().addEntity(hit);
        lastSpawnFrame = Setup.getApplet().frameCount;
    }
}
