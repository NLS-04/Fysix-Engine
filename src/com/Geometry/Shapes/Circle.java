package com.Geometry.Shapes;

import Math.Vector2;

import static java.lang.Math.PI;


public class Circle extends Shape {
    protected double radius;

    public Circle( double radius ) {
        super( new Vector2[] { Vector2.ZERO() } );

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

    @Override
    public double getGeometryArea() {
        return PI * radius*radius;
    }
}
