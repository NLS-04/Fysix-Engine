package com.Geometry.Shapes;

import Math.Vector2;

public interface Geometry {
//    boolean intersecting( Geometry g1, Geometry g2 );
    Vector2 maxVertexIn( final Vector2 direction );


    /** @return the rotation in radians of a Geometry about its center */
    double getRotation();
    /** set the rotation in radians of a Geometry about its center */
    void setRotation( final double angle );

    /** @return the area of the shape, useful for mass calculations */
    double getGeometryArea();
}
