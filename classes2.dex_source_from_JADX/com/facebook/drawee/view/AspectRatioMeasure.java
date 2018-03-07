package com.facebook.drawee.view;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import javax.annotation.Nullable;

/* compiled from: messenger_android_quickcam_cropped_whitelist */
public class AspectRatioMeasure {

    /* compiled from: messenger_android_quickcam_cropped_whitelist */
    public class Spec {
        public int f14179a;
        public int f14180b;
    }

    public static void m20534a(Spec spec, float f, @Nullable LayoutParams layoutParams, int i, int i2) {
        if (f > 0.0f && layoutParams != null) {
            if (m20535a(layoutParams.height)) {
                spec.f14180b = MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (MeasureSpec.getSize(spec.f14179a) - i)) / f) + ((float) i2)), spec.f14180b), 1073741824);
            } else if (m20535a(layoutParams.width)) {
                spec.f14179a = MeasureSpec.makeMeasureSpec(View.resolveSize((int) ((((float) (MeasureSpec.getSize(spec.f14180b) - i2)) * f) + ((float) i)), spec.f14179a), 1073741824);
            }
        }
    }

    private static boolean m20535a(int i) {
        return i == 0 || i == -2;
    }
}
