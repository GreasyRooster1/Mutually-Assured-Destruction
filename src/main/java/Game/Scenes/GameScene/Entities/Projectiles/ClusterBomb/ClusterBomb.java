package main.java.Game.Scenes.GameScene.Entities.Projectiles.ClusterBomb;

import main.java.Game.Scenes.GameScene.Entities.Projectiles.ClusterBomb.ClusterMiniBomb.ClusterMiniBomb;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Explosion.Explosion;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;

public class ClusterBomb extends Hit {
    private int fuse = 100;
    public ClusterBomb(float xa, float ya) {
        super(xa, ya);
        setRender(new ClusterBombRender());
        setSize(20);
        setFriction(1);
        setDifficulty(25);
    }

    @Override
    public void onMissileCreate() {
        super.onMissileCreate();
        Player player = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player;
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
        for(float i=0;i<2*PI;i+=((2*PI)/30)){
            ClusterMiniBomb bomb = new ClusterMiniBomb(getX(),getY());
            bomb.setDir(i);
            Setup.getSceneManager().getCurrentScene().addEntity(bomb);
        }
        Setup.getSceneManager().getCurrentScene().addEntity(new Explosion(getX(),getY()));
        kill();
    }
}
