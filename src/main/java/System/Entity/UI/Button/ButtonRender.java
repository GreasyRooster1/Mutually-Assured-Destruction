package main.java.System.Entity.UI.Button;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

public class ButtonRender extends EntityRender {
    public ButtonRender() {
        super();
    }

    @Override
    public void render(Entity e) {
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        PApplet applet = Setup.getApplet();
        applet.fill(255);
        applet.rect(e.getX() + camX, e.getY() + camY, e.getW(), e.getH());
    }
}
