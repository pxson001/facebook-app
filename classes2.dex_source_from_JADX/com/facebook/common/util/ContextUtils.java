package com.facebook.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: versions */
public class ContextUtils {
    public static <T> T m2500a(Context context, Class<? extends T> cls) {
        T t = context;
        while (!cls.isInstance(t)) {
            if (!(t instanceof ContextWrapper)) {
                return null;
            }
            T baseContext = ((ContextWrapper) t).getBaseContext();
            if (t == baseContext) {
                return null;
            }
            t = baseContext;
        }
        return t;
    }

    public static Context m2497a(Context context) {
        if (!(context instanceof Activity)) {
            return context;
        }
        Activity activity = (Activity) context;
        if (activity.getParent() instanceof Activity) {
            return activity.getParent();
        }
        return context;
    }

    public static Context m2498a(Context context, int i, int i2) {
        return new ContextThemeWrapper(context, m2501b(context, i, i2));
    }

    public static int m2501b(Context context, int i, int i2) {
        Optional a = m2499a(context, i);
        if (a.isPresent()) {
            return ((Integer) a.get()).intValue();
        }
        return i2;
    }

    public static Optional<Integer> m2499a(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return Optional.of(Integer.valueOf(typedValue.resourceId));
        }
        return Absent.INSTANCE;
    }

    public static int m2503c(Context context, int i, int i2) {
        Optional b = m2502b(context, i);
        if (b.isPresent()) {
            return ((Integer) b.get()).intValue();
        }
        return i2;
    }

    public static Optional<Integer> m2502b(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return Optional.of(Integer.valueOf(typedValue.data));
        }
        return Absent.INSTANCE;
    }

    public static int m2504d(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return typedValue.data;
        }
        return i2;
    }

    public static int m2506e(Context context, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return i2;
    }

    public static Optional<Drawable> m2505d(Context context, int i) {
        Resources resources = context.getResources();
        Optional a = m2499a(context, i);
        if (a.isPresent()) {
            return Optional.of(resources.getDrawable(((Integer) a.get()).intValue()));
        }
        return Absent.INSTANCE;
    }

    public static Drawable m2508f(Context context, int i, int i2) {
        Optional d = m2505d(context, i);
        if (d.isPresent()) {
            return (Drawable) d.get();
        }
        return context.getResources().getDrawable(i2);
    }

    public static Optional<CharSequence> m2507e(Context context, int i) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i, typedValue, true)) {
            return Optional.of(typedValue.string);
        }
        return Absent.INSTANCE;
    }
}
