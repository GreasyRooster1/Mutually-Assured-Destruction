package main.java.Game.Scenes.GameScene.Entities.Projectiles.Minigun;

import main.java.Game.Scenes.GameScene.Entities.Player.Player;
import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

import static processing.core.PApplet.*;

public class MinigunRender extends EntityRender {
    @Override
    public void render(Entity e) {
        PApplet applet = Setup.getApplet();
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        applet.fill(127);
        applet.ellipse(e.getX() + camX, e.getY() + camY, 20, 20);
        Player player = ((GameScene)Setup.getSceneManager().getSceneByName("gameScene")).player;
        float dir = atan2(player.getY()-e.getY(),player.getX()-e.getX());
        applet.stroke(127);
        applet.strokeWeight(7);
        applet.line(e.getX() + camX, e.getY() + camY, e.getX() + camX+cos(dir)*15, e.getY() + camY+sin(dir)*15);
    }
}
