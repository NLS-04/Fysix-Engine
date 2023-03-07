package Geometry.Shapes;

import Math.Vector2;

public class Rectangle extends Shape {
    private final float width, height;

    public Rectangle(float width, float height) {
        super(new Vector2[]{
                new Vector2(-(width *= .5), (height *= .5)), new Vector2(width, height),
                new Vector2(-width, -height), new Vector2(width, -height),
                new Vector2(-width, height)
        });
        this.width = width;
        this.height = height;
    }

    @Override
    public float getGeometryArea() {
        return width * height;
    }
}
