package com.Geometry.Shapes;

import Math.Vector2;

public class Triangle extends Shape {

    public Triangle( Vector2 A, Vector2 B, Vector2 C ) {
        super( new Vector2[] { A, B, C, A } );
    }

    @Override
    public double getGeometryArea() {
        // get references
        Vector2 A = vertices[0], B = vertices[1], C = vertices[2];

        // shoelace formula
        return 0.5 * Math.abs( (A.x - C.x)*(B.y - A.y) - (A.x - B.x)*(C.y - A.y) );
    }
}

