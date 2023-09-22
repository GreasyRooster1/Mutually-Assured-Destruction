package main.java.System.Setup;

import main.java.Game.Startup;
import main.java.System.GlobalShortcut.GlobalShortcutRegistry;
import main.java.System.GlobalShortcut.Types.GlobalShortcut;
import main.java.System.Logging.Logger;
import main.java.System.Registers.SceneRegistry;
import main.java.System.Scene.SceneManager;
import main.java.System.Time.Time;
import processing.core.PApplet;

import static main.java.Game.Registry.SceneRegistry.registerScenes;

public class Setup {
    private static PApplet pAppletInstance;
    private static SceneManager sceneManager;

    public static void start(PApplet pai) {
        Logger.log("Setup received start", "info");
        pAppletInstance = pai;
        sceneManager = new SceneManager();
        SceneRegistry.registerScenes();
        registerScenes();
        Startup.begin();
    }

    public static SceneManager getSceneManager() {
        return sceneManager;
    }

    public static PApplet getApplet() {
        return pAppletInstance;
    }

    public static float getMouseX() {
        return pAppletInstance.mouseX - sceneManager.getCurrentScene().getCamera().getCamX();
    }

    public static float getMouseY() {
        return pAppletInstance.mouseY - sceneManager.getCurrentScene().getCamera().getCamY();
    }

    static void updateShortcuts() {
        for (GlobalShortcut g : GlobalShortcutRegistry.getShortcuts()) {
            g.check();
        }
    }

    public static void execution() {
        Time.updateTime();
        sceneManager.renderCurrentScene();
        updateShortcuts();
        Time.afterFrame();
    }
}
