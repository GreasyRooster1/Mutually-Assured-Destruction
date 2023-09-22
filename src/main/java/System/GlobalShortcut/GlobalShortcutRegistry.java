package main.java.System.GlobalShortcut;

import main.java.System.GlobalShortcut.Types.GlobalShortcut;

import static main.java.System.Util.Utils.append;

public class GlobalShortcutRegistry {
    private static GlobalShortcut[] shortcuts = {};

    public static void registerShortcut(GlobalShortcut s) {
        shortcuts = (GlobalShortcut[]) append(shortcuts, s);
    }

    public static GlobalShortcut[] getShortcuts() {
        return shortcuts;
    }
}
