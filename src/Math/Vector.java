package Math;

import java.lang.Math;

public class Vector {
    /**
     * All methods and arithmetic are defined in a right-hand orientated Coordinate-system
     */

    public double x, y;

    public static final Vector ZERO = new Vector( 0, 0 );
    public static final Vector ONE = new Vector( 1, 1 );

    public Vector( double x, double y ) {
        this.x = x;
        this.y = y;
    }

    public Vector add(Vector other) {
        return new Vector( x + other.x, y + other.y );
    }

    public Vector sub(Vector other) {
        return new Vector( x - other.x, y - other.y );
    }

    public Vector multi(double a ) {
        return new Vector( a*x, a*y );
    }


    public double dot( Vector other ) {
        return x * other.x + y * other.y;
    }

    public double sqrMag() {
        return this.dot(this);
    }

    public double mag() {
        return Math.sqrt( sqrMag() );
    }

    public Vector normalized() {
        return multi( 1.0/mag() );
    }



    public static Vector project( Vector vec, Vector onto ) {
        return onto.multi( vec.dot(onto) );
    }

    /**
     * the counterpart of to the projection.
     * meaning: Vector v = project(v, u) + exclude(v, u)
     * @return the vector normal to the excludedVector pointing at vec
     */
    public static Vector exclude( Vector vec, Vector excludedVector ) {
        return vec.sub( project(vec, excludedVector) );
    }

    /** @return the enclosing angle between two Vectors in radians */
    public static double vectorAngle( Vector vec1, Vector vec2 ) {
        return Math.acos( vec1.dot(vec2) / (vec1.mag()*vec2.mag()) );
    }

    /** @param angle in radians
     *  @return a rotated Vector */
    public Vector rotate( double angle ) {
        /* matrix multiplication
        * | cos(phi)    -sin(phi) | | x |
        * | sin(phi)    cos(phi)  | | y |
        */
        double c = Math.cos(angle), s = Math.sin(angle);
        return new Vector( x*c - y*s, x*s + y*c );
    }

    /** same as this.rotate( pi/2 or 90° )
     * @return the normal Vector to this Vector*/
    public Vector normal() {
        return new Vector( -y, x ).normalized();
    }

    public boolean equals( Vector other ) {
        return x == other.x && y == other.y;
    }

    @Override
    public String toString() {
        return String.format("Vector(%.2f, %.2f)", x, y) ;
    }
}
