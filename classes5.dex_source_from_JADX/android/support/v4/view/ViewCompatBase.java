package android.support.v4.view;

import android.content.res.ColorStateList;
import android.view.View;
import java.lang.reflect.Field;

/* compiled from: videoRecordingCompleted  */
class ViewCompatBase {
    private static Field f350a;
    private static Field f351b;

    ViewCompatBase() {
    }

    static void m410a(View view, ColorStateList colorStateList) {
        if (view instanceof TintableBackgroundView) {
            ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static int m411b(View view) {
        if (f350a == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                f350a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
        }
        if (f350a != null) {
            try {
                return ((Integer) f350a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int m412c(View view) {
        if (f351b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                f351b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
        }
        if (f351b != null) {
            try {
                return ((Integer) f351b.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }
}
