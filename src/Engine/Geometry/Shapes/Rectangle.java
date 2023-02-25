package Engine.Geometry.Shapes;

import Math.Vector;

public class Rectangle extends Shape {

    public Rectangle(Vector position, double rotation, double width, double height ) {
        this.position = position;
        this.rotation = rotation;

        width  /= 2;
        height /= 2;

        vertices = new Vector[] {
                new Vector( -width, height ), new Vector( width, height ),
                new Vector( -width, -height ), new Vector( width, -height ),
                null
        };
        vertices[ vertices.length-1 ] = vertices[0];

        offset_CoG = Vector.ZERO;
    }
}
