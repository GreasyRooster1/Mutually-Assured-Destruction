package main.java.System.Registers;

import main.java.System.Scene.Scene;
import main.java.System.Scene.SystemScenes.DebugScene;
import main.java.System.Scene.SystemScenes.DefaultScene;
import main.java.System.Setup.Setup;

public class SceneRegistry {

    public static void registerScenes() {
        registerScene(new DefaultScene());
        registerScene(new DebugScene());
    }

    private static void registerScene(Scene scene) {
        Setup.getSceneManager().incomingScene(scene);
    }

}
