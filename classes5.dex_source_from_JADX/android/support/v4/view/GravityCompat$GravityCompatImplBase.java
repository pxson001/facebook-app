package android.support.v4.view;

import android.graphics.Rect;
import android.support.v4.view.GravityCompat.GravityCompatImpl;
import android.view.Gravity;

/* compiled from: video_looping_style */
class GravityCompat$GravityCompatImplBase implements GravityCompatImpl {
    GravityCompat$GravityCompatImplBase() {
    }

    public final int m326a(int i, int i2) {
        return -8388609 & i;
    }

    public final void m328a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        Gravity.apply(i, i2, i3, rect, rect2);
    }

    public final void m327a(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6) {
        Gravity.apply(i, i2, i3, rect, i4, i5, rect2);
    }
}
