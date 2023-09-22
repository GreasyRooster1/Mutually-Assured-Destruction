package main.java.System.Entity.UI;

import main.java.System.Entity.BaseEntity.Entity;

public class UIEntity extends Entity {
    protected UIEntity(float xa, float ya) {
        super(xa, ya);
        isUI = true;
    }
}
