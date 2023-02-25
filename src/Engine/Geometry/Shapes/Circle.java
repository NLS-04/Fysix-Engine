package Engine.Geometry.Shapes;

import Math.Vector;

public class Circle extends Shape {
    protected double radius;

    public Circle( Vector position, double rotation, double radius ) {
        this.position = position;
        this.rotation = rotation;
        vertices = new Vector[] { Vector.ZERO };

        offset_CoG = Vector.ZERO;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getRotation() {
        return 0.0;
    }
    @Override
    public double getRotation_CoG() {
        return 0.0;
    }

    @Override
    public Vector maxVertexIn(Vector direction) {
        return direction.normalized().multi( radius );
    }
}
