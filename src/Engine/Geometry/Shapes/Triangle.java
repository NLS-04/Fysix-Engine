package Engine.Geometry.Shapes;

import Math.Vector;

public class Triangle extends Shape {

    public Triangle(Vector position, double rotation, Vector A, Vector B, Vector C ) {
        this.position = position;
        this.rotation = rotation;

        vertices = new Vector[] { A, B, C, A };

        offset_CoG = Vector.ZERO;
    }
}

