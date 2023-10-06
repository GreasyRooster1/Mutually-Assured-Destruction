package main.java.Game.Scenes.GameScene.Entities.Projectiles.LazerBomb;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Explosion.Explosion;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Lazer.Lazer;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;
import static processing.core.PApplet.dist;
import static processing.core.PConstants.PI;

public class LazerBomb extends Hit {
    private int fuse = 100;
    public LazerBomb(float xa, float ya) {
        super(xa, ya);
        setRender(new LazerBombRender());
        setSize(20);
        setFriction(1);
        setDifficulty(25);
    }

    @Override
    public void onMissileCreate() {
        super.onMissileCreate();
        Player player = ((GameScene) Setup.getSceneManager().getSceneByName("gameScene")).player;
        float dir = atan2(player.getY()-getY(),player.getX()-getX());
        setXvel(cos(dir)*3);
        setYvel(sin(dir)*3);
    }

    @Override
    public void everyFrame() {
        super.everyFrame();
        Player player = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player;
        if(dist(getX(),getY(),player.getX(),player.getY())<=75){
            explode();
        }
        fuse--;
        if(fuse<=0){
            explode();
        }
    }

    public void explode(){
        for(float i=0;i<2*PI;i+=((2*PI)/10)){
            Lazer lazer = new Lazer(getX(),getY());
            lazer.ex = getX()+cos(i)*700;
            lazer.ey = getY()+sin(i)*700;
            Setup.getSceneManager().getCurrentScene().addEntity(lazer);
        }
        Setup.getSceneManager().getCurrentScene().addEntity(new Explosion(getX(),getY()));
        kill();
    }
}
