package main.java.Game.Scenes.GameScene.Spawning;

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
    public static void spawn(){
        if(Setup.getApplet().frameCount%ceil(20-20*(difficulty/20))!=0){
            return;
        }
        if(Setup.getApplet().frameCount%100==0){
            difficulty+=0.2;
        }

        PApplet applet = Setup.getApplet();

        if(round(applet.random(0,25))==1){
            addMissile();
        }

        if(difficulty<3) {return;}

        if (round(applet.random(0, 150)) == 1) {
            addHyperMissile();
        }

        if(difficulty<4) {return;}

        if (round(applet.random(0, 120)) == 1) {
            addHomingMissile();
        }

        if(difficulty<5) {return;}

        if (round(applet.random(0, 200)) == 1) {
            addMinigunMissile();
        }
    }

    private static void addHomingMissile() {
        HomingMissile missile;
        if(round(Setup.getApplet().random(0,1))==1) {
            missile = new HomingMissile(round(Setup.getApplet().random(0,1))*500,Setup.getApplet().random(0,500));
        }else{
            missile = new HomingMissile(Setup.getApplet().random(0, 500), round(Setup.getApplet().random(0, 1)) * 500);
        }

        Setup.getSceneManager().getCurrentScene().addEntity(missile);
    }

    static void addMissile(){
        Missile missile;
        if(round(Setup.getApplet().random(0,1))==1) {
            missile = new Missile(round(Setup.getApplet().random(0,1))*500,Setup.getApplet().random(0,500));
        }else{
            missile = new Missile(Setup.getApplet().random(0, 500), round(Setup.getApplet().random(0, 1)) * 500);
        }

        Setup.getSceneManager().getCurrentScene().addEntity(missile);
    }

    static void addHyperMissile(){
        HyperMissile missile;
        if(round(Setup.getApplet().random(0,1))==1) {
            missile = new HyperMissile(round(Setup.getApplet().random(0,1))*500,Setup.getApplet().random(0,500));
        }else{
            missile = new HyperMissile(Setup.getApplet().random(0, 500), round(Setup.getApplet().random(0, 1)) * 500);
        }

        Setup.getSceneManager().getCurrentScene().addEntity(missile);
    }

    static void addMinigunMissile(){
        Minigun missile;
        if(round(Setup.getApplet().random(0,1))==1) {
            missile = new Minigun(round(Setup.getApplet().random(0,1))*500,Setup.getApplet().random(0,500));
        }else{
            missile = new Minigun(Setup.getApplet().random(0, 500), round(Setup.getApplet().random(0, 1)) * 500);
        }

        Setup.getSceneManager().getCurrentScene().addEntity(missile);
    }
}
