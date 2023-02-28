package Engine.Geometry.Shapes;

import Math.Vector2;

public class Rectangle extends Shape {

    public Rectangle(Vector2 position, double rotation, double width, double height ) {
        super( new Vector2[] {
                new Vector2( -(width*=.5), (height*=.5) ), new Vector2( width, height ),
                new Vector2( -width, -height ), new Vector2( width, -height ),
                new Vector2( -width, height )
            } );
        setPosition( position );
        setRotation( rotation );
    }
}
