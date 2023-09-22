package main.java.Game.Registry;

import main.java.Game.Scenes.GameScene.GameScene;
import main.java.System.Scene.Scene;
import main.java.System.Setup.Setup;


public class SceneRegistry {
    public static void registerScenes() {
        registerScene(new GameScene());
    }

    private static void registerScene(Scene scene) {
        Setup.getSceneManager().incomingScene(scene);
    }
}
