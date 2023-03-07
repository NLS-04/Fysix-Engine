package Geometry.Shapes;

import Math.Vector2;

public interface Geometry {
    //    boolean intersecting( Geometry g1, Geometry g2 );
    Vector2 maxVertexIn(final Vector2 direction);


    /**
     * @return the rotation in radians of a Geometry about its center
     */
    float getRotation();

    /**
     * set the rotation in radians of a Geometry about its center
     */
    void setRotation(final float angle);

    /**
     * @return the area of the shape, useful for mass calculations
     */
    float getGeometryArea();
}
