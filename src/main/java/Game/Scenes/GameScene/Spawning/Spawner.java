package main.java.Game.Scenes.GameScene.Spawning;

import main.java.Game.Scenes.GameScene.Entities.Missile.Missile;
import main.java.System.Logging.Logger;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class Spawner {
    public static void spawn(){
        if(round(Setup.getApplet().random(0,10))==1){
            float dir = atan2()
            if(round(Setup.getApplet().random(0,1))==1) {
                Missile missile = new Missile(round(Setup.getApplet().random(0,1))*500,Setup.getApplet().random(0,500));

            }else{
                Missile missile = new Missile(Setup.getApplet().random(0,500),round(Setup.getApplet().random(0,1))*500);
                Setup.getSceneManager().getCurrentScene().addEntity(missile);
            }
            Logger.log("spawned missile","game");
        }
    }

    void addMissile(float x,float y){
        Missile missile = new Missile(x,y);
        float dir = atan2(x-Setup.getMouseX(),y-Setup.getMouseY());
        missile.setXvel(cos(dir));
        Setup.getSceneManager().getCurrentScene().addEntity(missile);
    }
}
