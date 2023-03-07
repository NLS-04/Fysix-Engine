package Engine;

public final class Time {
    private static final float NANO_2_SECOND = 10E-9f;

    private static final long TIME_START = System.nanoTime();

    private static long time_previous = System.nanoTime();
    public static float dt;

    public static void cycle_dt() {
        dt = NANO_2_SECOND * (System.nanoTime() - time_previous);
        time_previous = System.nanoTime();
    }

    public static float totalTimeElapsed() {
        return System.nanoTime() - TIME_START;
    }
}
