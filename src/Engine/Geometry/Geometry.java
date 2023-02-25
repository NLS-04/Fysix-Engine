package Engine.Geometry;

import Math.Vector;

public interface Geometry {
//    boolean intersecting( Geometry g1, Geometry g2 );
    Vector maxVertexIn( Vector direction );

    /** the origin of a Geometry is the reference to all its Vertices are defined
     * @return positions of this geometry's origin */
    Vector getPosition();
    /** the Center of gravity of a Geometry can be offset to its origin
     * @return position of this geometry's Center of Gravity */
    Vector getPosition_CoG();

    /** @return the rotation in radians of a Geometry about its origin */
    double getRotation();
    /** @return the rotation in radians of a Geometry about its Center of Gravity */
    double getRotation_CoG();
}
