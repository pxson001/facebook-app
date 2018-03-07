package com.facebook.components.fallback;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.facebook.components.Size;
import com.facebook.components.SizeSpec;

/* compiled from: creativecam_entry */
public abstract class FallbackViewCreator<V extends View> {
    public abstract V mo1573a(Context context);

    public static void m20654a(V v, int i, int i2, Size size) {
        if (v == null) {
            throw new IllegalStateException("The view to measure cannot be null");
        }
        if (v.getLayoutParams() == null) {
            v.setLayoutParams(new LayoutParams(-2, -2));
        }
        v.measure(m20653a(i), m20653a(i2));
        size.a = v.getMeasuredWidth();
        size.b = v.getMeasuredHeight();
    }

    private static int m20653a(int i) {
        int i2 = 1073741824;
        int b = SizeSpec.b(i);
        if (SizeSpec.a(i) != 1073741824) {
            i2 = 0;
        }
        return MeasureSpec.makeMeasureSpec(b, i2);
    }
}
