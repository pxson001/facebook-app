package android.support.v4.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* compiled from: sponsored_context */
public class ContextCompat {
    public static final Drawable m7854a(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        return context.getResources().getDrawable(i);
    }

    public static final int m7855b(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }
}
