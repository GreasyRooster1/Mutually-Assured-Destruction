package main.java.Game.Scenes.GameScene.Entities.Projectiles.LazerRowsEvent;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Explosion.Explosion;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Hit.Hit;
import main.java.Game.Scenes.GameScene.Entities.Projectiles.Lazer.Lazer;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Setup.Setup;

import static processing.core.PApplet.*;
import static processing.core.PConstants.PI;

public class LazerRowsEvent extends Hit {
    private int fuse = 100;
    public LazerRowsEvent(float xa, float ya) {
        super(xa, ya);
    }

    @Override
    public void onMissileCreate() {
        super.onMissileCreate();
        for(int i=0;i<5;i++){
            Lazer lazer = new Lazer(0,(i/5f)*500f);
            lazer.ex = 500;
            lazer.ey = (i/5f)*500f;
            Setup.getSceneManager().getCurrentScene().addEntity(lazer);
        }
    }

    @Override
    public void everyFrame() {
    }
}
