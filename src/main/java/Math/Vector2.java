package Math;

public class Vector2 implements Cloneable {
    /**
     * All methods and arithmetic are defined in a right-hand orientated Coordinate-system
     * Vector objects are by default mutable, (generally) static methods see Vectors as immutable
     */

    public float x, y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /** @return new Vector(0,0) */
    public static Vector2 ZERO() {
        return new Vector2(0, 0);
    }

    /** @return new Vector(1,1) */
    public static Vector2 ONE() {
        return new Vector2(1, 1);
    }


    //region VECTOR MATH OPERATION
        /**
         * INPLACE OPERATION | copies coordinates of v into itself
         * @return a reference to itself (monad)
         */
        public Vector2 set( Vector2 v ) {
            x = v.x;
            y = v.y;
            return this;
        }

        /**
         * INPLACE OPERATION | copies coordinates of v into itself
         * @return a reference to itself (monad)
         */
        public Vector2 set( float x, float y ) {
            this.x = x;
            this.y = y;
            return this;
        }


        /**
         * Instantiates a new Vector containing the result of the Vector addition of v and u ( v + u )
         * @return reference to new Vector object
         */
        public static Vector2 add(final Vector2 v, final Vector2 u) {
            return new Vector2(v.x + u.x, v.y + u.y);
        }

        /**
         * Instantiates a new Vector containing the result of the Vector subtraction of u from v ( v - u )
         * @return reference to new Vector object
         */
        public static Vector2 sub(final Vector2 v, final Vector2 u) {
            return new Vector2(v.x - u.x, v.y - u.y);
        }

        /**
         * Instantiates a new Vector containing the result of the scalar-multiplication of v and a ( a * v )
         * @return reference to new Vector object
         */
        public static Vector2 multi(final Vector2 v, final float a) {
            return new Vector2(a * v.x, a * v.y);
        }

        /**
         * INPLACE OPERATION | adds other to itself
         * @return reference to itself (monad)
         */
        public Vector2 add(final Vector2 other) {
            x += other.x;
            y += other.y;
            return this;
        }

        /**
         * INPLACE OPERATION | subtracts other from itself
         * @return reference to itself (monad)
         */
        public Vector2 sub(final Vector2 other) {
            x -= other.x;
            y -= other.y;
            return this;
        }

        /**
         * INPLACE OPERATION | multiplies scalar 'a' with itself
         * @return reference to itself (monad)
         */
        public Vector2 multi(final float a) {
            x *= a;
            y *= a;
            return this;
        }
    //endregion

    //region ADVANCED VECTOR MATH
        /** @return calculates the dot-product of the Vectors v and u */
        public static float dot(final Vector2 v, final Vector2 u) {
            return v.x * u.x + v.y * u.y;
        }

        /** @return the squared magnitude of this Vector */
        public float sqrMag() {
            return dot(this, this);
        }

        /** @return the magnitude, i.e. the euclidean length, of this Vector */
        public float mag() {
            return (float) Math.sqrt(sqrMag());
        }

        /**
         * Instantiates a new Vector with magnitude 1 and direction of v
         * @return reference to new Vector object
         */
        public static Vector2 normalize(final Vector2 v) {
            //todo: add Q_sqrt algorithm for normalization
            return Vector2.multi(v, 1f / v.mag());
        }

        /**
         * INPLACE OPERATION | normalizes itself, i.e. resizes itself so that its magnitude is 1
         * @return reference to itself (monad)
         */
        public Vector2 normalize() {
            //todo: add Q_sqrt algorithm for normalization
            return multi(1f / mag());
        }

        /**
         * Instantiates a new Vector which is the projection of the Vector 'vec' onto the Vector 'onto'
         * @return reference to new Vector object
         */
        public static Vector2 project(final Vector2 vec, final Vector2 onto) {
            return Vector2.multi(onto, Vector2.dot(vec, onto));
        }

        /**
         * the counterpart to the projection.
         * meaning: Vector v = project(v, u) + exclude(v, u)
         * @return reference to a new Vector object which is normal to the excludedVector pointing at vec
         */
        public static Vector2 exclude(final Vector2 vec, final Vector2 excludedVector) {
            // to avoid instantiating multiple Vector objects. We get a new Vector object from Vector2.project which we do the calculations on
            return project(vec, excludedVector).sub(vec).multi(-1); // -1 * ( project(v, u) - v ) == v - project(v, u)
        }

        /** @return the enclosing angle between two Vectors in radians */
        public static float vectorAngle(final Vector2 vec1, final Vector2 vec2) {
            return (float) Math.acos(dot(vec1, vec2) / (vec1.mag() * vec2.mag()));
        }

        /**
         * Instantiates a new Vector which is the result of a rotation by angle radians in CCW orientation of Vector v
         * @return reference to new Vector object
         */
        public static Vector2 rotate(final Vector2 v, final float angle) {
            /* matrix multiplication
             * | cos(phi)    -sin(phi) | | x |
             * | sin(phi)    cos(phi)  | | y |
             */
            final float c = (float) Math.cos(angle), s = (float) Math.sin(angle);
            return new Vector2(v.x * c - v.y * s, v.x * s + v.y * c);
        }

        /**
         * INPLACE OPERATION | rotates itself by angle radians in CCW orientation
         * @return reference to itself (monad)
         */
        public Vector2 rotate(final float angle) {
            /* matrix multiplication
             * | cos(phi)    -sin(phi) | | x |
             * | sin(phi)    cos(phi)  | | y |
             */
            final float c = (float) Math.cos(angle), s = (float) Math.sin(angle);

            x = x * c - y * s;
            y = x * s + y * c;

            return this;
        }

        /**
         * same as Vector2.rotate( this, pi/2 or 90° )
         * @return reference to a new Vector normal to Vector v
         */
        public static Vector2 normal(final Vector2 v) {
            return new Vector2(-v.y, v.x).normalize();
        }
    //endregion

    //region OBJECT MANAGEMENT METHODS
        public boolean equals(final Vector2 other) {
            return x == other.x && y == other.y;
        }

        /**
         * @return new mutable instance of this Vector2
         */
        @Override
        public Vector2 clone() {
            return new Vector2(x, y);
        }

        @Override
        public String toString() {
            return String.format("Vector(%.2f, %.2f)", x, y);
        }
    //endregion
}
