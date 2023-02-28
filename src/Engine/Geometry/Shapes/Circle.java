package Engine.Geometry.Shapes;

import Math.Vector2;

public class Circle extends Shape {
    protected double radius;

    public Circle( Vector2 position, double rotation, double radius ) {
        super( new Vector2[] { Vector2.ZERO() } );
        setPosition( position );
        setRotation( rotation );

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
    public Vector2 maxVertexIn(Vector2 direction) {
        return direction.clone().normalize().multi( radius );
    }
}
