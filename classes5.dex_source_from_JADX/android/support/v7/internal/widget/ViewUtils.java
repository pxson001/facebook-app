package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.facebook.R;
import java.lang.reflect.Method;

/* compiled from: uiZoomControls */
public class ViewUtils {
    private static Method f1260a;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                f1260a = declaredMethod;
                if (!declaredMethod.isAccessible()) {
                    f1260a.setAccessible(true);
                }
            } catch (NoSuchMethodException e) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    private ViewUtils() {
    }

    public static boolean m1756a(View view) {
        return ViewCompat.h(view) == 1;
    }

    public static int m1753a(int i, int i2) {
        return i | i2;
    }

    public static void m1755a(View view, Rect rect, Rect rect2) {
        if (f1260a != null) {
            try {
                f1260a.invoke(view, new Object[]{rect, rect2});
            } catch (Throwable e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    public static void m1757b(View view) {
        if (VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (NoSuchMethodException e) {
                Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            } catch (Throwable e2) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
            } catch (Throwable e22) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e22);
            }
        }
    }

    public static Context m1754a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.View, 0, 0);
        if (z) {
            resourceId = obtainStyledAttributes.getResourceId(0, 0);
        } else {
            resourceId = 0;
        }
        if (z2 && r0 == 0) {
            resourceId = obtainStyledAttributes.getResourceId(4, 0);
            if (resourceId != 0) {
                Log.i("ViewUtils", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        if (i == 0) {
            return context;
        }
        if ((context instanceof ContextThemeWrapper) && ((ContextThemeWrapper) context).f708a == i) {
            return context;
        }
        return new ContextThemeWrapper(context, i);
    }
}
