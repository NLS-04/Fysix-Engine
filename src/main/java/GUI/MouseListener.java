package GUI;

import Math.Vector2;

import static org.lwjgl.glfw.GLFW.*;

public final class MouseListener {
    private static float scroll_x, scroll_y;
    private static Vector2 currentPos, lastPos;
    private static boolean[] mouseButtonPressed = new boolean[3];
    private static boolean[] isDragging = new boolean[3];


    public static void init() {
        currentPos = Vector2.ZERO();
        lastPos = Vector2.ZERO();

        scroll_x = 0f;
        scroll_y = 0f;
    }

    public static void cursor_position_callback( long window, double xpos, double ypos ) {
        lastPos.set( currentPos );
        currentPos.set( (float) xpos, (float) ypos );

        isDragging[0] = mouseButtonPressed[0];
        isDragging[1] = mouseButtonPressed[1];
        isDragging[2] = mouseButtonPressed[2];
    }

    public static void mouse_button_callback( long window, int button, int action, int mods ) {
        if ( action == GLFW_PRESS ) {
            mouseButtonPressed[button] = true;
        } else if ( action == GLFW_RELEASE ) {
            mouseButtonPressed[button] = false;
            isDragging[0] = isDragging[1] = isDragging[2] = false;
        }
    }

    public static void scroll_callback( long window, double xoffset, double yoffset ) {
        scroll_x = (float) xoffset;
        scroll_y = (float) yoffset;
    }

    public static void endFrame() {
        scroll_x = 0f;
        scroll_y = 0f;
        lastPos.set( currentPos );
    }

    public static Vector2 getCursorPos() {
        return currentPos.clone();
    }

    public static Vector2 getDeltaPos() {
        return Vector2.sub( currentPos, lastPos );
    }

    public static float getScroll_x() {
        return scroll_x;
    }

    public static float getScroll_y() {
        return scroll_y;
    }

    public static boolean isDragging( int button ) {
        return isDragging[button];
    }

    public static boolean isButtonPressed( int button ) {
        return mouseButtonPressed[button];
    }
}
