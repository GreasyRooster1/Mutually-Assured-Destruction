package main.java.System.Entity.UI.Text;

import main.java.System.Entity.BaseEntity.Entity;
import main.java.System.Entity.UI.UIEntity;

public class TextUI extends UIEntity {
    public TextUI(float xa, float ya) {
        super(xa, ya);
    }

    public void onStartup() {
        setRender(new TextUIRender());
    }

    public Entity setText(String t) {
        TextUIRender render = (TextUIRender) (getRender());
        render.setText(t);
        return this;
    }
}
