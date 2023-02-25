package Engine.Geometry.Shapes;

import Engine.Geometry.Geometry;
import Math.Vector;

public abstract class Shape implements Geometry {
    protected Vector[] vertices;
    protected Vector position, offset_CoG;

    protected double rotation;

    public Vector[] getVertices() {
        return vertices;
    }

    protected void calculate_offset_CoG() {
        for ( Vector v: vertices )
            offset_CoG = offset_CoG.add(v);

        offset_CoG.multi( 1.0/vertices.length );
    }

    @Override
    public Vector maxVertexIn(Vector direction) {
        direction = direction.rotate( rotation );

        Vector bestVec = Vector.ZERO;
        double bestValue = Double.MIN_VALUE, x;

        for ( Vector v: vertices ) {
            if ( ( x = direction.dot( v ) ) > bestValue ) {
                bestValue = x;
                bestVec = v;
            }
        }

        return bestVec;
    }

    @Override
    public Vector getPosition() {
        return position;
    }
    @Override
    public Vector getPosition_CoG() {
        return position.add( offset_CoG.rotate( rotation ) );
    }

    @Override
    public double getRotation() {
        return rotation;
    }
    @Override
    public double getRotation_CoG() {
        return -rotation;
    }

    public void setRotation(double angle) {
        rotation = angle;
    }
}
