package Engine.Geometry.Shapes;

import Math.Vector2;

public class Triangle extends Shape {

    public Triangle(Vector2 position, double rotation, Vector2 A, Vector2 B, Vector2 C ) {
        super( new Vector2[] { A, B, C, A } );
        setPosition( position );
        setRotation( rotation );
    }
}

