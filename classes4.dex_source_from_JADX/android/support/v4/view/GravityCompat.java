package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Gravity;

/* compiled from: privacy_option_invalid_icon_null */
public class GravityCompat {
    static final GravityCompatImpl f4214a;

    /* compiled from: privacy_option_invalid_icon_null */
    class GravityCompatImplJellybeanMr1 implements GravityCompatImpl {
        public final int mo356a(int i, int i2) {
            return Gravity.getAbsoluteGravity(i, i2);
        }

        GravityCompatImplJellybeanMr1() {
        }

        public final void mo358a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
            GravityCompatJellybeanMr1.m4744a(i, i2, i3, rect, rect2, i4);
        }

        public final void mo357a(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6) {
            GravityCompatJellybeanMr1.m4743a(i, i2, i3, rect, i4, i5, rect2, i6);
        }
    }

    /* compiled from: privacy_option_invalid_icon_null */
    interface GravityCompatImpl {
        int mo356a(int i, int i2);

        void mo357a(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6);

        void mo358a(int i, int i2, int i3, Rect rect, Rect rect2, int i4);
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f4214a = new GravityCompatImplJellybeanMr1();
        } else {
            f4214a = new GravityCompatImplBase();
        }
    }

    public static void m4736a(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        f4214a.mo358a(i, i2, i3, rect, rect2, i4);
    }

    public static void m4735a(int i, int i2, int i3, Rect rect, int i4, int i5, Rect rect2, int i6) {
        f4214a.mo357a(i, i2, i3, rect, i4, i5, rect2, i6);
    }

    public static int m4734a(int i, int i2) {
        return f4214a.mo356a(i, i2);
    }
}
