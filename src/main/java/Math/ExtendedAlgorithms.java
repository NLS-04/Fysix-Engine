package Math;

import static java.lang.Math.*;

public final class ExtendedAlgorithms {
    private static final double TWO_PI = 2.0 * PI;
    private static final double PI_TWO = PI / 2.0;
    private static final double PI_THREE = PI / 3.0;
    private static final double PI_FOUR = PI / 4.0;
    private static final double THREE_PI_TWO = 3.0 * PI / 2.0;
    private static final double
            C0 = 0.999997257857529794,
            C1 = -0.500126816106697616,
            C2 = 0.0411367476249547481,
            C3 = -0.00175342659507825459,
            C4 = 0.0000281647394526159577,
            C5 = 0.000327220203803161600,
            C6 = 0.000552859102683027016,
            C7 = 0.000140298964521140382;

    public static void vectors_inplace_rotate_multiple(float angle_radians, Vector2 v1, Vector2 v2) {
        final float c = (float) cos(angle_radians), s = (float) sin(angle_radians);

        v1.x = v1.x * c - v1.y * s;
        v1.y = v1.x * s + v1.y * c;

        v2.x = v2.x * c - v2.y * s;
        v2.y = v2.x * s + v2.y * c;
    }

    public static void vectors_inplace_rotate_multiple(float angle_radians, Vector2[] vecs) {
        final float c = (float) cos(angle_radians), s = (float) sin(angle_radians);

        for (Vector2 v : vecs) {
            v.x = v.x * c - v.y * s;
            v.y = v.x * s + v.y * c;
        }
    }

    public static double Q_sin(double x) {
        return Q_cos(x + PI_TWO);
    }

    // actually not faster, soooooooo ... :-|
    // maybe useful for native C implementations
    public static double Q_cos(double x) {
        x = abs(x) % TWO_PI; // map x from  to [0;2PI)

        if (x >= THREE_PI_TWO) {              // mapping: [3PI/2; 2PI) --> [0, PI/2)
            return cos_piHalf(TWO_PI - x);
        } else if (x >= PI) {                 // mapping: [PI; 3PI/2) --> [0, PI/2)
            return -cos_piHalf(x - PI);
        } else if (x >= PI_TWO) {             // mapping: [PI/2; PI) --> [0, PI/2)
            return -cos_piHalf(PI - x);
        }
        return cos_piHalf(x);
    }

    private static double cos_piHalf(double x) {
        return C0 + x * (C1 + x * (C2 + x * (C3 + x * (C4 + x * (C5 + x * (C6 + C7 * x))))));
    }

}
