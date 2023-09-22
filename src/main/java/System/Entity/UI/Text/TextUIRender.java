package main.java.System.Entity.UI.Text;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;
import processing.core.PApplet;
import processing.core.PConstants;

public class TextUIRender extends EntityRender {
    private String text;

    public TextUIRender() {
        super();
        text = "TextUIRender.text";
    }

    @Override
    public void render(Entity e) {
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        float camX = currentScene.getCamera().getCamX();
        float camY = currentScene.getCamera().getCamY();
        PApplet applet = Setup.getApplet();
        applet.textSize(10);
        applet.textAlign(PConstants.RIGHT);
        applet.fill(255);
        applet.text(text, e.getX() + camX, e.getY() + camY);
    }

    public void setText(String text) {
        this.text = text;
    }
}
