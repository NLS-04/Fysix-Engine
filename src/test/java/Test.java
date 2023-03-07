import GUI.Window;

import java.util.Locale;

public class Test {

    public static void main(String[] args) {
        Locale.setDefault( Locale.ENGLISH );

        Window game = new Window( 800, 500, "Testing" );

        game.run();
    }
}
