package main.java.Game.Scenes.StartScene.HardButton;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.BaseEntity.Renders.EntityRender;
import main.java.System.Setup.Setup;
import processing.core.PConstants;

public class StartHardButtonRender extends EntityRender {
    @Override
    public void render(Entity e) {
        super.render(e);
        Setup.getApplet().fill(255,0,0);
        Setup.getApplet().rect(e.getX(),e.getY(),e.getW(),e.getH());
        Setup.getApplet().fill(0,0,0);
        Setup.getApplet().textSize(16);
        Setup.getApplet().textAlign(PConstants.CENTER);
        Setup.getApplet().text("Start\n(Hard)",e.getX()+e.getW()/2,e.getY()+e.getH()/2);
    }
}
