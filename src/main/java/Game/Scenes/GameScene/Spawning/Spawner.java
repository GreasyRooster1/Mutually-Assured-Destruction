package main.java.Game.Scenes.GameScene.Spawning;

import main.java.Game.Scenes.BossScene.Entities.Boss.Body.BossBody;
import main.java.Game.Scenes.GameScene.Entities.LifePickup.LifePickup;
import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.ClusterBomb.ClusterBomb;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Fighter.Fighter;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.HomingMissile.HomingMissile;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.HyperMissile.HyperMissile;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Lazer.Lazer;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.LazerBomb.LazerBomb;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.LazerRowsEvent.LazerRowsEvent;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Lightning.Lightning;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Minigun.Minigun;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Missile.Missile;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

import static processing.core.PApplet.*;

public class Spawner {
    public static float difficulty = 1;
    private static int lastSpawnFrame = 0;
    private static boolean boss = false;
    public static void reset(){
        difficulty=9.9f;
        boss=false;
    }
    public static void spawn(){
        if(difficulty>=10) {
            bossFight();
            return;
        }
        if(difficulty==round(difficulty)&&difficulty>=2){
            Player p = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player;
            p.setLives(p.getLives()+1);
            difficulty+=0.01f;
        }
        if(Setup.getApplet().frameCount%150==0){
            difficulty+=0.1f;
        }
        if(Setup.getApplet().frameCount%ceil(20-20*(difficulty/40))!=0){
            return;
        }
        PApplet applet = Setup.getApplet();
        if(round(applet.random(0,160))==1){
            Setup.getSceneManager().getSceneByName("gameScene").addEntity(new LifePickup(applet.random(0,500),applet.random(0,500)));
        }
        spawns(applet);
        if(applet.frameCount-lastSpawnFrame>100){
            addProjectile(new Missile(0,0));
        }
    }

    private static void bossFight() {
        if(Setup.getSceneManager().getCurrentScene().entities.length<=20&&!boss){
            Setup.getSceneManager().getCurrentScene().addEntity(new BossBody(750,250));
            boss = true;
        }
    }

    private static void spawns(PApplet applet){
        if(round(applet.random(0,10))==1){
            addProjectile(new Missile(0,0));
        }

        if(round(applet.random(0,30))==1){
            addProjectile(new ClusterBomb(0,0));
        }

        if(difficulty<2) {return;}

        if (round(applet.random(0, 20)) == 1) {
            addProjectile(new HyperMissile(0,0));
        }
        if(round(applet.random(0,40))==1){
            addProjectile(new ClusterBomb(0,0));
        }

        if(round(applet.random(0,10))==1){
            addProjectile(new Missile(0,0));
        }

        if(difficulty<3) {return;}

        if (round(applet.random(0, 40)) == 1) {
            addProjectile(new HomingMissile(0,0));
        }
        if (round(applet.random(0, 10)) == 1) {
            addProjectile(new HyperMissile(0,0));
        }

        if(difficulty<4) {return;}

        if (round(applet.random(0, 40)) == 1) {
            addProjectile(new Minigun(0,0));
        }

        if(difficulty<5) {return;}

        if (round(applet.random(0, 10)) == 1) {
            addProjectile(new Lazer(0,0));
        }
        if(difficulty<6) {return;}

        if (round(applet.random(0, 60)) == 1) {
            addProjectile(new Lightning(0,0));
        }
        if(difficulty<7) {return;}

        if (round(applet.random(0, 40)) == 1) {
            addProjectile(new Fighter(0,0));
        }
        if(difficulty<8) {return;}

        if (round(applet.random(0, 40)) == 1) {
            addProjectile(new LazerBomb(0,0));
        }
        if(difficulty<9) {return;}

        if (round(applet.random(0, 40)) == 1) {
            addProjectile(new LazerRowsEvent(0,0));
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
