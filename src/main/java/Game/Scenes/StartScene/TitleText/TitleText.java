package main.java.Game.Scenes.StartScene.TitleText;

import main.java.System.Entity.UI.Text.TextUI;
import main.java.System.Entity.UI.Text.TextUIRender;

public class TitleText extends TextUI {
    public TitleText(float xa, float ya) {
        super(xa, ya);
    }

    @Override
    public void onStartup() {
        super.onStartup();
        ((TextUIRender)getRender()).setText("Mutually Assured Destruction");
        ((TextUIRender)getRender()).setTextSize(40);
        ((TextUIRender)getRender()).setTextCentered(true);
    }
}
