package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.VelocityTracker;

/* compiled from: providers */
public class VelocityTrackerCompat {
    static final VelocityTrackerVersionImpl f4060a;

    /* compiled from: providers */
    class HoneycombVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
        public final float mo327a(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getXVelocity(i);
        }

        public final float mo328b(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getYVelocity(i);
        }

        HoneycombVelocityTrackerVersionImpl() {
        }
    }

    /* compiled from: providers */
    interface VelocityTrackerVersionImpl {
        float mo327a(VelocityTracker velocityTracker, int i);

        float mo328b(VelocityTracker velocityTracker, int i);
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f4060a = new HoneycombVelocityTrackerVersionImpl();
        } else {
            f4060a = new BaseVelocityTrackerVersionImpl();
        }
    }

    public static float m4593a(VelocityTracker velocityTracker, int i) {
        return f4060a.mo327a(velocityTracker, i);
    }

    public static float m4594b(VelocityTracker velocityTracker, int i) {
        return f4060a.mo328b(velocityTracker, i);
    }
}
