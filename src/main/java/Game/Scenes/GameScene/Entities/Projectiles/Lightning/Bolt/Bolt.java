package main.java.Game.Scenes.GameScene.Entities.Projectiles.Lightning.Bolt;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit.Hit;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Setup.Setup;

import java.awt.*;

import static main.java.System.Util.Utils.getClostestPointOnLine;
import static processing.core.PApplet.*;

public class Bolt extends Hit {
    public float ex,ey;
    public float power =0;
    public Bolt(float xa, float ya) {
        super(xa, ya);
        Player player = ((GameScene) Setup.getSceneManager().getSceneByName("gameScene")).player;
        float dir = atan2(player.getY()-getY(),player.getX()-getX());
        ex = getX()+cos(dir)*700;
        ey = getY()+sin(dir)*700;
        setSize(10);
        setLife(50);
        setRender(new BoltRender());
    }

    public void everyFrame() {
        super.everyFrame();
        Player player = ((GameScene) Setup.getSceneManager().getSceneByName("gameScene")).player;
        Point closest = getClostestPointOnLine((int) getX(),(int) getY(),(int) ex,(int) ey,(int) player.getX(),(int) player.getY());

        if (dist(closest.x, closest.y, player.getX(),player.getY())<getSize()&&player.isCanGetHit()&&power>=100) {
            player.hit();
        }
        if(power<100) {
            power += 6;
        }else{
            setSize(15);
            setDecay(1);
        }
    }

    float getEx(){
        return ex;
    }
    float getEy(){
        return ey;
    }
}
