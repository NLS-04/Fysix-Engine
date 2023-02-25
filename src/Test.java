//import GUI.*;
import Engine.Geometry.Shapes.*;
import Math.*;

import java.util.Locale;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        Locale.setDefault( Locale.ENGLISH );

        Rectangle r = new Rectangle( Vector.ZERO, 0, 10, 10 );

        System.out.println( Arrays.toString( r.getVertices() ) );
    }
}
