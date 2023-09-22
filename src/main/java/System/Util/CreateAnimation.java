package main.java.System.Util;

import main.java.System.TextureLoader.Animation.AnimationTexture;
import main.java.System.TextureLoader.TextureLoader;

import static main.java.System.TextureLoader.TextureLoader.getAnimationClass;

public class CreateAnimation {
    public static AnimationTexture createAnimation(String path, String name, int length, int speed) {
        TextureLoader.registerAnimation(path, name);
        AnimationTexture anim = (AnimationTexture) getAnimationClass(name);
        anim.setLength(length);
        anim.setAnimationSpeed(speed);
        anim.resetFrames();
        return anim;
    }
}
