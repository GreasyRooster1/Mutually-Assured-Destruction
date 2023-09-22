package main.java.Game.Scenes.GameScene.Spawning;

import main.java.Game.Scenes.GameScene.Entities.HyperMissile.HyperMissile;
import main.java.Game.Scenes.GameScene.Entities.Missile.Missile;
import main.java.System.Logging.Logger;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class Spawner {
    public static void spawn(){
        if(round(Setup.getApplet().random(0,10))==1){
            if(round(Setup.getApplet().random(0,1))==1) {
                addMissile(round(Setup.getApplet().random(0,1))*500,Setup.getApplet().random(0,500));
            }else{
                addMissile(Setup.getApplet().random(0,500),round(Setup.getApplet().random(0,1))*500);
            }
        }
        if(round(Setup.getApplet().random(0,50))==1){
            if(round(Setup.getApplet().random(0,1))==1) {
                addHyperMissile(round(Setup.getApplet().random(0,1))*500,Setup.getApplet().random(0,500));
            }else{
                addHyperMissile(Setup.getApplet().random(0,500),round(Setup.getApplet().random(0,1))*500);
            }
        }
    }

    static void addMissile(float x, float y){
        Missile missile = new Missile(x,y);
        Setup.getSceneManager().getCurrentScene().addEntity(missile);
    }

    static void addHyperMissile(float x, float y){
        HyperMissile missile = new HyperMissile(x,y);
        Setup.getSceneManager().getCurrentScene().addEntity(missile);
    }
}
