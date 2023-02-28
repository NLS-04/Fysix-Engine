package Math;

import static java.lang.Math.*;

public final class ExtendedAlgorithms {

    public static void vectors_inplace_rotate_multiple( double angle_radians, Vector2 v1, Vector2 v2 ) {
        final double c = cos(angle_radians), s = sin(angle_radians);

        v1.x = v1.x*c - v1.y*s;
        v1.y = v1.x*s + v1.y*c;

        v2.x = v2.x*c - v2.y*s;
        v2.y = v2.x*s + v2.y*c;
    }
    public static void vectors_inplace_rotate_multiple( double angle_radians, Vector2[] vecs ) {
        final double c = cos(angle_radians), s = sin(angle_radians);

        for ( Vector2 v : vecs ) {
            v.x = v.x*c - v.y*s;
            v.y = v.x*s + v.y*c;
        }
    }

}
