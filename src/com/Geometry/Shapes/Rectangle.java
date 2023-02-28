package com.Geometry.Shapes;

import Math.Vector2;

public class Rectangle extends Shape {
    private final double width, height;

    public Rectangle( double width, double height ) {
        super( new Vector2[] {
                new Vector2( -(width*=.5), (height*=.5) ), new Vector2( width, height ),
                new Vector2( -width, -height ), new Vector2( width, -height ),
                new Vector2( -width, height )
            } );
        this.width = width;
        this.height = height;
    }

    @Override
    public double getGeometryArea() {
        return width * height;
    }
}
