package com.Geometry.Shapes;

import Math.Vector2;
import com.Geometry.Engine.Time;

public class RigidBody {
    private final Shape geometry;

    private final double density;
    private final double mass;



    /** World position of geometry's Center */
    protected Vector2 position;

    /** velocity of geometry's Center in World coordinates */
    protected Vector2 velocity;

    /** acceleration of geometry's Center in World coordinates */
    protected Vector2 acceleration;


    /** this RigidBody's rotation in radians (+ for CCW, - for CW) */
    protected double rotation;

    /** this RigidBody's angular velocity in radians / s */
    protected double angularVelocity;



    public RigidBody( Shape shape, double density ) {
        geometry = shape;
        this.density = density;
        mass = density * geometry.getGeometryArea();
    }


    //region DIRECT (VIEW) ACCESSORS
    /** this should only be used to directly manipulate the position.
     * The purpose of this direct-access lies in fact to avoid intermediate Vector objects, since these require heap allocation and creation,
     * which is too expensive and unnecessary in this case.
     * @return mutable vector of position */
    public Vector2 getViewOn_position() {
        return position;
    }

    /** this should only be used to directly manipulate the velocity.
     * The purpose of this direct-access lies in fact to avoid intermediate Vector objects, since these require heap allocation and creation,
     * which is too expensive and unnecessary in this case.
     * @return mutable vector of velocity */
    public Vector2 getViewOn_velocity() {
        return velocity;
    }

    /** this should only be used to directly manipulate the acceleration.
     * The purpose of this direct-access lies in fact to avoid intermediate Vector objects, since these require heap allocation and creation,
     * which is too expensive and unnecessary in this case.
     * @return mutable vector of acceleration */
    public Vector2 getViewOn_acceleration() {
        return acceleration;
    }
    //endregion

    //region GETTER-SETTER
    //region GETTER
    public Vector2 getPosition() {
        return position.clone();
    }

    public Vector2 getVelocity() {
        return velocity.clone();
    }

    public Vector2 getAcceleration() {
        return position.clone();
    }

    public double getRotation() {
        return rotation;
    }

    public double getAngularVelocity() {
        return angularVelocity;
    }
    //endregion

    //region SETTER
    /** set the postion of this geometry's center in world coordinates,
     * if possible and implemented use direct access to the position to update or set a new position (to avoid intermediate object creations) */
    public void setPosition( final Vector2 newPos ) {
        position = newPos.clone();
    }

    /** set the velocity of this geometry's center in world coordinates,
     * if possible and implemented use direct access to the position to update or set a new position (to avoid intermediate object creations) */
    public void setVelocity( final Vector2 newVel ) {
        position = newVel.clone();
    }

    /** set the postion of this geometry's center in world coordinates,
     * if possible and implemented use direct access to the position to update or set a new position (to avoid intermediate object creations) */
    public void setAcceleration( final Vector2 newPos ) {
        position = newPos.clone();
    }

    /** set the postion of this geometry's center in world coordinates,
     * if possible and implemented use direct access to the position to update or set a new position (to avoid intermediate object creations) */
    public void setRotation( final double newRot ) {
        rotation = newRot;
        geometry.setRotation( rotation );
    }

    /** set the postion of this geometry's center in world coordinates,
     * if possible and implemented use direct access to the position to update or set a new position (to avoid intermediate object creations) */
    public void setAngularVelocity( final double newAngVel ) {
        angularVelocity = newAngVel;
    }
    //endregion
    //endregion


    public void normalPhysicsStep() {
        // for performance reasons, we calculate component-wise
        velocity.x += acceleration.x * Time.dt;
        velocity.y += acceleration.y * Time.dt;

        position.x += velocity.x * Time.dt;
        position.y += velocity.y * Time.dt;

        rotation += angularVelocity * Time.dt;
    }
}
