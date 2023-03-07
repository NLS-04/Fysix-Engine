package GUI;

import static org.lwjgl.glfw.GLFW.*;

public final class KeyListener {
    private static boolean[] keyPressed = new boolean[350];

    public static void init() {}

    // Callbacks
    public static void key_callback( long window, int key, int scancode, int action, int mods ) {
        keyPressed[key] = action == GLFW_PRESS;
    }

    public static boolean isPressed( int key ) {
        return keyPressed[ key ];
    }
}
