package main.java.Game;

import main.java.System.Logging.Logger;
import main.java.System.Setup.Setup;

import javax.swing.*;

import static main.java.Game.Assets.AssetLoader.loadAssets;

public class Startup {
    public static void begin(){
        Logger.log("Game.Startup received begin...","game");
        loadAssets();
        Setup.getSceneManager().changeScene("gameScene");
    }
}
