package Geometry.Shapes;

import Math.Vector2;

import static java.lang.Math.PI;


public class Circle extends Shape {
    protected float radius;

    public Circle(final float radius) {
        super(new Vector2[]{Vector2.ZERO()});

        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public float getRotation() {
        return 0f;
    }

    @Override
    public Vector2 maxVertexIn(Vector2 direction) {
        return direction.clone().normalize().multi(radius);
    }

    @Override
    public float getGeometryArea() {
        return (float) PI * radius * radius;
    }
}
