package android.support.v4.view;

import android.support.v4.view.VelocityTrackerCompat.VelocityTrackerVersionImpl;
import android.view.VelocityTracker;

/* compiled from: video_annotations */
class VelocityTrackerCompat$BaseVelocityTrackerVersionImpl implements VelocityTrackerVersionImpl {
    VelocityTrackerCompat$BaseVelocityTrackerVersionImpl() {
    }

    public final float m398a(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getXVelocity();
    }

    public final float m399b(VelocityTracker velocityTracker, int i) {
        return velocityTracker.getYVelocity();
    }
}
