package main.java.System.Entity.UI.ProgressBar;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;
import processing.core.PApplet;

public class ProgressBarRender extends EntityRender {
    public int background, foreground;

    public ProgressBarRender() {
        super();
        background = Setup.getApplet().color(255);
        foreground = Setup.getApplet().color(255);
    }

    @Override
    public void render(Entity entity) {
        ProgressBar e = (ProgressBar) entity;
        Scene currentScene = Setup.getSceneManager().getCurrentScene();
        PApplet applet = Setup.getApplet();
        applet.fill(background);
        applet.rect(e.getX(), e.getY(), e.getW(), e.getH());
        applet.fill(foreground);
        applet.rect(e.getX(), e.getY(), PApplet.lerp(0, e.getW(), e.getLerp()), e.getH());
    }
}
