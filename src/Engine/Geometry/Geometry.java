package Engine.Geometry;

import Math.Vector2;

public interface Geometry {
//    boolean intersecting( Geometry g1, Geometry g2 );
    Vector2 maxVertexIn( final Vector2 direction );

    /** the postion of this geometry's center in world coordinates
     * @return positions of this geometry's center */
    Vector2 getPosition();
    /** set the postion of this geometry's center in world coordinates,
     * if possible and implemented use direct access to the position to update or set a new position (to avoid intermediate object creations) */
    void setPosition( Vector2 newPos );

    /** @return the rotation in radians of a Geometry about its center */
    double getRotation();
    /** set the rotation in radians of a Geometry about its center */
    void setRotation( final double angle );
}
