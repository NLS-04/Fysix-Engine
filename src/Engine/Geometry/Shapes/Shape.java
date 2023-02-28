package Engine.Geometry.Shapes;

import Engine.Geometry.Geometry;
import Math.Vector2;
import Math.ExtendedAlgorithms;

import java.util.Arrays;

import static java.lang.Math.sin;

public abstract class Shape implements Geometry {

    protected final Vector2[] vertices;

    /** World position of geometry's Center */
    protected Vector2 position;

    /** smallest Bounding box of shape with current rotation */
    protected Rectangle boundingBox;

    /** angle (in radians) of rotation about the center of this shape, in regard to its instantiated orientation */
    protected double rotation;

    protected Shape( Vector2[] _vertices ) {
        vertices = Arrays.copyOf( _vertices, _vertices.length );
        position = Vector2.ZERO();
        rotation = 0.0;

        recalculateVertices();
    }

    public Vector2[] getVertices() {
        return vertices;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }


    /** this should only be used to directly manipulate the position.
     * The purpose of this direct-access lies in fact to avoid intermediate Vector objects, since these require heap allocation and creation,
     * which is too expensive and unnecessary in this case.
     * @return mutable vector of position */
    public Vector2 getViewOn_position() {
        return position;
    }

    /** @return copy of position */
    @Override
    public Vector2 getPosition() {
        return position.clone();
    }

    @Override
    public void setPosition( Vector2 newPos ) {
        position = newPos;
    }

    @Override
    public double getRotation() {
        return rotation;
    }

    @Override
    public void setRotation( final double angle ) {
        rotation = angle;
        calculate_boundingBox();
    }

    @Override
    public Vector2 maxVertexIn( final Vector2 direction ) {
        // align direction to shapes current orientation
        Vector2 dir = Vector2.rotate( direction, -rotation );

        Vector2 bestVec  = Vector2.ZERO();
        double bestValue = Double.MIN_VALUE, x;

        for ( Vector2 v: vertices ) {
            if ( ( x = Vector2.dot( dir, v ) ) > bestValue ) {
                bestValue = x;
                bestVec = v;
            }
        }

        return bestVec.clone();
    }


    /**
     * This method recalculates the vertices position in regard to their center point
     * This method is important and must be called (in Constructor) before any meaningful interactions can be applied.
     * This is important since all further interactions with shapes interpret their vertices and positions Vector in regard to their center point.
     * */
    protected void recalculateVertices() {
        if ( vertices.length == 0 )
            return;

        Vector2 cog = Vector2.ZERO();

        for ( Vector2 v: vertices )
            cog.add( v );
        cog.multi( 1.0/vertices.length );

        for ( Vector2 v: vertices )
            v.sub( cog );
    }

    protected void calculate_boundingBox() {
        // this method can get quite runtime intensive, may need improvements later

        double  max_x=Double.MIN_VALUE,
                min_x=Double.MAX_VALUE,
                max_y=Double.MIN_VALUE,
                min_y=Double.MAX_VALUE,
                x,y ;

        final double c = Math.cos( rotation ), s = sin( rotation );

        for ( Vector2 v : vertices ) {
            // rotate vertex
            x = v.x*c - v.y*s;
            y = v.x*s + v.y*c;

            max_x = Double.max( max_x, x );
            min_x = Double.min( min_x, x );
            max_y = Double.max( max_y, y );
            min_y = Double.min( min_y, y );
        }

        boundingBox = new Rectangle( Vector2.ZERO(), 0, max_x-min_x, max_y-min_y );
    }
}
